/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.network;

import business.enterprise.AmazonEnterprise;
import business.enterprise.Enterprise;
import business.enterprise.SupplierEnterprise;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author baochenhu
 */
public class Network {
    private String name;
    private ArrayList<Enterprise> enterpriseList;
    
    public Network(){
      enterpriseList=new ArrayList<>();   
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
   
    public Enterprise createAndAddEnterprise(String name){
       if(name.equals("Amazon")){
         
         if(!enterpriseList.contains(new AmazonEnterprise(name))){
            AmazonEnterprise ae=new AmazonEnterprise(name);
            enterpriseList.add(ae);
            return ae;
         }
         else
         {
             JOptionPane.showMessageDialog(null, "Amazon has Exsiting");
         }
       }
       
       if(name.equals("SupplierEnterprise"))
       {
          SupplierEnterprise supplierEnterprise=new SupplierEnterprise(name);
          enterpriseList.add(supplierEnterprise);
          return supplierEnterprise;          
       
       }  
       return null;
    
    }
   
    @Override
    public String toString() {
         return name;
    }
    
}
