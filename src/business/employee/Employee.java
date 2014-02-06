/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.employee;

/**
 *
 * @author baochenhu
 */
public class Employee {
    private String name;
    private static int counter=0;
    private int id;

    public Employee() {
       id=counter;
       counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
         return name;
    }
    
    
}
