
package main.exceptions;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Drew
 */
public class DialogBox {

    public DialogBox() {
    }
    
    


    public boolean confirm(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Confirming!");
        alert.setContentText("Are you sure you wish to cancel?");

        Optional<ButtonType> result = alert.showAndWait();

        return result.get() == ButtonType.OK;
            
        }
    
    public boolean delete(){
        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("Warning Dialog");
        alert.setHeaderText("Deleting!");
        alert.setContentText("Are you sure you wish to delete this item?");

        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
        
            
        }
    
    

    }




    
        
