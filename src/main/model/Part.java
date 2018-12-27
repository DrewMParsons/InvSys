/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Drew
 */
public abstract class Part {
    private int id;
    private SimpleStringProperty Name;
    private SimpleDoubleProperty Price;
    private SimpleIntegerProperty Stock;
    private SimpleIntegerProperty Min;
    private SimpleIntegerProperty Max;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    /**
     * @param name the Name to set
     */
    public void setName(String name) {
        
        this.Name = new SimpleStringProperty(name);
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(SimpleDoubleProperty Price) {
        this.Price = Price;
    }

    /**
     * @param Stock the Stock to set
     */
    public void setStock(SimpleIntegerProperty Stock) {
        this.Stock = Stock;
    }

    /**
     * @param Min the Min to set
     */
    public void setMin(SimpleIntegerProperty Min) {
        this.Min = Min;
    }

    /**
     * @param Max the Max to set
     */
    public void setMax(SimpleIntegerProperty Max) {
        this.Max = Max;
    }

 
    
    
}

