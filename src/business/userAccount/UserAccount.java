/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.userAccount;

import business.employee.Employee;
import business.role.Role;
import business.workqueue.WorkQueue;

/**
 *
 * @author baochenhu
 */
public class UserAccount {
    private Employee employee;
    private String userName;
    private String passwork;
    private Role role;
    private WorkQueue workQueue;

    public UserAccount() {
        workQueue=new WorkQueue();
    }
    
    
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswork() {
        return passwork;
    }

    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
         return userName;
    }
    
    
    
}
