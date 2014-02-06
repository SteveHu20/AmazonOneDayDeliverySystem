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
public class InvoicementHistory {
    ArrayList<Invoicement> invoicementList;

    public InvoicementHistory() {
        invoicementList = new ArrayList<>();
    }

    public ArrayList<Invoicement> getInvoicementList() {
        return invoicementList;
    }

    public void setInvoicementList(ArrayList<Invoicement> invoicementList) {
        this.invoicementList = invoicementList;
    }
    
    public void addInvoicement(Invoicement invoicement){
        invoicementList.add(invoicement);
    }
    
    
}
