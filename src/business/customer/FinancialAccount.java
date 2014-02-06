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
public class FinancialAccount {
    
    ArrayList<Payment> payments;

    public FinancialAccount() {
        payments = new ArrayList<>();
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }
    
    public void addPayment(Payment payment){
       payments.add(payment);
    }
    
}
