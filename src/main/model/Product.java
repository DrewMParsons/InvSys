
package main.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Drew
 */
public class Product {
    private final SimpleIntegerProperty Id = new SimpleIntegerProperty(0);
    private final SimpleStringProperty Name = new SimpleStringProperty("");
    private final SimpleDoubleProperty Price = new SimpleDoubleProperty(0.0);
    private final SimpleIntegerProperty Stock = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty Min = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty Max = new SimpleIntegerProperty(0);
    public ObservableList<Part> associatedParts = FXCollections.observableArrayList();

  
    
    public Product(int id,String name, int stock,double price,int min, int max, ObservableList<Part> associatedParts){
        setId(id);
        setName(name);
        setPrice(price);
        setStock(stock);
        setMin(min);
        setMax(max);
        setAssociatedParts(associatedParts);
    }
    public Product(String name, int stock,double price,int min, int max, ObservableList<Part> associatedParts){
        
        setName(name);
        setPrice(price);
        setStock(stock);
        setMin(min);
        setMax(max);
        setAssociatedParts(associatedParts);
    }
    public Product(String name, int stock,double price,int min, int max){
        
        setName(name);
        setPrice(price);
        setStock(stock);
        setMin(min);
        setMax(max);
        
    }
    
    public Product(int id, String name, int stock,double price,  int min, int max){
        setId(id);
        setName(name);
        setPrice(price);
        setStock(stock);
        setMin(min);
        setMax(max);
        
    }

    public Product() {
        
    }

 public int getId() {
        return Id.get();
    }


    /**
     * @return the Name
     */
    public String getName() {
        return Name.get();
    }

    /**
     * @return the Price
     */
    public double getPrice() {
        return Price.get();
    }

    /**
     * @return the Stock
     */
    public int getStock() {
        return Stock.get();
    }

    /**
     * @return the Min
     */
    public int getMin() {
        return Min.get();
    }

    /**
     * @return the Max
     */
    public int getMax() {
        return Max.get();
    }
    
    public void setId(int id) {
        Id.set(id);
    }

    /**
     * @param name the Name to set
     */
    public void setName(String name) {
        
        Name.set(name);
    }

    /**
     * @param price the Price to set
     */
    public void setPrice(double price) {
        Price.set(price);
    }

    /**
     * @param stock the Stock to set
     */
    public void setStock(int stock) {
        Stock.set(stock);
    }

    /**
     * @param min the Min to set
     */
    public void setMin(int min) {
        Min.set(min);
    }

    /**
     * @param max the Max to set
     */
    public void setMax(int max) {
        Max.set(max);
    }

    public SimpleIntegerProperty idProperty(){
        return Id;
    }
    
    public SimpleStringProperty nameProperty(){
        return Name;
    }
    public SimpleDoubleProperty priceProperty(){
        return Price;
    }
    public SimpleIntegerProperty stockProperty(){
        return Stock;
    }
    public SimpleIntegerProperty minProperty(){
        return Min;
    }
    public SimpleIntegerProperty maxProperty(){
        return Max;
    }
    

    

    public ObservableList<Part> getAssociatedParts() {
        return associatedParts;
    }

    public void setAssociatedParts(ObservableList<Part> associatedParts) {
        this.associatedParts = associatedParts;
    }
    
    
    
}
