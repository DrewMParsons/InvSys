package main.view;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static main.exceptions.Alerts.deleteAlert;
import static main.exceptions.Alerts.errorAlert;
import static main.exceptions.Alerts.searchAlert;
import main.model.InHouse;
import main.model.Part;
import main.model.Product;

public class MainController  implements Initializable {

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
     @Override
    public void initialize(URL location, ResourceBundle resources) {
        //sets up listeners for Parts search field
        SearchPartsField.textProperty().addListener((Observable o) ->
        {
            if(SearchPartsField.textProperty().get().isEmpty())
            {
                PartsTable.setItems(invSys.allParts);
                return;
            }
            ObservableList<Part> tableItems = FXCollections.observableArrayList();
            ObservableList<TableColumn<Part,?>> cols = PartsTable.getColumns();
            
            for (int i = 0; i < invSys.allParts.size(); i++)
            {
                for (int j = 0; j < cols.size(); j++)
                {
                    TableColumn col = cols.get(j);
                    String cellvalue = col.getCellData(invSys.allParts.get(i)).toString();
                    cellvalue = cellvalue.toLowerCase();
                    if(cellvalue.contains(SearchPartsField.textProperty().get().toLowerCase()))
                    {
                        tableItems.add(invSys.allParts.get(i));
                        break;
                    }
                    
                }
            }
            PartsTable.setItems(tableItems);
        });
        //sets up listeners for Product search field
        SearchProductsField.textProperty().addListener((Observable o) ->
        {
            if(SearchProductsField.textProperty().get().isEmpty())
            {
                ProductsTable.setItems(invSys.allProducts);
                return;
            }
            ObservableList<Product> tableItems = FXCollections.observableArrayList();
            ObservableList<TableColumn<Product,?>> cols = ProductsTable.getColumns();
            
            for (int i = 0; i < invSys.allProducts.size(); i++)
            {
                for (int j = 0; j < cols.size(); j++)
                {
                    TableColumn col = cols.get(j);
                    String cellvalue = col.getCellData(invSys.allProducts.get(i)).toString();
                    cellvalue = cellvalue.toLowerCase();
                    if(cellvalue.contains(SearchProductsField.textProperty().get().toLowerCase()))
                    {
                        tableItems.add(invSys.allProducts.get(i));
                        break;
                    }
                    
                }
            }
            ProductsTable.setItems(tableItems);
        });
        
        
        
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

        //Disable the modify/delete buttons until a row is selected
        this.ModifyPartButton.setDisable(true);
        this.ModifyProductButton.setDisable(true);
        this.DeletePartButton.setDisable(true);
        this.DeleteProductButton.setDisable(true);
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

// 
    @FXML
    void SearchPartsButtonHandler(ActionEvent event) {
        
//        Part search = invSys.systemInventory.lookupPart(SearchPartsField.getText());
//        if (search != null) {
//            PartsTable.scrollTo(search);
//            PartsTable.getSelectionModel().select(search);
//
//        } else {
//            searchAlert(SearchPartsField);
//        }

    }

    @FXML
    void SearchProductsButtonHandler(ActionEvent event) {
        Product search = invSys.systemInventory.lookupProduct(SearchProductsField.getText());
        if (search != null) {
            ProductsTable.scrollTo(search);
            ProductsTable.getSelectionModel().select(search);

        } else {
            searchAlert(SearchProductsField);
        }
    }

    @FXML
    void addPartButtonHandler(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPart.fxml"));

        Stage stage = new Stage();
        stage.initOwner(AddPartButton.getScene().getWindow());
        stage.setScene(new Scene((Parent) loader.load()));
        AddPartController controller = loader.getController();
        controller.setData(invSys.systemInventory);

        stage.showAndWait();
        PartsTable.refresh();
        

    }

    @FXML
    void addProductButtonHandler(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProduct.fxml"));

        Stage stage = new Stage();
        stage.initOwner(AddProductButton.getScene().getWindow());
        stage.setScene(new Scene((Parent) loader.load()));
        AddProductController controller = loader.getController();
        controller.setData(invSys.systemInventory);

        stage.showAndWait();
        ProductsTable.refresh();
    }

    @FXML
    void deletePartButtonHandler(ActionEvent event) {
        int index = PartsTable.getSelectionModel().getSelectedIndex();
        String name = PartsTable.getSelectionModel().getSelectedItem().getName();
        if (deleteAlert(name)) {
            PartsTable.getItems().remove(index);
            invSys.allParts.remove(PartsTable.getItems().get(index));
        }

    }

    @FXML
    void deleteProductButtonHandler(ActionEvent event) {
        int index = ProductsTable.getSelectionModel().getSelectedIndex();
        String name = ProductsTable.getSelectionModel().getSelectedItem().getName();
        if (ProductsTable.getSelectionModel().getSelectedItem().getAssociatedParts().isEmpty()) {
        } else {
            errorAlert("Cannot Delete a Product that contains a Part");
            return;
        }
        if (deleteAlert(name)) {
            ProductsTable.getItems().remove(index);
            invSys.allProducts.remove(ProductsTable.getItems().get(index));
        }
       

    }

    @FXML
    void ExitButtonHandler(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Exiting Program");
        alert.setContentText("Are you sure you wish to Exit?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            Stage stage = (Stage) ExitButton.getScene().getWindow();
            stage.close();

        }

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
        if (selectedPart instanceof InHouse) {
            controller.setRadioButton(true, selectedPart);
        } else {
            controller.setRadioButton(false, selectedPart);
        }
        controller.setData(invSys.systemInventory);
        controller.setIndex(index);

        controller.initData(((Part) selectedPart));

        stage.showAndWait();
        PartsTable.refresh();

    }

    @FXML
    void modifyProductButtonHandler(ActionEvent event) throws IOException {
        Product selectedProduct = ProductsTable.getSelectionModel().getSelectedItem();
        int index = ProductsTable.getSelectionModel().getSelectedIndex();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyProduct.fxml"));

        Stage stage = new Stage();
        stage.initOwner(ModifyProductButton.getScene().getWindow());
        stage.setScene(new Scene((Parent) loader.load()));

        ModifyProductController controller = loader.getController();
        controller.setData(invSys.systemInventory);
        controller.setIndex(index);
        controller.initData(selectedProduct);

        stage.showAndWait();
        ProductsTable.refresh();
        

    }

   

    public InventorySystem getInvSys() {
        return invSys;
    }

    public void setInventorySystem(InventorySystem invSys) {
        this.invSys = invSys;
        PartsTable.setItems(invSys.systemInventory.getAllParts());
        ProductsTable.setItems(invSys.systemInventory.getAllProducts());
    }
}
