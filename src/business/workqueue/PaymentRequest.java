/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import business.customer.Payment;

/**
 *
 * @author baochenhu
 */
public class PaymentRequest extends WorkRequest{
    Payment payment;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    

}
