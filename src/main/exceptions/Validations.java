
package main.exceptions;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import static main.exceptions.Alerts.errorAlert;
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
