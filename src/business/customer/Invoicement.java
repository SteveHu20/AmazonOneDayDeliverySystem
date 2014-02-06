/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.customer;

/**
 *
 * @author baochenhu
 */
public class Invoicement {
    private Customer customer;
    private Order order;
    private Payment payment;
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return customer.getCustomerName(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
