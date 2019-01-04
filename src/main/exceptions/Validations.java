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
import main.model.Product;

/**
 *
 * @author Drew
 */
public class Validations {

    //methods
    /**
     * Tests that the value of a textfield is not empty or null. Alert dialog is
     * opened and value is set to "0"
     *
     * @param textField
     * @param alertText
     * @return
     */
    public static boolean isInputValid(TextField textField, String alertText) {
        boolean b = false;
        if (!(textField.getText() == null || textField.getText().isEmpty())) {

            b = true;
        } else {

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
    public static void errorAlert(String alertText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(alertText);
        Optional<ButtonType> result = alert.showAndWait();
    }

    /**
     * Alert used when cancel button is pressed
     *
     * @return
     */
    public static boolean cancelAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Confirming!");
        alert.setContentText("Are you sure you wish to cancel?");

        Optional<ButtonType> result = alert.showAndWait();

        return result.get() == ButtonType.OK;

    }

    /**
     * Alert dialog used when deleting an item
     *
     * @param name
     * @return
     */
    public static boolean deleteAlert(String name) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Warning Dialog");
        alert.setHeaderText("Deleting!");
        alert.setContentText("Are you sure you wish to delete " + name + "?");
        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;

    }

    /**
     * Alert used for Search when item not found
     *
     * @param textfield
     */
    public static void searchAlert(TextField textfield) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Error");
        alert.setContentText(textfield.getText() + " not found");

        alert.showAndWait();
    }

    /**
     * Validates text fields for Parts
     *
     * @param part
     * @param name
     * @param inv
     * @param price
     * @param min
     * @param max
     * @return
     */
    public static boolean partValidation(Part part, TextField name, TextField inv, TextField price, TextField min, TextField max) {
        if (isInputValid(name, "Name must be Entered")) {
            part.setName(name.getText());

        }

        if (isInputValid(inv, "Inventory must be Entered")) {
            try {
                part.setStock(Integer.parseInt(inv.getText()));
            } catch (NumberFormatException e) {
                errorAlert("Inventory must be number");
                return false;
            }
        }

        if (isInputValid(min, "Minimum must be Entered")) {
            try {
                part.setMin(Integer.parseInt(min.getText()));
            } catch (NumberFormatException e) {
                errorAlert("Minimum must be number");
                return false;
            }
        }
        if (isInputValid(max, "Maximum must be Entered")) {
            try {
                part.setMax(Integer.parseInt(max.getText()));
            } catch (NumberFormatException e) {
                errorAlert("Maximum must be number");
                return false;
            }
        }
        if (isInputValid(price, "Price must be Entered")) {
            try {
                part.setPrice(Double.parseDouble(price.getText()));
            } catch (NumberFormatException e) {
                errorAlert("Price must be decimal number");
                return false;
            }
        }
        if (part.getMax() <= part.getMin()) {
            errorAlert("Maximum must be larger than Minimum");
            return false;
        }
        if (part.getStock() < part.getMin() || part.getStock() > part.getMax()) {
            errorAlert("Inventory must be a number value between Maximum and Minimum");
            return false;
        }

        return true;
    }

    /**
     * Validates values for a New or Modified Product
     *
     * @param product
     * @param name
     * @param inv
     * @param price
     * @param min
     * @param max
     * @return
     */
    public static boolean productValidation(Product product, TextField name, TextField inv, TextField price, TextField min, TextField max) {
        if (isInputValid(name, "Name must be Entered")) {
            product.setName(name.getText());

        }

        if (isInputValid(inv, "Inventory must be Entered")) {
            try {
                product.setStock(Integer.parseInt(inv.getText()));
            } catch (NumberFormatException e) {
                errorAlert("Inventory must be number");
                return false;
            }
        }

        if (isInputValid(min, "Minimum must be Entered")) {
            try {
                product.setMin(Integer.parseInt(min.getText()));
            } catch (NumberFormatException e) {
                errorAlert("Minimum must be number");
                return false;
            }
        }
        if (isInputValid(max, "Maximum must be Entered")) {
            try {
                product.setMax(Integer.parseInt(max.getText()));
            } catch (NumberFormatException e) {
                errorAlert("Maximum must be number");
                return false;
            }
        }
        if (isInputValid(price, "Price must be Entered")) {
            try {
                product.setPrice(Double.parseDouble(price.getText()));
            } catch (NumberFormatException e) {
                errorAlert("Price must be decimal number");
                return false;
            }
        }
        if (product.getMax() <= product.getMin()) {
            errorAlert("Maximum must be larger than Minimum");
            return false;
        }
        if (product.getStock() < product.getMin() || product.getStock() > product.getMax()) {
            errorAlert("Inventory must be a number value between Maximum and Minimum");
            return false;
        }

        return true;
    }

}
