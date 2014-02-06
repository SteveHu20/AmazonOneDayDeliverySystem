/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.enterprise.Enterprise;
import business.organization.Organization;
import business.system.EcoSystem;
import javax.swing.JPanel;
import userInterface.amazonEnterpriseInterface.AmazonFinanceJPanel;

/**
 *
 * @author baochenhu
 */
public class AmazonFinanceRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel container, Organization organization, Enterprise enterprise, EcoSystem ecosystem) {
        AmazonFinanceJPanel amazonFinanceJPanel=new AmazonFinanceJPanel(container, organization,  enterprise,  ecosystem);
        return amazonFinanceJPanel;
    }
    
}
