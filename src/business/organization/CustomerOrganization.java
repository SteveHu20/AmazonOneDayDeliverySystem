/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.customer.Customer;

import business.role.Role;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;

/**
 *
 * @author baochenhu
 */
public class CustomerOrganization extends Organization{
   
    private ArrayList<Customer> customerList;
    
    
    public CustomerOrganization(String name) {
       super(name);
       customerList=new ArrayList<>();
    }
  //Search for the customer
    public Customer searchForCustomer(String name,String password){
         if(customerList!=null)
        for(Customer customer: customerList)
        {   
           // Customer customer=(Customer) entry.getKey();
            if(name.equals(customer.getCustomerName())&&password.equals(customer.getCustomerPassword()))
           {
              return customer;
            }
        
        }
        return null;
        
//       for(Customer customer:customerList)
//       {
//         if(name.equals(customer.getCustomerName())&&password.equals(customer.getCustomerPassword()))
//         {
//            return customer;
//         }
//       }
//      return null;
    
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }
  
    
  
    
    public void createAndAddCustomer(Customer customer){
     //  Customer customer=new Customer();
       customerList.add(customer);
    //   return customer;
     //   customerMap.put(customer,customerWorkArea);
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
