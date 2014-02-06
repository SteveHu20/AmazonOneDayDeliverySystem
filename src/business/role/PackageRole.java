/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.enterprise.Enterprise;
import business.organization.Organization;
import business.system.EcoSystem;
import javax.swing.JPanel;
import userInterface.supplierInterface.PackageOrganizationJPanel;

/**
 *
 * @author baochenhu
 */
public class PackageRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel container, Organization organization, Enterprise enterprise, EcoSystem ecosystem) {
        PackageOrganizationJPanel packageOrganizationJPanel=new PackageOrganizationJPanel( container,  organization,  enterprise,  ecosystem);
        return packageOrganizationJPanel;
    }
    
}
