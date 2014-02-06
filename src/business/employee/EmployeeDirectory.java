/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.employee;

import java.util.ArrayList;

/**
 *
 * @author baochenhu
 */
public class EmployeeDirectory {
    ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
       employeeList=new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    
    public Employee createAndAddEmployee(){
       Employee employee=new Employee();
       employeeList.add(employee);
       return employee;
    
    }
    
}
