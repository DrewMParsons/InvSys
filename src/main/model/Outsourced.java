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
    
        
    private SimpleStringProperty CompanyId = new SimpleStringProperty("");

    
   //constructor
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyId)
    {
        setId(id);
        setName(name);
        setPrice(price);
        setStock(stock);
        setMin(min);
        setMax(max);
        setCompanyId(companyId);
    }
        

    //getters & setters

    public void setCompanyId(String companyId) {
        CompanyId.set(companyId);
    }

    

    public String getCompanyId() 
    {
        return CompanyId.get();
    }
}
