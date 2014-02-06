/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.product;

import business.enterprise.Enterprise;

/**
 *
 * @author baochenhu
 */
public class Product {
    private int productID;
    private String productName;
    private String productDescription;
    private int availability;
    private float price;
    private Enterprise supplyEnterprise;
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    
    static int counter=0;

    public Product() {
        productID=counter;
        counter++;
    }

    public Enterprise getSupplyEnterprise() {
        return supplyEnterprise;
    }

    public void setSupplyEnterprise(Enterprise supplyEnterprise) {
        this.supplyEnterprise = supplyEnterprise;
    }

    
    
    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return productName+""; //To change body of generated methods, choose Tools | Templates.
    }
    
}
