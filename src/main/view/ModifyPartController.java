/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view;

import com.sun.deploy.cache.Cache;
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
    private void saveButtonHandler(ActionEvent event) {
    }

    @FXML
    private void cancelButtonHandler(ActionEvent event) {
    }
   
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
