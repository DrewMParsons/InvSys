/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import main.model.InHouse;
import main.model.Inventory;
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
    private Inventory data;
    private Part part;
    private InHouse InHousePart;
    private Outsourced OutsourcedPart;
    private int index;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Inventory getData() {
        return data;
    }

    public void setData(Inventory data) {
        this.data = data;
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
    
    /**
     * When save button is pressed, saves the data entered in the fields to 
     * a new item, and replaces the previously loaded item in the arraylist
     * @param event
     * @throws IOException 
     */

    @FXML
    private void saveButtonHandler(ActionEvent event) throws IOException {
        String id = PartID.getText();
        String name = PartName.getText();
        String price = PartPrice.getText();
        String inv = PartInv.getText();
        String max = PartMax.getText();
        String min = PartMin.getText();
        String other = PartOtherID.getText();
        data.getAllParts().remove(index);
        if(InHouseRadioButton.isSelected()){
            
            data.modifyPart(new InHouse(Integer.parseInt(id),
                name,
                Double.parseDouble(price),
                Integer.parseInt(inv),
                Integer.parseInt(max),
                Integer.parseInt(min),
                Integer.parseInt(other)
        ));
            
        }
        else{
            data.modifyPart(new Outsourced(Integer.parseInt(id),
                name,
                Double.parseDouble(price),
                Integer.parseInt(inv),
                Integer.parseInt(max),
                Integer.parseInt(min),
                other));
            
        }
        SaveButton.getScene().getWindow().hide();
    }

    @FXML
    private void cancelButtonHandler(ActionEvent event) {
        CancelButton.getScene().getWindow().hide();
    }
   /**
    * Sets the fields for the part to be modified it is type InHouse
    * @param part 
    */
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
     /**
    * Sets the fields for the part to be modified it is type Outsourced
    * @param part 
    */
    
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
