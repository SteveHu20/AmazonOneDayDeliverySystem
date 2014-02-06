/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.customer;

import java.util.ArrayList;

/**
 *
 * @author baochenhu
 */
public class Order {
    ArrayList<OrderItem> orderItems;

    public Order() {
        orderItems=new ArrayList<>();
    }
    

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    
    public OrderItem createAndAddOrderItem(){
        OrderItem orderItem=new OrderItem();
        orderItems.add(orderItem);
        return orderItem; 
    }
    
    public void deleteOrderItem(OrderItem orderItem){
       orderItems.remove(orderItem);
    
    }
    
    public float calSubTotal(){
        float subTotal=0;
        for(OrderItem orderItem:orderItems)
        {
           subTotal+=orderItem.calculateItemPrice();
        
        }
        return subTotal;
    }
    
}
