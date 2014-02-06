/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.customer.InvoicementHistory;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author baochenhu
 */
public class AmazonFinanceOrganization extends Organization{
    InvoicementHistory invoicementHistory;
    public AmazonFinanceOrganization(String name) {
       super(name);
       invoicementHistory = new InvoicementHistory();
    }

    public InvoicementHistory getInvoicementHistory() {
        return invoicementHistory;
    }

    public void setInvoicementHistory(InvoicementHistory invoicementHistory) {
        this.invoicementHistory = invoicementHistory;
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
