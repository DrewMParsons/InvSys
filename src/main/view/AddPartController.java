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
public class AddPartController implements Initializable {

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
    
    private Stage addPartStage;
    private Part newPart;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addNewPart(null);
    }
    public void setPart(Part part) {
        this.newPart = part;
        
    }
    private void addNewPart(Part part) {
        String id = PartID.getText();
        String name = PartName.getText();
        String inv = PartInv.getText();
        String price = PartPrice.getText();
        String max = PartMax.getText();
        String min = PartMin.getText();
        if (InhouseRadioButton.isSelected()) {
            
            String machID = PartMachineID.getText();
            
        } else {
            String compID = CompanyNameField.getText();
        }
        
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
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation((getClass().getResource("Main.fxml")));
//        Parent tableViewParent = loader.load();
//
//        Scene tableViewScene = new Scene(tableViewParent);
//
//        //access controller and call a method
//        MainController controller = loader.getController();
//        addNewPart(newPart);
//        controller.allParts.add(newPart);
//
//        
//
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(tableViewScene);
//        window.show();

    }
    
        
        
    

    @FXML
    private void cancelButtonHandler(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene tableViewScene = new Scene(tableViewParent); 
 
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        
        
    }
    
}
