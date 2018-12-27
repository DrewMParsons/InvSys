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
public class InHouse extends Part
{
    
    private SimpleIntegerProperty machineId;

    
   //constructor
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId)
    {
        setId(id);
        setName(name);
        setPrice(new SimpleDoubleProperty(price));
        setStock(new SimpleIntegerProperty(stock));
        setMin(new SimpleIntegerProperty(min));
        setMax(new SimpleIntegerProperty(max));
        setMachineId(new SimpleIntegerProperty(machineId));
    }
        

    //getters & setters

    public void setMachineId(SimpleIntegerProperty machineId) {
        this.machineId = machineId;
    }

    public SimpleIntegerProperty getMachineId() 
    {
        return machineId;
    }

    
   
    
}
