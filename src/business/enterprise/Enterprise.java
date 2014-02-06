/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.organization.AmazonFinanceOrganization;
import business.organization.CustomerOrganization;
import business.organization.InventoryOrganization;
import business.organization.Organization;
import business.organization.PackageOrganization;
import business.organization.ShipOrganization;
import business.organization.SupplierFinanceOrganization;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author baochenhu
 */
public class Enterprise extends Organization{
    
    private ArrayList<Organization> organizationList;
    private String EnterpriseName;
    public Enterprise(String name) {
       super(name);
       organizationList=new ArrayList<>();
    }
//    public Enterprise(){
//        organizationList=new ArrayList<>();
//    }
   public enum EnterpriseType{
      SupplierEnterprise("SupplierEnterprise"),Amazon("Amazon");
        private String value;
        private EnterpriseType(String value) {
            this.value=value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
   }
    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public String getEnterpriseName() {
        return EnterpriseName;
    }

    public void setEnterpriseName(String EnterpriseName) {
        this.EnterpriseName = EnterpriseName;
    }
   
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
       return EnterpriseName;
    }
    
    public Organization createAndAddOrganization(String organizationName)
    {
       switch(organizationName)
       {
           case "ShipOrganization":
               ShipOrganization shipOrganization=new ShipOrganization(organizationName);
               organizationList.add(shipOrganization);
               return shipOrganization;
             //  break;
           case "PackageOrganization":
               PackageOrganization packageOrganizatin=new PackageOrganization(organizationName);
               organizationList.add(packageOrganizatin);
               return packageOrganizatin;
             //  break;
           case "InventoryOrganization":
               InventoryOrganization inventoryOrganization=new InventoryOrganization(organizationName);
               organizationList.add(inventoryOrganization);
               return inventoryOrganization;
             //  break;
           case "SupplierFinanceOrganization":
               SupplierFinanceOrganization supplierFinanceOrganization=new SupplierFinanceOrganization(organizationName);
               organizationList.add(supplierFinanceOrganization);
               return supplierFinanceOrganization;
            //   break;
           case "CustomerOrganization":
               CustomerOrganization customerOrganization=new CustomerOrganization(organizationName);
               organizationList.add(customerOrganization);
               return customerOrganization;
            //   break;
           case "AmazonFinanceOrganization":
               AmazonFinanceOrganization amazonFinanceOrganization=new AmazonFinanceOrganization(organizationName);
               organizationList.add(amazonFinanceOrganization);
               return amazonFinanceOrganization;
           //    break;
       }
       return null;
    }
}
