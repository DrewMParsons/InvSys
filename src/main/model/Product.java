/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author Drew
 */
public class Product {
    private int id;
    private SimpleStringProperty name;
    private SimpleDoubleProperty price;
    private SimpleIntegerProperty stock;
    private SimpleIntegerProperty min;
    private SimpleIntegerProperty max;
    private ObservableList<Part> associatedParts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SimpleStringProperty getName() {
        return name;
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public SimpleDoubleProperty getPrice() {
        return price;
    }

    public void setPrice(SimpleDoubleProperty price) {
        this.price = price;
    }

    public SimpleIntegerProperty getStock() {
        return stock;
    }

    public void setStock(SimpleIntegerProperty stock) {
        this.stock = stock;
    }

    public SimpleIntegerProperty getMin() {
        return min;
    }

    public void setMin(SimpleIntegerProperty min) {
        this.min = min;
    }

    public SimpleIntegerProperty getMax() {
        return max;
    }

    public void setMax(SimpleIntegerProperty max) {
        this.max = max;
    }

    public ObservableList<Part> getAssociatedParts() {
        return associatedParts;
    }

    public void setAssociatedParts(ObservableList<Part> associatedParts) {
        this.associatedParts = associatedParts;
    }
    
    
    
}
