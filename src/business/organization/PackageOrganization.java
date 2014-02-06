/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author baochenhu
 */
public class PackageOrganization extends Organization{

    public PackageOrganization(String name) {
       super(name);
    }
   
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
