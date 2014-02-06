/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.customer;

import business.role.CustomerRole;
import business.userAccount.UserAccount;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author baochenhu
 */
public class Customer extends UserAccount{
    private FinancialAccount financialAccount;
    private String customerName;
    private String customerPassword;
    private int customerID;
    private static int counter=0;
 //   private JPanel customerWorkArea;
    private JPanel container;
    private CustomerRole role;
 //   private Enterprise enterprise;
  //  private EcoSystem ecoSystem;
    private ArrayList<Order> orderDirectory;
    private ViewingHistory viewingHistory;
    private Location location;
    public Customer() {
        customerID=counter;
        customerID++;
    //    this.customerWorkArea=customerWorkArea;
  //      customerWorkArea=new CustomerWorkArea();
        orderDirectory = new ArrayList<>();
        viewingHistory = new ViewingHistory();
        financialAccount=new FinancialAccount();
       
    }

    //    public JPanel getCustomerWorkArea() {
    //        return customerWorkArea;
    //    }
    //
    //    public void setCustomerWorkArea(JPanel customerWorkArea) {
    //        this.customerWorkArea = customerWorkArea;
    //    }
    public ViewingHistory getViewingHistory() {
        return viewingHistory;
    }

    public void setViewingHistory(ViewingHistory viewingHistory) {
        this.viewingHistory = viewingHistory;
    }
    
    
    public CustomerRole getRole() {
        return role;
    }

    public void setRole(CustomerRole role) {
        this.role = role;
    }

    public ArrayList<Order> getOrderDirectory() {
        return orderDirectory;
    }

    public void setOrderDirectory(ArrayList<Order> orderDirectory) {
        this.orderDirectory = orderDirectory;
    }
   
    //Create and Add a order to the OrderDirectory
    public Order createAndAddOrder(){
       Order order=new Order();
       orderDirectory.add(order);
       return order;
    }
    
    
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public FinancialAccount getFinancialAccount() {
        return financialAccount;
    }

    public void setFinancialAccount(FinancialAccount financialAccount) {
        this.financialAccount = financialAccount;
    }

  
  
    
    @Override
    public String toString() {
        return customerID+""; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
