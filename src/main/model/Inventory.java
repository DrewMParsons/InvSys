
package main.model;

import java.util.concurrent.atomic.AtomicInteger;
import javafx.collections.ObservableList;

/**
 *
 * @author Drew
 */
public class Inventory {

    private final ObservableList<Part> allParts;
    private final ObservableList<Product> allProducts;
    private final static AtomicInteger IDGENERATOR = new AtomicInteger(1000);
    private final static AtomicInteger PRODUCTIDGENERATOR = new AtomicInteger(0);
    
    //constructor
    
    public Inventory(ObservableList<Part> allParts, ObservableList<Product> allProducts) {
        this.allParts = allParts;
        this.allProducts = allProducts;
    }
    
    
    //getters and setters

    public void addPart(Part part) {
        allParts.add(part);
        part.setId(IDGENERATOR.getAndIncrement());

    }
    public void modifyPart(Part part){
        allParts.add(part);
        
    }

    public void addProduct(Product product) {
        allProducts.add(product);
        product.setId(PRODUCTIDGENERATOR.getAndIncrement());

    }
    public void modifyProduct(Product product){
        allProducts.add(product);
    }

    public Part lookupPart(String name) {
        try {
            int id = Integer.parseInt(name);
            for (Part part : allParts) {
                if (part.getId() == id) {
                    return part;
                }
            }
            return null;
        } catch (NumberFormatException e) {
            for (Part part : allParts) {
                if (part.getName().equals(name)) {
                    return part;
                }
            }
            return null;
        }
    }
        
    

    

//    public Part lookupPart(int partId) {
//        for (Part part : allParts) {
//            if (part.getId() == partId) {
//                return part;
//            }
//        }
//
//        return null;
//
//    }

    public Product lookupProduct(String name) {
        try {
            int id = Integer.parseInt(name);
            for (Product product : allProducts) {
                if (product.getId() == id) {
                    return product;
                }
            }
            return null;
        } catch (NumberFormatException e) {
            for (Product product : allProducts) {
                if (product.getName().equals(name)) {
                    return product;
                }
            }
            return null;
        }
    }

    public ObservableList<Part> getAllParts() {
        return allParts;
    }

    public ObservableList<Product> getAllProducts() {
        return allProducts;
    }

}
