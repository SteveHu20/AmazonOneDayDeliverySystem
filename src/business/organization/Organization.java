/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.employee.EmployeeDirectory;
import business.role.Role;
import business.userAccount.UserAccountDirectory;
import business.workqueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author baochenhu
 */
public abstract class Organization {
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private WorkQueue workQueue;
    private String name;
    private int organizationID=0;
    private static int counter=0;
    public Organization() {
      employeeDirectory=new EmployeeDirectory();
      userAccountDirectory=new UserAccountDirectory();
      workQueue=new WorkQueue(); 
      organizationID=counter;
      counter++;
    }
    
    public Organization(String name){
        this();
        this.name=name;    
    }
    /*
     * Display all the organization which can be chosen
     */
    public  enum OrganizationType{
       ShipOrganization("ShipOrganization"),PackageOrganization("PackageOrganization"),InventoryOrganization("InventoryOrganization"),SupplierFinanceOrganization("SupplierFinanceOrganization"),AmazonFinanceOrganization("AmazonFinanceOrganization"),CustomerOrganization("CustomerOrganization");
        private String value;
        private OrganizationType(String value) {
            this.value=value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
       
    }
    
    public abstract ArrayList<Role> getSupportedRole();

    public int getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }

    
    
    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
          return name;
    }
   
   
    
}
