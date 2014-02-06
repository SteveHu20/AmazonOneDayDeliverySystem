/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import business.customer.OrderItem;
import business.ship.Shipman;
import java.util.Date;

/**
 *
 * @author baochenhu
 */
public class OrderItemRequest extends WorkRequest{
    private OrderItem orderItem;
    private Date inventoryDate;
    private Date packageDate;
    private Date shipDate;
    private String fragile="UNKOWN";
    private Shipman shipman=null;

    public String getFragile() {
        return fragile;
    }

    public void setFragile(String fragile) {
        this.fragile = fragile;
    }

    public Shipman getShipman() {
        return shipman;
    }

    public void setShipman(Shipman shipman) {
        this.shipman = shipman;
    }
    
    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public Date getInventoryDate() {
        return inventoryDate;
    }

    public void setInventoryDate(Date inventoryDate) {
        this.inventoryDate = inventoryDate;
    }

    public Date getPackageDate() {
        return packageDate;
    }

    public void setPackageDate(Date packageDate) {
        this.packageDate = packageDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    @Override
    public String toString() {
        return orderItem.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
