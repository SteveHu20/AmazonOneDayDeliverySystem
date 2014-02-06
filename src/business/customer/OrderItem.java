/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.customer;

import business.product.Product;

/**
 *
 * @author baochenhu
 */
public class OrderItem {
   private Product product; 
   private int quantity;
   private float orderItemPrice;
    public float calculateItemPrice(){
        return product.getPrice()*quantity;
    
    }
    public float getOrderItemPrice() {
        return orderItemPrice;
    }

    public void setOrderItemPrice(float orderItemPrice) {
        this.orderItemPrice = orderItemPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return product.toString(); //To change body of generated methods, choose Tools | Templates.
    }
   
}
