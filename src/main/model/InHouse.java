
package main.model;

import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Drew
 */
public class InHouse extends Part
{
    
    private final SimpleIntegerProperty MachineId = new SimpleIntegerProperty(0);
    
    
   //constructors
    
    public InHouse(){
        this("",0.0,0,0,0,0);
    }
    
    public InHouse( String name, double price, int stock, int min, int max, int machineId)
    {
        
        setName(name);
        setPrice(price);
        setStock(stock);
        setMin(min);
        setMax(max);
        setMachineId(machineId);
    }
    public InHouse(int id,String name, double price, int stock, int min, int max, int machineId)
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
