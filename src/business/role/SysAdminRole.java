/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.enterprise.Enterprise;
import business.organization.Organization;
import business.system.EcoSystem;
import javax.swing.JPanel;
import userInterface.sysAdminWorkArea.SysAdminWorkArea;

/**
 *
 * @author baochenhu
 */
public class SysAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel container, Organization organization, Enterprise enterprise, EcoSystem ecosystem) {
          SysAdminWorkArea adminWorkArea=new SysAdminWorkArea(container,ecosystem);
          return adminWorkArea;
    }
    
}
