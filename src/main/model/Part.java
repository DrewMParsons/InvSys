/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Drew
 */
public abstract class Part {
    private SimpleIntegerProperty Id = new SimpleIntegerProperty(0);
    private SimpleStringProperty Name = new SimpleStringProperty("");
    private SimpleDoubleProperty Price = new SimpleDoubleProperty(0.0);
    private SimpleIntegerProperty Stock = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty Min = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty Max = new SimpleIntegerProperty(0);
    
    
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
     * @param Price the Price to set
     */
    public void setPrice(double price) {
        Price.set(price);
    }

    /**
     * @param Stock the Stock to set
     */
    public void setStock(int stock) {
        Stock.set(stock);
    }

    /**
     * @param Min the Min to set
     */
    public void setMin(int min) {
        Min.set(min);
    }

    /**
     * @param Max the Max to set
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
    
    
}

