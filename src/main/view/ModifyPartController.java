/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view;

import com.sun.deploy.cache.Cache;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
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
    private RadioButton InhouseRadioButton;
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
    private TextField CompanyNameField;
    @FXML
    private Label CompanyName;
    @FXML
    private TextField PartMachineID;
    @FXML
    private Label MachineID1;
    @FXML
    private Button SaveButton;
    @FXML
    private Button CancelButton;
    private Stage dialogStage;
    private boolean okClicked = false;
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
    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }
    public boolean isOkClicked(){
        return okClicked;
    }
    @FXML
    private void InhouseRadioButtonHandler(ActionEvent event) {
        CompanyName.setVisible(false);
        CompanyNameField.setVisible(false);
        MachineID1.setVisible(true);
        PartMachineID.setVisible(true);
    }

    @FXML
    private void outsourcedRadioButtonHandler(ActionEvent event) {
        CompanyName.setVisible(true);
        CompanyNameField.setVisible(true);
        MachineID1.setVisible(false);
        PartMachineID.setVisible(false);
    }

    @FXML
    private void saveButtonHandler(ActionEvent event) throws IOException {
        if(InhouseRadioButton.isSelected()){
            InHousePart.setId(Integer.parseInt(PartID.getText()));
            InHousePart.setName(PartName.getText());
            InHousePart.setPrice(Double.parseDouble(PartPrice.getText()));
            InHousePart.setStock(Integer.parseInt(PartInv.getText()));
            InHousePart.setMin(Integer.parseInt(PartMin.getText()));
            InHousePart.setMax(Integer.parseInt(PartMax.getText()));
            InHousePart.setMachineId(Integer.parseInt(PartMachineID.getText()));
            okClicked = true;
            dialogStage.close();
          
        }
        else{
            OutsourcedPart.setId(Integer.parseInt(PartID.getText()));
            OutsourcedPart.setName(PartName.getText());
            OutsourcedPart.setPrice(Double.parseDouble(PartPrice.getText()));
            OutsourcedPart.setStock(Integer.parseInt(PartInv.getText()));
            OutsourcedPart.setMin(Integer.parseInt(PartMin.getText()));
            OutsourcedPart.setMax(Integer.parseInt(PartMax.getText()));
            OutsourcedPart.setCompanyId(CompanyNameField.getText());
            okClicked = true;
            dialogStage.close();
           
        }
        

        
    }

    @FXML
    private void cancelButtonHandler(ActionEvent event) {
        dialogStage.close();
    }
   //these are your setPerson
    public void initDataInHouse(InHouse part) {
            this.InHousePart = part;
            PartID.setText(Integer.toString(part.getId()));
            PartName.setText(part.getName());
            PartInv.setText(Integer.toString(part.getStock()));
            PartPrice.setText(Double.toString(part.getPrice()));
            PartMax.setText(Integer.toString(part.getMax()));
            PartMin.setText(Integer.toString(part.getMin()));
            PartMachineID.setText(Integer.toString(part.getMachineId()));
            

            }
    
    public void initDataOutsourced(Outsourced part) {
            this.OutsourcedPart = part;
            PartID.setText(Integer.toString(part.getId()));
            PartName.setText(part.getName());
            PartInv.setText(Integer.toString(part.getStock()));
            PartPrice.setText(Double.toString(part.getPrice()));
            PartMax.setText(Integer.toString(part.getMax()));
            PartMin.setText(Integer.toString(part.getMin()));
            CompanyName.setText(part.getCompanyId());
            OutscourcedRadioButton.setSelected(true);
    
    }

}
