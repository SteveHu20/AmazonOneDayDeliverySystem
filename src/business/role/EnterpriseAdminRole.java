/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.enterprise.Enterprise;
import business.organization.Organization;
import business.system.EcoSystem;
import javax.swing.JPanel;
import userInterface.enterpriseAdminRole.EnterpriseAdminJPanel;

/**
 *
 * @author baochenhu
 */
public class EnterpriseAdminRole extends Role{

   
    @Override
    public JPanel createWorkArea(JPanel container, Organization organization, Enterprise enterprise, EcoSystem ecosystem) 
    {
            JPanel enterpriseAdminJPanel=new EnterpriseAdminJPanel(container,enterprise,ecosystem);
            return enterpriseAdminJPanel;
            
    }
    
}
