/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.customer;



/**
 *
 * @author baochenhu
 */
public class Tax {
    private double taxRate=0.05;
    private float subTotal;
    private Location location;
 

    public Tax(Location location,float subTotal) {
        this.subTotal = subTotal;
        this.location = location;
        
    }

   
    
    public double getTax(){
        switch(location.getState()){
            case "Massatussates":
                taxRate = 0.065;
                break; 
            case "California":
                taxRate = 0.075;
    
        }
         
        return taxRate;
    }
    
    public double calculateTax(){
        return subTotal*getTax();
    }
    
}
