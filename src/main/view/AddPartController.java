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
import javafx.collections.ObservableList;
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
    private Inventory data;
    private Part part;
    private InHouse InHousePart;
    private Outsourced OutsourcedPart;

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
        InHouseRadioButton.setSelected(true);

    }

    /**
     * Sets label and prompt text for an InHouse item
     *
     * @param event
     */
    @FXML
    private void InHouseRadioButtonHandler(ActionEvent event) {
        OtherID.setText("Machine ID");
        PartOtherID.setPromptText("Machine ID");
    }

    /**
     * Sets label and prompt text for an Outsourced item
     *
     * @param event
     */
    @FXML
    private void outsourcedRadioButtonHandler(ActionEvent event) {
        OtherID.setText("Company Name");
        PartOtherID.setPromptText("Company Name");
    }

    /**
     * When save button is pressed, the fields are saved into the proper object,
     * depending on which radio button is selected
     *
     * @param event
     */
    @FXML
    private void saveButtonHandler(ActionEvent event) {

        String id = PartID.getText();
        String name = PartName.getText();
        String price = PartPrice.getText();
        String inv = PartInv.getText();
        String max = PartMax.getText();
        String min = PartMin.getText();
        String other = PartOtherID.getText();
        if(InHouseRadioButton.isSelected()){
            data.addPart(new InHouse(
                name,
                Double.parseDouble(price),
                Integer.parseInt(inv),
                Integer.parseInt(max),
                Integer.parseInt(min),
                Integer.parseInt(other)
        ));
            
        }
        else{
            data.addPart(new Outsourced(
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
    private void cancelButtonHandler(ActionEvent event) throws IOException {
        CancelButton.getScene().getWindow().hide();

    }

    /**
     * initializes fields
     *
     * @param part
     */
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
