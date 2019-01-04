package main.view;

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
import static main.exceptions.Validations.*;
import main.model.*;

/**
 * FXML Controller class
 *
 * @author Drew
 */
public class AddPartController  implements Initializable {

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
    private InHouse inHousePart = new InHouse();
    private Outsourced outsourced = new Outsourced();

    

    public Inventory getData() {
        return data;
    }

    public void setData(Inventory data) {
        this.data = data;
    }

    /**
     * initializes the controller class
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        InHouseRadioButton.setSelected(true);
        
        PartID.setText("0");
        PartInv.setText("0");

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
     * depending on which radio button is selected several checks from
     * main.exceptions.Validations are made to ensure valid data entry
     *
     * @param event
     */
    @FXML
    private void saveButtonHandler(ActionEvent event) {
        
        if (InHouseRadioButton.isSelected()){
            if (partValidation(inHousePart, PartName, PartInv, PartPrice, PartMin, PartMax)){
                if (isInputValid(PartOtherID, "Machine ID field must be Entered")) {
                    try {
                        inHousePart.setMachineId(Integer.parseInt(PartOtherID.getText()));
                        data.addPart(inHousePart);
                        SaveButton.getScene().getWindow().hide();
                    } catch (NumberFormatException e) {
                        errorAlert("Machine ID must be a number");
                        return;
                    }
                } else {
                    return;
                }
            } 
            
        } else{
            if (partValidation(outsourced, PartName, PartInv, PartPrice, PartMin, PartMax)){
                if (isInputValid(PartOtherID, "Machine ID field must be Entered")) {
                    try {
                        inHousePart.setMachineId(Integer.parseInt(PartOtherID.getText()));
                        data.addPart(inHousePart);
                        SaveButton.getScene().getWindow().hide();
                    } catch (NumberFormatException e) {
                        errorAlert("Machine ID must be a number");
                        return;
                    }
                } else {
                    return;
                }
            }
            
        }
        
    }
        


    @FXML
    private void cancelButtonHandler(ActionEvent event) {
        if (cancelAlert()) {
            CancelButton.getScene().getWindow().hide();
        }

    }

}
