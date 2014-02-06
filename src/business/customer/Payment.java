/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.customer;

import java.util.Date;

/**
 *
 * @author baochenhu
 */
public class Payment {
    private double payment;
    private Date date;
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

   
    
    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
