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
import main.model.Inventory;
import main.model.Product;

/**
 * FXML Controller class
 *
 * @author Drew
 */
public class AddProductController implements Initializable {

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
    private TableView<?> AddPartTable;
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
    private TableView<?> DeletePartTable;
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

    private Inventory data;

    public Inventory getData() {
        return data;
    }

    public void setData(Inventory data) {
        this.data = data;
    }

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
        String name = GetProductName.getText();
        String inv = GetProductInv.getText();
        String price = GetProductPrice.getText();
        String max = GetProductMax.getText();
        String min = GetProductMin.getText();

        data.addProduct(new Product(name,
                Integer.parseInt(inv),
                Double.parseDouble(price),
                Integer.parseInt(max),
                Integer.parseInt(min)));
        SaveButton.getScene().getWindow().hide();

    }

    @FXML
    private void cancelButtonHandler(ActionEvent event) {
        CancelButton.getScene().getWindow().hide();
    }

    @FXML
    private void searchButtonHandler(ActionEvent event) {
    }

}
