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
import main.model.InHouse;
import main.model.Outsourced;
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
            //textField.setText("0");
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
   
   /**
    * Validates text fields for Parts  
    * @param part
    * @param name
    * @param inv
    * @param price
    * @param min
    * @param max
    * @return 
    */
   
   public static boolean partValidation(Part part, TextField name, TextField inv, TextField price, TextField min, TextField max ) {
        if (isInputValid(name, "Name must be Entered")) {
            part.setName(name.getText());
        
        } 
        
        if (isInputValid(inv, "Inventory must be Entered")) {
            try {
                part.setStock(Integer.parseInt(inv.getText()));
            } catch (NumberFormatException e) {
                numberAlert("Inventory must be number");
                return false;
            }
        } 
       
        if (isInputValid(min, "Minimum must be Entered")) {
            try {
                part.setMin(Integer.parseInt(min.getText()));
            } catch (NumberFormatException e) {
                numberAlert("Minimum must be number");
                return false;
            }
        }
        if (isInputValid(max, "Maximum must be Entered")) {
            try {
                part.setMax(Integer.parseInt(max.getText()));
            } catch (NumberFormatException e) {
                numberAlert("Maximum must be number");
                return false;
            }
        } 
        if (isInputValid(price, "Price must be Entered")) {
            try {
                part.setPrice(Double.parseDouble(price.getText()));
            } catch (NumberFormatException e) {
                numberAlert("Price must be decimal number");
                return false;
            }
        } 
        if (part.getMax() <= part.getMin()) {
            numberAlert("Maximum must be larger than Minimum");
            return false;
        }
        if (part.getStock() < part.getMin() || part.getStock() > part.getMax()) {
            numberAlert("Inventory must be a number value between Maximum and Minimum");
            return false;
        }
        
        
        
        return true;
    }
       
   
//   public static isInputNumber(TextField textField, String alertText){
//       boolean b = false;
//       if((Integer.parseInt(textField.getText())))
//       
//       
//   }
   //CREATE MORE VALIDATION FIELDS
}
