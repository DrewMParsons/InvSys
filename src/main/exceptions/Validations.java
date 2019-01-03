/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.exceptions;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import main.model.Part;

/**
 *
 * @author Drew
 */
public class Validations {
    
    //methods
   
    /**
     * Tests that the value of a textfield is not empty or null.  Alert dialog 
     * is opened and value is set to "0"
     * @param textField
     * @param alertText
     * @return 
     */
   public static boolean isInputValid(TextField textField, String alertText){
        boolean b = false;
        if(!(textField.getText()==null || textField.getText().isEmpty())){
            
            b=true;
        }
        else{
            textField.setText("0");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(alertText);
            Optional<ButtonType> result = alert.showAndWait();
        }
        return b;
   }
   /**
    * Basic Alert Error dialog is opened
    * 
    * @param alertText 
    */
   public static void numberAlert(String alertText){
       Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(alertText);
            Optional<ButtonType> result = alert.showAndWait();
   }
   
//   public static isInputNumber(TextField textField, String alertText){
//       boolean b = false;
//       if((Integer.parseInt(textField.getText())))
//       
//       
//   }
   //CREATE MORE VALIDATION FIELDS
}
