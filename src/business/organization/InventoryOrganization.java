/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.dataset.DataSet;
import business.product.Category;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author baochenhu
 */
public class InventoryOrganization extends Organization{

    private ArrayList<Category> categoryCatalog;
    DataSet dataSet;
    
    
    
    public InventoryOrganization(String name) {
        super(name);
        categoryCatalog=new ArrayList<>();
        dataSet=new DataSet();
    }

    public DataSet getDataSet() {
        return dataSet;
    }

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    
    
    public ArrayList<Category> getCategoryCatalog() {
        return categoryCatalog;
    }

    public void setCategoryCatalog(ArrayList<Category> categoryCatalog) {
        this.categoryCatalog = categoryCatalog;
    }


    
    /*
     * create and add new product for the specific organization
     */
    public Category createAndAddCategory()
    {
       Category category=new Category();
       categoryCatalog.add(category);
       return category;
    }
    public void deleteCategoryFromCatalog(Category category)
    {
       categoryCatalog.remove(category);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
