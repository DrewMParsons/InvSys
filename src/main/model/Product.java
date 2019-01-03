
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
    private int Id;
    private SimpleStringProperty Name;
    private SimpleDoubleProperty Price;
    private SimpleIntegerProperty Stock;
    private SimpleIntegerProperty Min;
    private SimpleIntegerProperty Max;
    public ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    public Product(int id, SimpleStringProperty name, SimpleIntegerProperty stock, SimpleDoubleProperty price,  SimpleIntegerProperty min, SimpleIntegerProperty max, ObservableList<Part> associatedParts) {
        this.Id = id;
        this.Name = name;
        this.Stock = stock;
        this.Price = price;
        this.Min = min;
        this.Max = max;
        this.associatedParts = associatedParts;
    }
    
    public Product(int id,String name, int stock,double price,int min, int max, ObservableList<Part> associatedParts){
        setId(id);
        setName(name);
        setPrice(new SimpleDoubleProperty(price));
        setStock(new SimpleIntegerProperty(stock));
        setMin(new SimpleIntegerProperty(min));
        setMax(new SimpleIntegerProperty(max));
        setAssociatedParts(associatedParts);
    }
    public Product(String name, int stock,double price,int min, int max, ObservableList<Part> associatedParts){
        
        setName(name);
        setPrice(new SimpleDoubleProperty(price));
        setStock(new SimpleIntegerProperty(stock));
        setMin(new SimpleIntegerProperty(min));
        setMax(new SimpleIntegerProperty(max));
        setAssociatedParts(associatedParts);
    }
    public Product(String name, int stock,double price,int min, int max){
        
        setName(name);
        setPrice(new SimpleDoubleProperty(price));
        setStock(new SimpleIntegerProperty(stock));
        setMin(new SimpleIntegerProperty(min));
        setMax(new SimpleIntegerProperty(max));
        
    }
    
    public Product(int id, String name, int stock,double price,  int min, int max){
        setId(id);
        setName(name);
        setPrice(new SimpleDoubleProperty(price));
        setStock(new SimpleIntegerProperty(stock));
        setMin(new SimpleIntegerProperty(min));
        setMax(new SimpleIntegerProperty(max));
        
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }
    
    public String getName(){
        return Name.get();
    }
    
    

     public void setName(String name) {
        
        this.Name = new SimpleStringProperty(name);
    }

    public double getPrice(){
        return Price.get();
    }
     
    

    public void setPrice(SimpleDoubleProperty price) {
        this.Price = price;
    }

    public int getStock() {
        return Stock.get();
    }

    public void setStock(SimpleIntegerProperty stock) {
        this.Stock = stock;
    }

    public int getMin() {
        return Min.get();
    }

    public void setMin(SimpleIntegerProperty min) {
        this.Min = min;
    }

    public int getMax() {
        return Max.get();
    }

    public void setMax(SimpleIntegerProperty max) {
        this.Max = max;
    }

    public ObservableList<Part> getAssociatedParts() {
        return associatedParts;
    }

    public void setAssociatedParts(ObservableList<Part> associatedParts) {
        this.associatedParts = associatedParts;
    }
    
    
    
}
