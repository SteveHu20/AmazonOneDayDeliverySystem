/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.system;

import business.enterprise.Enterprise;
import business.enterprise.SupplierEnterprise;
import business.network.Network;
import business.organization.Organization;
import business.role.Role;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author baochenhu
 */
public class EcoSystem extends Organization{
   private ArrayList<Network> networks; 
   static EcoSystem ecoSystem;
  
   private EcoSystem(){
      networks=new ArrayList<Network>();
     
   }
   
   public static EcoSystem getInstance(){
      if(ecoSystem==null){
         ecoSystem=new EcoSystem();
         return ecoSystem;
      }
      return ecoSystem;
   }

    public ArrayList<Network> getNetworks() {
        return networks;
    }
    
   
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Network createAndAddNetwork(){
       Network network=new Network();
       networks.add(network);
       return network;  
    }
    
     public Map rank(){
      Map<String,String> unsortedMap=new HashMap<String,String>();
      for(Network network:networks)
      for(Enterprise enterprise:network.getEnterpriseList())
      {
         if(enterprise instanceof SupplierEnterprise)
         {
           int rate=((SupplierEnterprise)enterprise).getRate();
           String enterpriseName=((SupplierEnterprise)enterprise).getEnterpriseName();
           unsortedMap.put(rate+"", enterpriseName);
         }
      }
      Map<String, String> treeMap = new TreeMap<String, String>(unsortedMap);
      return treeMap;
    }
}
