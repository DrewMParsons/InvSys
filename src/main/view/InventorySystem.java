
package main.view;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.model.InHouse;
import main.model.Inventory;
import main.model.Outsourced;
import main.model.Part;
import main.model.Product;

/**
 *
 * @author Drew
 */
public class InventorySystem extends Application {
    private Stage primaryStage;
    private ObservableList<Part> allParts = FXCollections.observableArrayList();
    private ObservableList<Product> allProducts = FXCollections.observableArrayList();
    public Inventory systemInventory = new Inventory(allParts, allProducts); 
    
    public InventorySystem(){
         //dummy info to test Parts table
    

        systemInventory.addPart(new Outsourced(0, "chain", 5, 1, 10, 2, "ChainDudes"));
        systemInventory.addPart(new InHouse(1, "horn", 2, 3, 1, 90, 1));

        
    

    //dummy info to test Product table
    
        systemInventory.addProduct(new Product(1, "bike", 500, 4, 1, 20));
        systemInventory.addProduct(new Product(2, "trike", 400, 1, 1, 3));

        

    
    }
    public Inventory getSystemInventory(){
        return systemInventory;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        
        this.primaryStage.setTitle("Inventory Management System");
        initMain();
        
    }

    /**
     * Returns the main stage
     * 
     */
    public Stage getPrimaryStage(){
        return primaryStage;
    }
    
    public static void main(String[] args) {
        launch(args);
        
        
    }

    private void initMain() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(InventorySystem.class.getResource("Main.fxml"));
        Pane myPane = (Pane) loader.load();
        
        MainController controller = loader.getController();
        controller.setInventorySystem(this);
        Scene myScene = new Scene(myPane);
        
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
    
    /**
 * Opens a dialog to edit details for the specified person. If the user
 * clicks OK, the changes are saved into the provided person object and true
 * is returned.
 * 
 * @param person the person object to be edited
 * @return true if the user clicked OK, false otherwise.
 */
public boolean showModifyPartDialog(Part part) {
    try {
        // Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(InventorySystem.class.getResource("ModifyPart.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Create the dialog Stage.
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Modify Part");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Set the part into the controller.
        ModifyPartController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        if(part instanceof InHouse)
            controller.initDataInHouse((InHouse) part);
        else
            controller.initDataOutsourced((Outsourced) part);

        // Show the dialog and wait until the user closes it
        dialogStage.showAndWait();

        return controller.isOkClicked();
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}
    
}
