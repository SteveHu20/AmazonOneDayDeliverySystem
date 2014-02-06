/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.product;

import java.util.ArrayList;

/**
 *
 * @author baochenhu
 */
public class Category {
    private ArrayList<Product> productList;
    private String categoryName;
    public Category() {
       productList=new ArrayList<>();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    
    
    
    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
    public Product createAndAddProduct(){
       Product product=new Product();
       productList.add(product);
       return product;
    }
    public void removeProductFromList(Product product){
        productList.remove(product);
    
    }

    @Override
    public String toString() {
        return categoryName; //To change body of generated methods, choose Tools | Templates.
    }
    
}
