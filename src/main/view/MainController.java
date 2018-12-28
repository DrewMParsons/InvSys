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
import javafx.scene.control.Alert;
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

public class MainController implements Initializable {

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
    private TableView<Product> ProductsTable;

    @FXML
    private TableColumn<Product, ?> ProductID;

    @FXML
    private TableColumn<Product, ?> ProductName;

    @FXML
    private TableColumn<Product, ?> ProductInv;

    @FXML
    private TableColumn<Product, ?> ProductPrice;

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

    /**
     * method enables the Modify Parts Button  after a row is selected
     */
    public void clickedOnPartsTable(){
        this.ModifyPartButton.setDisable(false);
    }
    /**
     * method enables the Modify Product Button  after a row is selected
     */
    public void clickedOnProductTable(){
        this.ModifyProductButton.setDisable(false);
    }
    
    @FXML
    void ExitButtonHandler(ActionEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();

    }

    @FXML
    void SearchPartsButtonHandler(ActionEvent event) {

    }

    @FXML
    void SearchProductsButtonHandler(ActionEvent event) {
        String searchItem = SearchProductsField.getText();
        boolean found = false;
        try {
            int itemNumber = Integer.parseInt(searchItem);
            for (Product p : allProducts) {
                if (p.getId() == itemNumber) {

                    System.out.println("This is part " + itemNumber);
                    found = true;

                }

            }
            if (found == false) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFO ");
                alert.setHeaderText("error");
                alert.setContentText("Part no found");

                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            for (Product p : allProducts) {
                if (p.getName().equals(searchItem)) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("CONFIRM ");
                    alert.setHeaderText("PRODUCT " + p.getName());
                    alert.setContentText("Product found");

                    alert.showAndWait();
                    System.out.println("this is part " + p.getId());
                    found = true;

                }
            }
            if (found == false) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFO ");
                alert.setHeaderText("error");
                alert.setContentText("Part no found");

                alert.showAndWait();
            }
        }

    }

    @FXML
    void addPartButtonHandler(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AddPart.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        //In Start, the stage is passed through as a param.  here we need to get it
        //the action event(event) doesnt know what type of object is returned, so we tell it the return is of type node
        //BCS its a Node, we cam then get the scene and window, 
        //Then cast that as a Stage, and assign to our Stage(window)
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        AddPartController controller = new AddPartController();
        window.setScene(tableViewScene);
        
        
        window.showAndWait();

    }

    @FXML
    void addProductButtonHandler(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AddProduct.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void deletePartButtonHandler(ActionEvent event) {
        int index = PartsTable.getSelectionModel().getSelectedIndex();
        PartsTable.getItems().remove(index);

    }

    @FXML
    void deleteProductButtonHandler(ActionEvent event) {
        int index = ProductsTable.getSelectionModel().getSelectedIndex();
        ProductsTable.getItems().remove(index);

    }

    @FXML
    void modifyPartButtonHandler(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((getClass().getResource("ModifyPart.fxml")));
        Parent tableViewParent = loader.load();

        Scene tableViewScene = new Scene(tableViewParent);

        //access controller and call a method
        ModifyPartController controller = loader.getController();

        //use instance of to check if inhouse, then cast back to part
        //returns the person object that is currently selected
        Part selectedPart = PartsTable.getSelectionModel().getSelectedItem();
        if (selectedPart instanceof InHouse) {
           
            controller.initDataInHouse((InHouse) selectedPart);
           

        } else {
            controller.initDataOutsourced((Outsourced) selectedPart);
        }

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

    }

    @FXML
    void modifyProductButtonHandler(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((getClass().getResource("ModifyProduct.fxml")));
        Parent tableViewParent = loader.load();

        Scene tableViewScene = new Scene(tableViewParent);

        //access controller and call a method
        ModifyProductController controller = loader.getController();
        

        //returns the  object that is currently selected
        controller.initData(ProductsTable.getSelectionModel().getSelectedItem());

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

    }

    //dummy info to test Parts table
    public ObservableList createPartsList() {

        systemInventory.addPart(new Outsourced(0, "chain", 5, 1, 10, 2, "ChainDudes"));
        systemInventory.addPart(new InHouse(1, "horn", 2, 3, 1, 90, 1));

        return (systemInventory.getAllParts());
    }

    //dummy info to test Product table
    public ObservableList createProductList() {
        systemInventory.addProduct(new Product(1, "bike", 500, 4, 1, 20));
        systemInventory.addProduct(new Product(2, "trike", 400, 1, 1, 3));

        return systemInventory.getAllProducts();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //set up columns for Parts Table
        PartID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        PartName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        PartPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        PartInv.setCellValueFactory(new PropertyValueFactory<>("Stock"));

        //set up columns for Product Table
        ProductID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        ProductName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        ProductPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        ProductInv.setCellValueFactory(new PropertyValueFactory<>("Stock"));

        //load test data
        ProductsTable.setItems(createProductList());
        PartsTable.setItems(createPartsList());
        
        //Disable the modify buttons until a row is selected
        this.ModifyPartButton.setDisable(true);
        this.ModifyProductButton.setDisable(true);
    }

}
