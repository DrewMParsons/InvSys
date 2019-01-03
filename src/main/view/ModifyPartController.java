package main.view;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import static main.exceptions.Validations.isInputValid;
import static main.exceptions.Validations.numberAlert;
import static main.exceptions.Validations.partValidation;
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
    private Part tempPart;
    private InHouse InHousePart = new InHouse();
    private Outsourced OutsourcedPart = new Outsourced();
    private int index;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
     * When save button is pressed, saves the data entered in the fields to a
     * new item, and replaces the previously loaded item in the Inventory
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void saveButtonHandler(ActionEvent event) {

        if (partValidation(tempPart, PartName, PartInv, PartPrice, PartMin, PartMax)) {
            
            

            if (InHouseRadioButton.isSelected()) {
                InHousePart.setId(tempPart.getId());
                InHousePart.setName(tempPart.getName());
                InHousePart.setStock(tempPart.getStock());
                InHousePart.setPrice(tempPart.getPrice());
                InHousePart.setMin(tempPart.getMin());
                InHousePart.setMax(tempPart.getMax());

                if (isInputValid(PartOtherID, "Machine ID field must be Entered")) {
                    try {
                        InHousePart.setMachineId(Integer.parseInt(PartOtherID.getText()));
                        data.getAllParts().remove(index);
                        data.modifyPart(InHousePart);
                    } catch (NumberFormatException e) {
                        numberAlert("Machine ID must be a number");
                        return;
                    }
                } else {
                    return;
                }
                
            } else {
                OutsourcedPart.setId(tempPart.getId());
                OutsourcedPart.setName(tempPart.getName());
                OutsourcedPart.setStock(tempPart.getStock());
                OutsourcedPart.setPrice(tempPart.getPrice());
                OutsourcedPart.setMin(tempPart.getMin());
                OutsourcedPart.setMax(tempPart.getMax());
                
                if (isInputValid(PartOtherID, "Company Name field must be Entered")) {

                    OutsourcedPart.setCompanyId(PartOtherID.getText());
                    data.getAllParts().remove(index);
                    data.modifyPart(OutsourcedPart);
                    
                } else {
                    return;
                }

            }
            
            SaveButton.getScene().getWindow().hide();
        }
//        String id = PartID.getText();
//        String name = PartName.getText();
//        String price = PartPrice.getText();
//        String inv = PartInv.getText();
//        String max = PartMax.getText();
//        String min = PartMin.getText();
//        String other = PartOtherID.getText();
//        data.getAllParts().remove(index);
//        if(InHouseRadioButton.isSelected()){
//            
//            data.modifyPart(new InHouse(Integer.parseInt(id),
//                name,
//                Double.parseDouble(price),
//                Integer.parseInt(inv),
//                Integer.parseInt(max),
//                Integer.parseInt(min),
//                Integer.parseInt(other)
//        ));
//            
//        }
//        else{
//            data.modifyPart(new Outsourced(Integer.parseInt(id),
//                name,
//                Double.parseDouble(price),
//                Integer.parseInt(inv),
//                Integer.parseInt(max),
//                Integer.parseInt(min),
//                other));
//            
//        }
//        SaveButton.getScene().getWindow().hide();
    }

    @FXML
    private void cancelButtonHandler(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Confirming!");
        alert.setContentText("Are you sure you wish to cancel?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            CancelButton.getScene().getWindow().hide();
        }
    }

    /**
     * Sets the fields for the part to be modified it is type InHouse
     *
     * @param part
     */
    public void initDataInHouse(Part part) {

        this.tempPart = (Part) part;
        PartID.setText(Integer.toString(part.getId()));
        PartName.setText(part.getName());
        PartInv.setText(Integer.toString(part.getStock()));
        PartPrice.setText(Double.toString(part.getPrice()));
        PartMax.setText(Integer.toString(part.getMax()));
        PartMin.setText(Integer.toString(part.getMin()));
        if (part instanceof InHouse) {
            PartOtherID.setText(Integer.toString(((InHouse) part).getMachineId()));
        } else {
            PartOtherID.setText(((Outsourced) part).getCompanyId());
        }

//        } else {
//            //OutscourcedRadioButton.setSelected(true);
//            //this.tempPart = (Outsourced) part;
//            PartID.setText(Integer.toString(part.getId()));
//            PartName.setText(part.getName());
//            PartInv.setText(Integer.toString(part.getStock()));
//            PartPrice.setText(Double.toString(part.getPrice()));
//            PartMax.setText(Integer.toString(part.getMax()));
//            PartMin.setText(Integer.toString(part.getMin()));
//            
//
//        }
    }

    /**
     * Sets the fields for the part to be modified it is type Outsourced
     *
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

    public void setRadioButton(boolean b, Part part) {
        if (b) {
            InHouseRadioButton.setSelected(true);
            OtherID.setText("Machine ID");
            PartOtherID.setText(Integer.toString(((InHouse) part).getMachineId()));

        } else {
            OutscourcedRadioButton.setSelected(true);
            OtherID.setText("Company Name");
            PartOtherID.setText(((Outsourced) part).getCompanyId());
        }

    }

}
