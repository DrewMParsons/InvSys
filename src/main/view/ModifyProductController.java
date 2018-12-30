/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TableView<?> AddProductTable;
    @FXML
    private TableColumn<?, ?> AddProductID;
    @FXML
    private TableColumn<?, ?> AddProductName;
    @FXML
    private TableColumn<?, ?> AddProductInv;
    @FXML
    private TableColumn<?, ?> AddProductPrice;
    @FXML
    private Button AddButton;
    @FXML
    private TableView<?> DeleteProductTable;
    @FXML
    private TableColumn<?, ?> DeleteProductID;
    @FXML
    private TableColumn<?, ?> DeleteProductName;
    @FXML
    private TableColumn<?, ?> DeleteProductInv;
    @FXML
    private TableColumn<?, ?> DeleteProductPrice;
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
    
    private Product product;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addButtonHandler(ActionEvent event) {
    }

    @FXML
    private void deleteButtonHandler(ActionEvent event) {
    }

    @FXML
    private void saveButtonHandler(ActionEvent event) {
    }

    @FXML
    private void cancelButtonHandler(ActionEvent event) {
        CancelButton.getScene().getWindow().hide();
    }

    @FXML
    private void searchButtonHandler(ActionEvent event) {
    }

    void initData(Product product) {
        this.product = product;
            productID.setText(Integer.toString(product.getId()));
            GetProductName.setText(product.getName());
            GetProductInv.setText(Integer.toString(product.getStock()));
            GetProductPrice.setText(Double.toString(product.getPrice()));
            GetProductMax.setText(Integer.toString(product.getMax()));
            GetProductMin.setText(Integer.toString(product.getMin()));
    }
    
}
