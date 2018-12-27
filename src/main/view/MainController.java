package main.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.model.InHouse;
import main.model.Inventory;
import main.model.Outsourced;
import main.model.Part;
import main.model.Product;

public class MainController implements Initializable{

    @FXML
    private Button SearchPartsButton;

    @FXML
    private TextField SearchPartsField;

    @FXML
    private TableView<Part> PartsTable;

    @FXML
    private TableColumn<Part, ?> PartID;

    @FXML
    private TableColumn<Part, ?> PartName;

    @FXML
    private TableColumn<Part, ?> PartInv;

    @FXML
    private TableColumn<Part, ?> PartPrice;

    @FXML
    private Button AddPartButton;

    @FXML
    private Button ModifyPartButton;

    @FXML
    private Button DeletePartButton;

    @FXML
    private Button SearchProductsButton;

    @FXML
    private TextField SearchProductsField;

    @FXML
    private TableView<?> ProductsTable;

    @FXML
    private TableColumn<?, ?> ProductID;

    @FXML
    private TableColumn<?, ?> ProiductName;

    @FXML
    private TableColumn<?, ?> ProductInv;

    @FXML
    private TableColumn<?, ?> ProductPrice;

    @FXML
    private Button AddProductButton;

    @FXML
    private Button ModifyProductButton;

    @FXML
    private Button DeleteProductButton;

    @FXML
    private Button ExitButton;
    ObservableList<Part> allParts = FXCollections.observableArrayList();
    ObservableList<Product> allProducts = FXCollections.observableArrayList();
    Inventory systemInventory = new Inventory(allParts, allProducts);
    @FXML
    void ExitButtonHandler(ActionEvent event) {

    }

    @FXML
    void SearchPartsButtonHandler(ActionEvent event) {

    }

    @FXML
    void SearchProductsButtonHandler(ActionEvent event) {

    }

    @FXML
    void addPartButtonHandler(ActionEvent event) {

    }

    @FXML
    void addProductButtonHandler(ActionEvent event) {

    }

    @FXML
    void deletePartButtonHandler(ActionEvent event) {

    }

    @FXML
    void deleteProductButtonHandler(ActionEvent event) {

    }

    @FXML
    void modifyPartButtonHandler(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((getClass().getResource("ModifyPart.fxml")));
        Parent tableViewParent = loader.load();
        
        
        Scene tableViewScene = new Scene(tableViewParent); 
        
        //access controller and call a method
        ModifyPartController controller = loader.getController();
        
        //returns the person object that is currently selected
        controller.initData(PartsTable.getSelectionModel().getSelectedItem());
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

    }

    @FXML
    void modifyProductButtonHandler(ActionEvent event) {

    }
    
    
    public ObservableList createPartsList(){
        
        systemInventory.addPart(new Outsourced(0, "chain", 5, 1, 10, 2, "ChainDudes"));
        systemInventory.addPart(new InHouse(1, "horn", 2, 3, 1, 90, 1));
        
        return (systemInventory.getAllParts());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        //set up columns for Parts Table
        PartID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        PartName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        PartPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        PartInv.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        
        
        //load test data
       
        
        PartsTable.setItems(createPartsList());
    }

}
