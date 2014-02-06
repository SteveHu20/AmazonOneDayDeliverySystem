/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.role.AmazonFinanceRole;
import business.role.CustomerManager;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author baochenhu
 */
public class AmazonEnterprise extends Enterprise{

    public AmazonEnterprise(String name) {  
        super(name);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roleList=new ArrayList<>();
       CustomerManager customerManager=new CustomerManager();
       AmazonFinanceRole amazonFinanceRole=new AmazonFinanceRole();
       roleList.add(customerManager);
       roleList.add(amazonFinanceRole);
       return roleList;
    }
    
}
