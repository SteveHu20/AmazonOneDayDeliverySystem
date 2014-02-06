/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.system;

import business.employee.Employee;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.AmazonFinanceOrganization;
import business.organization.Organization;
import business.role.AmazonFinanceRole;
import business.role.CustomerManager;
import business.role.EnterpriseAdminRole;
import business.role.InventoryRole;
import business.role.PackageRole;
import business.role.ShipRole;
import business.role.SupplierFinanceRole;
import business.role.SysAdminRole;
import business.userAccount.UserAccount;
import business.workqueue.WorkQueue;

/**
 *
 * @author baochenhu
 */
public class ConfigureASystem {
    public static EcoSystem configure(){
         EcoSystem ecoSystem=EcoSystem.getInstance();
         Employee employee=ecoSystem.getEmployeeDirectory().createAndAddEmployee();
         employee.setName("baochen");
         
         UserAccount userAccount=ecoSystem.getUserAccountDirectory().createAndAddUserAccount();
         userAccount.setEmployee(employee);
         userAccount.setUserName("admin");
         userAccount.setPasswork("admin");
         userAccount.setRole(new SysAdminRole());
         userAccount.setWorkQueue(new WorkQueue());
         
         //1.Configure a network: usa
         Network network=ecoSystem.createAndAddNetwork();
         network.setName("USA");
         
         //2.Configure Amazon Admin
         Enterprise amazon=network.createAndAddEnterprise("Amazon");
         Employee amazonAdminEmp=amazon.getEmployeeDirectory().createAndAddEmployee();
         amazonAdminEmp.setName("jerry");
         
         UserAccount amazonUA=amazon.getUserAccountDirectory().createAndAddUserAccount();
         amazonUA.setEmployee(amazonAdminEmp);
         amazonUA.setUserName("jerry");
         amazonUA.setPasswork("jerry");
         amazonUA.setRole(new EnterpriseAdminRole());
         
         //3.Configure Amazon Finance Organization
         Organization amaFianceOrg=amazon.createAndAddOrganization("AmazonFinanceOrganization");
         Employee amazonFinanceEmp=amaFianceOrg.getEmployeeDirectory().createAndAddEmployee();
         amazonFinanceEmp.setName("lynda");
         
         UserAccount amazonFinanceUserAccount=amaFianceOrg.getUserAccountDirectory().createAndAddUserAccount();
         amazonFinanceUserAccount.setEmployee(employee);
         amazonFinanceUserAccount.setUserName("lynda");
         amazonFinanceUserAccount.setPasswork("lynda");
         amazonFinanceUserAccount.setRole(new AmazonFinanceRole());
         
         //4.Configure Amazon CustomerManager
         Organization customerManager=amazon.createAndAddOrganization("CustomerOrganization");
         Employee amazonCustomerManager=customerManager.getEmployeeDirectory().createAndAddEmployee();
         amazonCustomerManager.setName("kal");
         
         UserAccount amazonCMR=customerManager.getUserAccountDirectory().createAndAddUserAccount();
         amazonCMR.setEmployee(amazonCustomerManager);
         amazonCMR.setUserName("kal");
         amazonCMR.setPasswork("kal");
         amazonCMR.setRole(new CustomerManager());
         
        
         //1.Configure Stop&Shop Enterprise Admin
         Enterprise stopShop=network.createAndAddEnterprise("SupplierEnterprise");
         stopShop.setEnterpriseName("Stop&Shop");
         Employee stopShopEmp=stopShop.getEmployeeDirectory().createAndAddEmployee();
         stopShopEmp.setName("baochen");
         
         UserAccount stopShopUA=stopShop.getUserAccountDirectory().createAndAddUserAccount();
         stopShopUA.setEmployee(stopShopEmp);
         stopShopUA.setUserName("baochen");
         stopShopUA.setPasswork("baochen");
         stopShopUA.setRole(new EnterpriseAdminRole());
         
         //1.1 Confiure Supper88 Enterprise Admin
         Enterprise supper88=network.createAndAddEnterprise("SupplierEnterprise");
         supper88.setEnterpriseName("Lupper88");
         Employee supper88Emp=supper88.getEmployeeDirectory().createAndAddEmployee();
         supper88Emp.setName("benson");
         
         UserAccount supper88UA=supper88.getUserAccountDirectory().createAndAddUserAccount();
         supper88UA.setEmployee(supper88Emp);
         supper88UA.setUserName("benson");
         supper88UA.setPasswork("benson");
         supper88UA.setRole(new EnterpriseAdminRole());
         
         //2.Confiure Stop&Shop Inventory Organization
         Organization stopShopInventoryOrg=stopShop.createAndAddOrganization("InventoryOrganization");
         Employee ssEmp=stopShopInventoryOrg.getEmployeeDirectory().createAndAddEmployee();
         ssEmp.setName("jack");
         
         UserAccount ssUA=stopShopInventoryOrg.getUserAccountDirectory().createAndAddUserAccount();
         ssUA.setEmployee(ssEmp);
         ssUA.setUserName("jack");
         ssUA.setPasswork("jack");
         ssUA.setRole(new InventoryRole());
         
         //2.Configure Supper88 Inventory Organization
         Organization supper88InventoryOrg=supper88.createAndAddOrganization("InventoryOrganization");
         Employee supperEmp=supper88InventoryOrg.getEmployeeDirectory().createAndAddEmployee();
         supperEmp.setName("phil");
         
         UserAccount supperUA=supper88InventoryOrg.getUserAccountDirectory().createAndAddUserAccount();
         supperUA.setEmployee(supperEmp);
         supperUA.setUserName("phil");
         supperUA.setPasswork("phil");
         supperUA.setRole(new InventoryRole());
         
         //3.Configure a Package Organizaiton
         Organization stopShopPackageOrg=stopShop.createAndAddOrganization("PackageOrganization");
         Employee ssPOrgEmp=stopShopPackageOrg.getEmployeeDirectory().createAndAddEmployee();
         ssPOrgEmp.setName("mark");
         
         UserAccount sspUA=stopShopPackageOrg.getUserAccountDirectory().createAndAddUserAccount();
         sspUA.setEmployee(ssPOrgEmp);
         sspUA.setUserName("mark");
         sspUA.setPasswork("mark");
         sspUA.setRole(new PackageRole());
         //3.1 Configure a Package Organization for super88
         Organization supper88PackageOrg=supper88.createAndAddOrganization("PackageOrganization");
         Employee supper88PackEmp=supper88PackageOrg.getEmployeeDirectory().createAndAddEmployee();
         amazonFinanceEmp.setName("papa");
         
         UserAccount super88PackUA=supper88PackageOrg.getUserAccountDirectory().createAndAddUserAccount();
         super88PackUA.setEmployee(supper88PackEmp);
         super88PackUA.setUserName("papa");
         super88PackUA.setPasswork("papa");
         super88PackUA.setRole(new PackageRole());
         
         //4.Configure a Shipment Organization for stopShop
         Organization shipOrgStopShop=stopShop.createAndAddOrganization("ShipOrganization");
         Employee shipOrgStopShopEmp=shipOrgStopShop.getEmployeeDirectory().createAndAddEmployee();
         shipOrgStopShopEmp.setName("mary");
         
         UserAccount shipOrgStopShopUA=shipOrgStopShop.getUserAccountDirectory().createAndAddUserAccount();
         shipOrgStopShopUA.setEmployee(shipOrgStopShopEmp);
         shipOrgStopShopUA.setUserName("mary");
         shipOrgStopShopUA.setPasswork("mary");
         shipOrgStopShopUA.setRole(new ShipRole());
         
         //4.1Configure a shipment organiztion for supper88
         Organization shipOrgSupper88=supper88.createAndAddOrganization("ShipOrganization");
         Employee shipOrgSupper88Emp=shipOrgSupper88.getEmployeeDirectory().createAndAddEmployee();
         shipOrgSupper88Emp.setName("jason");
         
         UserAccount shipOrgSuper88UA=shipOrgSupper88.getUserAccountDirectory().createAndAddUserAccount();
         shipOrgSuper88UA.setEmployee(shipOrgStopShopEmp);
         shipOrgSuper88UA.setUserName("jason");
         shipOrgSuper88UA.setPasswork("jason");
         shipOrgSuper88UA.setRole(new ShipRole());
         
         //5 Configure a Finance Organization for stopshop
         Organization stopshopFinance=stopShop.createAndAddOrganization("SupplierFinanceOrganization");
         Employee stopshopFinanceEmp=stopshopFinance.getEmployeeDirectory().createAndAddEmployee();
         stopshopFinanceEmp.setName("kery");
         
         UserAccount stopshopFinanceUA=stopshopFinance.getUserAccountDirectory().createAndAddUserAccount();
         stopshopFinanceUA.setEmployee(stopshopFinanceEmp);
         stopshopFinanceUA.setUserName("kery");
         stopshopFinanceUA.setPasswork("kery");
         stopshopFinanceUA.setRole(new SupplierFinanceRole());
         
         
         return ecoSystem;
     
    }
}
