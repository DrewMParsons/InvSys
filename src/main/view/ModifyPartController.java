/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import main.model.InHouse;
import main.model.Outsourced;
import main.model.Part;

/**
 * FXML Controller class
 *
 * @author Drew
 */
public class ModifyPartController implements Initializable {

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
        // TODO
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
        if(InHouseRadioButton.isSelected()){
            
            InHousePart.setId(Integer.parseInt(PartID.getText()));
            InHousePart.setName(PartName.getText());
            InHousePart.setPrice(Double.parseDouble(PartPrice.getText()));
            InHousePart.setStock(Integer.parseInt(PartInv.getText()));
            InHousePart.setMin(Integer.parseInt(PartMin.getText()));
            InHousePart.setMax(Integer.parseInt(PartMax.getText()));
            InHousePart.setMachineId(Integer.parseInt(PartOtherID.getText()));
           
          
        }
        else{
            
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
    private void cancelButtonHandler(ActionEvent event) {
        CancelButton.getScene().getWindow().hide();
    }
   //these are your setters
    public void initDataInHouse(Part part) {
            this.InHousePart = (InHouse) part;
            PartID.setText(Integer.toString(part.getId()));
            PartName.setText(part.getName());
            PartInv.setText(Integer.toString(part.getStock()));
            PartPrice.setText(Double.toString(part.getPrice()));
            PartMax.setText(Integer.toString(part.getMax()));
            PartMin.setText(Integer.toString(part.getMin()));
            PartOtherID.setText(Integer.toString(InHousePart.getMachineId()));
            InHouseRadioButton.setSelected(true);

            }
    
    public void initDataOutsourced(Part part) {
            this.OutsourcedPart = (Outsourced) part;
            PartID.setText(Integer.toString(part.getId()));
            PartName.setText(part.getName());
            PartInv.setText(Integer.toString(part.getStock()));
            PartPrice.setText(Double.toString(part.getPrice()));
            PartMax.setText(Integer.toString(part.getMax()));
            PartMin.setText(Integer.toString(part.getMin()));
            PartOtherID.setText(OutsourcedPart.getCompanyId());
            OutscourcedRadioButton.setSelected(true);
    
    }

}
