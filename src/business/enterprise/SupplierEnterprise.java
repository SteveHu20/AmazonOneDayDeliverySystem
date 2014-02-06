/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.customer.Location;
import business.role.InventoryRole;
import business.role.PackageRole;
import business.role.Role;
import business.role.ShipRole;
import business.role.SupplierFinanceRole;
import java.util.ArrayList;

/**
 *
 * @author baochenhu
 */
public class SupplierEnterprise extends Enterprise{
    String name;
    private Location location=null;
    private ArrayList<RateAndReview> rateAndReviewDir;
    private int rate=5;

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
    
    public SupplierEnterprise(String name) {
        super(name);
        this.name=name;
        rateAndReviewDir = new ArrayList<>();
    }

    public ArrayList<RateAndReview> getRateAndReviewDir() {
        return rateAndReviewDir;
    }

    public void setRateAndReviewDir(ArrayList<RateAndReview> rateAndReviewDir) {
        this.rateAndReviewDir = rateAndReviewDir;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
     public int getRating(){
        int total=0;
        int i=0;
        int rate1;
        if(rateAndReviewDir.size()>0){
            for(RateAndReview rar:rateAndReviewDir){
              total+=rar.getRateNum();
              i++;
            }
            rate1=total/i;
            this.rate=rate1;
            return rate1;
        }else{
           this.rate=rate;
           return 5;
        }      
    
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
          ArrayList<Role> supplierEnterpriseRole=new ArrayList<>();
          ShipRole shipRole=new ShipRole();
          PackageRole packageRole=new PackageRole();
          InventoryRole inventoryRole=new InventoryRole();
          SupplierFinanceRole supplierFinanceRole=new SupplierFinanceRole();
          
          supplierEnterpriseRole.add(shipRole);
          supplierEnterpriseRole.add(packageRole);
          supplierEnterpriseRole.add(inventoryRole);
          supplierEnterpriseRole.add(supplierFinanceRole);
          
          return supplierEnterpriseRole;
    }

//    @Override
//    public String toString() {
//        return name ;
//    }
    
    
}
