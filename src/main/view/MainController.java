package main.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
    private TableColumn<Part, Integer> PartID;

    @FXML
    private TableColumn<Part, String> PartName;

    @FXML
    private TableColumn<Part, Integer> PartInv;

    @FXML
    private TableColumn<Part, Double> PartPrice;

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
    private TableColumn<Product, Integer> ProductID;

    @FXML
    private TableColumn<Product, String> ProductName;

    @FXML
    private TableColumn<Product, Integer> ProductInv;

    @FXML
    private TableColumn<Product, Double> ProductPrice;

    @FXML
    private Button AddProductButton;

    @FXML
    private Button ModifyProductButton;

    @FXML
    private Button DeleteProductButton;

    @FXML
    private Button ExitButton;

    private InventorySystem invSys;

    public MainController() {

    }

    /**
     * method enables the Modify/Delete Parts Button after a row is selected
     */
    public void clickedOnPartsTable() {
        this.ModifyPartButton.setDisable(false);
        this.DeletePartButton.setDisable(false);
    }

    /**
     * method enables the Modify/Delete Product Button after a row is selected
     */
    public void clickedOnProductTable() {
        this.ModifyProductButton.setDisable(false);
        this.DeleteProductButton.setDisable(false);
    }

    @FXML
    void ExitButtonHandler(ActionEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();

    }

    @FXML
    void SearchPartsButtonHandler(ActionEvent event) {
        Part search = invSys.systemInventory.lookupPart(SearchPartsField.getText());
        if (search != null) {
            PartsTable.scrollTo(search);
            PartsTable.getSelectionModel().select(search);

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error");
            alert.setContentText("Part: " + SearchPartsField.getText() + " not found");

            alert.showAndWait();
        }

    }

    @FXML
    void SearchProductsButtonHandler(ActionEvent event) {
        Product search = invSys.systemInventory.lookupProduct(SearchProductsField.getText());
        if (search != null) {
            ProductsTable.scrollTo(search);
            ProductsTable.getSelectionModel().select(search);
            

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error");
            alert.setContentText("Product: " + SearchProductsField.getText() + " not found");

            alert.showAndWait();
        }
    }

    @FXML
    void addPartButtonHandler(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPart.fxml"));

        Stage stage = new Stage();
        stage.initOwner(AddPartButton.getScene().getWindow());
        stage.setScene(new Scene((Parent) loader.load()));
        AddPartController controller = loader.getController();
        controller.setData(invSys.allParts);

        stage.showAndWait();

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
        Part selectedPart = PartsTable.getSelectionModel().getSelectedItem();
        int index = PartsTable.getSelectionModel().getSelectedIndex();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyPart.fxml"));

        Stage stage = new Stage();
        stage.initOwner(ModifyPartButton.getScene().getWindow());
        stage.setScene(new Scene((Parent) loader.load()));

        ModifyPartController controller = loader.getController();
        controller.setData(invSys.allParts);
        controller.setIndex(index);
        if (selectedPart instanceof InHouse) {
            controller.initDataInHouse(selectedPart);
        } else {
            controller.initDataOutsourced(selectedPart);
        }
        stage.showAndWait();

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

        //setInventorySystem(invSys);
        //Disable the modify/delete buttons until a row is selected
        this.ModifyPartButton.setDisable(true);
        this.ModifyProductButton.setDisable(true);
        this.DeletePartButton.setDisable(true);
        this.DeleteProductButton.setDisable(true);
    }

    public InventorySystem getInvSys() {
        return invSys;
    }

    public void setInventorySystem(InventorySystem invSys) {
        this.invSys = invSys;
        PartsTable.setItems(invSys.systemInventory.getAllParts());
        ProductsTable.setItems(invSys.systemInventory.getAllProducts());
    }
    
    public void highlightOnSearch(){
        
    }

}
