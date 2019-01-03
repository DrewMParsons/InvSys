package main.view;

import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.util.converter.IntegerStringConverter;
import main.exceptions.DialogBox;
import main.exceptions.Validations;
import main.model.*;

/**
 * FXML Controller class
 *
 * @author Drew
 */
public class AddPartController extends Validations implements Initializable {

    @FXML
    private RadioButton InHouseRadioButton;

    @FXML
    private ToggleGroup AddPart;

    @FXML
    private RadioButton OutscourcedRadioButton;

    @FXML
    private GridPane GridPane;

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
    private Part tempPart;
    private DialogBox confirm;
    private boolean test;

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
        tempPart = new InHouse();
        PartID.setText("0");
        PartInv.setText("0");
//        PartName.setText("");
//        
//        PartPrice.setText("0.0");
//        PartMax.setText("0");
//        PartMin.setText("0");

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

        if (partValidation(tempPart, PartName, PartInv, PartPrice, PartMin, PartMax)) {

            if (InHouseRadioButton.isSelected()) {
                if (isInputValid(PartOtherID, "Machine ID field must be Entered")) {
                    try {
                        ((InHouse) tempPart).setMachineId(Integer.parseInt(PartOtherID.getText()));
                    } catch (NumberFormatException e) {
                        numberAlert("Machine ID must be a number");
                        return;
                    }
                }
                else{
                    return;
                }
            } else {
                if (isInputValid(PartOtherID, "Company Name field must be Entered")) {
                    ((Outsourced) tempPart).setCompanyId(PartOtherID.getText());
                    return;
                } else{
                    return;
                }
               
            }
            data.addPart(tempPart);
            SaveButton.getScene().getWindow().hide();
        }

    }

    @FXML
    private void cancelButtonHandler(ActionEvent event
    ) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Confirming!");
        alert.setContentText("Are you sure you wish to cancel?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            CancelButton.getScene().getWindow().hide();
        }

    }

}
