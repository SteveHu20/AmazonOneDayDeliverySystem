/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.role.Role;
import business.ship.Shipman;
import java.util.ArrayList;

/**
 *
 * @author baochenhu
 */
public class ShipOrganization extends Organization{
    ArrayList<Shipman> shipmanList;
    
    
    public ShipOrganization(String name) {
      super(name);
      shipmanList=new ArrayList<>();
    }

    public ArrayList<Shipman> getShipmanList() {
        return shipmanList;
    }

    public void setShipmanList(ArrayList<Shipman> shipmanList) {
        this.shipmanList = shipmanList;
    }
   
   
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
