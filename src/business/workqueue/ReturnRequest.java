/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

/**
 *
 * @author baochenhu
 */
public class ReturnRequest extends WorkRequest {
    OrderItemRequest orderItemRequest;
    
    
    
    public OrderItemRequest getOrderItemRequest() {
        return orderItemRequest;
    }

    public void setOrderItemRequest(OrderItemRequest orderItemRequest) {
        this.orderItemRequest = orderItemRequest;
    }
    
}
