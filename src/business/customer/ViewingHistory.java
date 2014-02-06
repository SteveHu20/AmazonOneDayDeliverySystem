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
public class ViewingHistory {
    ArrayList<OrderItem> viewedOrderItems;

    public ViewingHistory() {
        viewedOrderItems=new ArrayList<>();
    }

    public ArrayList<OrderItem> getViewedOrderItems() {
        return viewedOrderItems;
    }

    public void setViewedOrderItems(ArrayList<OrderItem> viewedOrderItems) {
        this.viewedOrderItems = viewedOrderItems;
    }
    
    
    
    
}
