/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.ship;

/**
 *
 * @author baochenhu
 */
public class Shipman {
    private String lastName;
    private String firstName;
    private String contact;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return lastName; //To change body of generated methods, choose Tools | Templates.
    }
    
}
