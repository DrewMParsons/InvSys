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
public class Outsourced extends Part{
    
        
    private SimpleStringProperty companyId;

    
   //constructor
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyId)
    {
        setId(id);
        setName(name);
        setPrice(new SimpleDoubleProperty(price));
        setStock(new SimpleIntegerProperty(stock));
        setMin(new SimpleIntegerProperty(min));
        setMax(new SimpleIntegerProperty(max));
        setCompanyId(new SimpleStringProperty(companyId));
    }
        

    //getters & setters

    public void setCompanyId(SimpleStringProperty companyId) {
        this.companyId = companyId;
    }

    

    public String getCompanyId() 
    {
        return companyId.get();
    }
}
