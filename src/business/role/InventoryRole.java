/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.enterprise.Enterprise;
import business.organization.Organization;
import business.system.EcoSystem;
import javax.swing.JPanel;
import userInterface.inventoryManagerInterface.InventoryMainJPanel;

/**
 *
 * @author baochenhu
 */
public class InventoryRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel container, Organization organization, Enterprise enterprise, EcoSystem ecosystem) {
         InventoryMainJPanel inventoryMainJPanel=new InventoryMainJPanel(container,organization,enterprise,ecosystem);
         return inventoryMainJPanel;
    }
    
}
