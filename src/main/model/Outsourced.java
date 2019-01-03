
package main.model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Drew
 */
public class Outsourced extends Part{
    
        
    private final SimpleStringProperty CompanyId = new SimpleStringProperty("");

    
   //constructor
    
    public Outsourced(){
        this("",0.0,0,0,0,"");
    }
    public Outsourced( String name, double price, int stock, int min, int max, String companyId)
    {
        
        setName(name);
        setPrice(price);
        setStock(stock);
        setMin(min);
        setMax(max);
        setCompanyId(companyId);
    }
    public Outsourced(int id,String name, double price, int stock, int min, int max, String companyId)
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
