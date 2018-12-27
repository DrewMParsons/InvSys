/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model;

import javafx.collections.ObservableList;

/**
 *
 * @author Drew
 */
public class Inventory 
{
    
    
    private  ObservableList<Part> allParts;
    private  ObservableList<Product> allProducts;

    public Inventory(ObservableList<Part> allParts, ObservableList<Product> allProducts) {
        this.allParts = allParts;
        this.allProducts = allProducts;
    }
    
    
    
    public void addPart(Part part)
    {
        allParts.add(part);
        
    }
    
    public void addProduct(Product product)
    {
        allProducts.add(product);
        
    }
    
    public Part lookupPart(int partId)
    {
        for(Part part : allParts)
        {
            if(part.getId() == partId)
            {
                return part;
            }
        }
        
        return null;
        
        
    }
    
    public Product lookupProduct(int productId){
        for(Product product: allProducts)
        {
            if(product.getId() == productId)
            {
                return product;
            }
        }
        
        return null;
        
    }
    
    public ObservableList<Part> getAllParts()
    {
        return allParts;
    }
    
    public ObservableList<Product> getAllProducts()
    {
        return allProducts;
    }
    
    
}
