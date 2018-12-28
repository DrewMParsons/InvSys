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
    
    private final SimpleIntegerProperty MachineId = new SimpleIntegerProperty(0);

    
   //constructors
    
    public InHouse(){
        this(0,"",0.0,0,0,0,0);
    }
    
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId)
    {
        setId(id);
        setName(name);
        setPrice(price);
        setStock(stock);
        setMin(min);
        setMax(max);
        setMachineId(machineId);
    }
        

    //getters & setters

    public void setMachineId(int machineId) {
        MachineId.set(machineId);
    }

    public int getMachineId() 
    {
        return MachineId.get();
    }
    public SimpleIntegerProperty machineIdProperty(){
        return MachineId;
    }

    
   
    
}
