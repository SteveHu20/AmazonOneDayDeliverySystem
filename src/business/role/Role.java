/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.enterprise.Enterprise;
import business.organization.Organization;
import business.system.EcoSystem;
import javax.swing.JPanel;

/**
 *
 * @author baochenhu
 */
public abstract class Role {
    public abstract JPanel createWorkArea(JPanel container,Organization organization,Enterprise enterprise,EcoSystem ecosystem);;

    @Override
    public String toString() {
        return this.getClass().getSimpleName(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
