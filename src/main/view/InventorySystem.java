package main.view;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
    public ObservableList<Part> allParts = FXCollections.observableArrayList();
    public ObservableList<Product> allProducts = FXCollections.observableArrayList();
    public Inventory systemInventory = new Inventory(allParts, allProducts);

    public InventorySystem() {
        //dummy info to test Parts table

        systemInventory.addPart(new Outsourced("chain", 5, 1, 10, 2, "ChainDudes"));
        systemInventory.addPart(new InHouse("horn", 2, 3, 1, 90, 1));
        systemInventory.addPart(new Outsourced("wheel", 10, 5, 20, 2, "TireDudes"));
        systemInventory.addPart(new InHouse("seat", 7, 2, 1, 10, 1));

        //dummy info to test Product table
        systemInventory.addProduct(new Product("bike", 5, 400, 1, 20));
        systemInventory.addProduct(new Product("trike", 5, 1000.0, 2, 20));
        systemInventory.addProduct(new Product("uni", 10, 200.0, 1, 10));

    }

    public Inventory getSystemInventory() {
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
     * @return 
     */
    public Stage getPrimaryStage() {
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

}
