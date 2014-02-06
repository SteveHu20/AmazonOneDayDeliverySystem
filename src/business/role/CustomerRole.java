/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.customer.Customer;
import userInterface.customer.CustomerWorkArea;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.system.EcoSystem;
import javax.swing.JPanel;

/**
 *
 * @author baochenhu
 */
public class CustomerRole extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel container, Organization organization, Enterprise enterprise, EcoSystem ecosystem) {
        
        return null;
    }

    public JPanel createJPanel(Customer customer,JPanel container, Organization organization, Enterprise enterprise, EcoSystem ecosystem) {
       JPanel customerWorkArea=new CustomerWorkArea(customer,container,organization,enterprise,ecosystem);
       return customerWorkArea;
    }
    
}
