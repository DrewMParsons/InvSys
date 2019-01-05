package main.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static main.exceptions.Alerts.cancelAlert;
import static main.exceptions.Alerts.deleteAlert;
import static main.exceptions.Alerts.errorAlert;
import static main.exceptions.Alerts.searchAlert;
import static main.exceptions.Validations.*;

import main.model.Inventory;
import main.model.Part;
import main.model.Product;

/**
 * FXML Controller class
 *
 * @author Drew
 */
public class ModifyProductController implements Initializable {

    @FXML
    private TextField productID;
    @FXML
    private TextField GetProductName;
    @FXML
    private TextField GetProductInv;
    @FXML
    private TextField GetProductPrice;
    @FXML
    private TextField GetProductMax;
    @FXML
    private TextField GetProductMin;
    @FXML
    private TableView<Part> AddPartTable;
    @FXML
    private TableColumn<?, ?> AddPartID;
    @FXML
    private TableColumn<?, ?> AddPartName;
    @FXML
    private TableColumn<?, ?> AddPartInv;
    @FXML
    private TableColumn<?, ?> AddPartPrice;
    @FXML
    private Button AddButton;
    @FXML
    private TableView<Part> DeletePartTable;
    @FXML
    private TableColumn<?, ?> DeletePartID;
    @FXML
    private TableColumn<?, ?> DeletePartName;
    @FXML
    private TableColumn<?, ?> DeletePartInv;
    @FXML
    private TableColumn<?, ?> DeletePartPrice;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button SaveButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button SearchButton;
    @FXML
    private TextField SearchField;

    private int index;
    private Product tempProduct;
    private Inventory data;
   

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    public Inventory getData() {
        return data;
    }

    public void setData(Inventory data) {
        this.data = data;
        AddPartTable.setItems(data.getAllParts());
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up columns for Add Part Table
        AddPartID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        AddPartName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        AddPartPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        AddPartInv.setCellValueFactory(new PropertyValueFactory<>("Stock"));

        //set up columns for Delete Part Table
        DeletePartID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        DeletePartName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        DeletePartPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        DeletePartInv.setCellValueFactory(new PropertyValueFactory<>("Stock"));

        
        //sets up listeners for search fields
        SearchField.textProperty().addListener((Observable o) ->
        {
            if(SearchField.textProperty().get().isEmpty())
            {
                AddPartTable.setItems(data.getAllParts());
                return;
            }
            ObservableList<Part> tableItems = FXCollections.observableArrayList();
            ObservableList<TableColumn<Part,?>> cols = AddPartTable.getColumns();
            
            for (int i = 0; i < data.getAllParts().size(); i++)
            {
                for (int j = 0; j < cols.size(); j++)
                {
                    TableColumn col = cols.get(j);
                    String cellvalue = col.getCellData(data.getAllParts().get(i)).toString();
                    cellvalue = cellvalue.toLowerCase();
                    if(cellvalue.contains(SearchField.textProperty().get().toLowerCase()))
                    {
                        tableItems.add(data.getAllParts().get(i));
                        break;
                    }
                    
                }
            }
            AddPartTable.setItems(tableItems);
        });
    }
    

    @FXML
    private void addButtonHandler(ActionEvent event) {
        Part selectedPart = AddPartTable.getSelectionModel().getSelectedItem();
        DeletePartTable.getItems().add(selectedPart);

    }

    @FXML
    private void deleteButtonHandler(ActionEvent event) {
        Part deleteItem = DeletePartTable.getSelectionModel().getSelectedItem();
        if (deleteAlert(deleteItem.getName())) {
            DeletePartTable.getItems().remove(deleteItem);
            tempProduct.getAssociatedParts().remove(deleteItem);
        }
    }

    @FXML
    private void saveButtonHandler(ActionEvent event) {


        if (productValidation(tempProduct, GetProductName, GetProductInv, GetProductPrice, GetProductMin, GetProductMax)) {
            ObservableList<Part> parts = FXCollections.observableArrayList();
            parts.addAll(DeletePartTable.getItems());
            if (parts.isEmpty()) {
                errorAlert("Product must contain at least one part");
                return;
            }
            double sum = 0;
            for (Part p : parts) {

                double price = p.getPrice();
                sum += price;

            }
            if (tempProduct.getPrice() < sum) {
                errorAlert("Product price of: " + tempProduct.getPrice() + " is less than cost of it's parts: " + sum);
                return;
            }
            tempProduct.setAssociatedParts(parts);
       
            data.getAllProducts().remove(index);
            data.modifyProduct(tempProduct);

            SaveButton.getScene().getWindow().hide();

        }

    }

    @FXML
    private void cancelButtonHandler(ActionEvent event) {
        if(cancelAlert()){
            CancelButton.getScene().getWindow().hide();
        }

    }

    @FXML
    private void searchButtonHandler(ActionEvent event) {
        Part search = data.lookupPart(SearchField.getText());
        if (search != null) {
            AddPartTable.scrollTo(search);
            AddPartTable.getSelectionModel().select(search);

        } else {
            searchAlert(SearchField);
            
        }
    }

    void initData(Product product) {
        this.tempProduct = product;
        productID.setText(Integer.toString(product.getId()));
        GetProductName.setText(product.getName());
        GetProductInv.setText(Integer.toString(product.getStock()));
        GetProductPrice.setText(Double.toString(product.getPrice()));
        GetProductMax.setText(Integer.toString(product.getMax()));
        GetProductMin.setText(Integer.toString(product.getMin()));
        DeletePartTable.setItems(product.getAssociatedParts());
    }

}
