/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view;

import java.io.IOException;
import java.net.URL;
import java.nio.file.attribute.AclEntryType;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import main.model.*;

/**
 * FXML Controller class
 *
 * @author Drew
 */
public class AddPartController implements Initializable {

    @FXML
    private RadioButton InHouseRadioButton;

    @FXML
    private ToggleGroup AddPart;

    @FXML
    private RadioButton OutscourcedRadioButton;

    @FXML
    private TextField PartID;

    @FXML
    private TextField PartName;

    @FXML
    private TextField PartInv;

    @FXML
    private TextField PartPrice;

    @FXML
    private TextField PartMax;

    @FXML
    private TextField PartMin;

    @FXML
    private TextField PartOtherID;

    @FXML
    private Label OtherID;

    @FXML
    private Button SaveButton;

    @FXML
    private Button CancelButton;

    private Part part;
    private InHouse InHousePart;
    private Outsourced OutsourcedPart;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        InHouseRadioButton.setSelected(true);
        
        
        

    }

    @FXML
    private void InHouseRadioButtonHandler(ActionEvent event) {
        OtherID.setText("Machine ID");
        PartOtherID.setPromptText("Machine ID");
    }

    @FXML
    private void outsourcedRadioButtonHandler(ActionEvent event) {
        OtherID.setText("Company Name");
        PartOtherID.setPromptText("Company Name");
    }

    @FXML
    private void saveButtonHandler(ActionEvent event) throws IOException {
        
        if (InHouseRadioButton.isSelected()) {
            InHousePart.setId(Integer.parseInt(PartID.getText()));
            InHousePart.setName(PartName.getText());
            InHousePart.setPrice(Double.parseDouble(PartPrice.getText()));
            InHousePart.setStock(Integer.parseInt(PartInv.getText()));
            InHousePart.setMin(Integer.parseInt(PartMin.getText()));
            InHousePart.setMax(Integer.parseInt(PartMax.getText()));
            InHousePart.setMachineId(Integer.parseInt(PartOtherID.getText()));

        } else {
            OutsourcedPart.setId(Integer.parseInt(PartID.getText()));
            OutsourcedPart.setName(PartName.getText());
            OutsourcedPart.setPrice(Double.parseDouble(PartPrice.getText()));
            OutsourcedPart.setStock(Integer.parseInt(PartInv.getText()));
            OutsourcedPart.setMin(Integer.parseInt(PartMin.getText()));
            OutsourcedPart.setMax(Integer.parseInt(PartMax.getText()));
            OutsourcedPart.setCompanyId(PartOtherID.getText());

        }
        SaveButton.getScene().getWindow().hide();
    }

    @FXML
    private void cancelButtonHandler(ActionEvent event) throws IOException {
        CancelButton.getScene().getWindow().hide();

    }

    public void initDataInHouse(Part part) {
        this.InHousePart = (InHouse) part;
        PartID.setText("");
        PartName.setText("");
        PartInv.setText("");
        PartPrice.setText("");
        PartMax.setText("");
        PartMin.setText("");
        PartOtherID.setText("");

    }

    public void initDataOutsourced(Part part) {
        this.OutsourcedPart = (Outsourced) part;
        PartID.setText("");
        PartName.setText("");
        PartInv.setText("");
        PartPrice.setText("");
        PartMax.setText("");
        PartMin.setText("");
        PartOtherID.setText("");
        OutscourcedRadioButton.setSelected(true);

    }

}
