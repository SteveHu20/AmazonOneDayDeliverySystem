/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.customer;

import business.customer.Customer;
import business.customer.Location;
import business.customer.Order;
import business.customer.OrderItem;
import business.product.Product;
import business.enterprise.AmazonEnterprise;
import business.enterprise.Enterprise;
import business.enterprise.SupplierEnterprise;
import business.network.Network;
import business.organization.InventoryOrganization;
import business.organization.Organization;
import business.product.Category;
import business.system.EcoSystem;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userInterface.MapVisual.MapJFrame;

/**
 *
 * @author baochenhu
 */
public class ViewProductsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewProductsJPanel
     */
    JPanel container;
    Enterprise enterprise;
    EcoSystem ecoSystem;
    Customer customer;
    Organization organization;
    Order order;
    ArrayList<Product> products;
    public ViewProductsJPanel(Customer customer,JPanel container,Organization organization,Enterprise enterprise,EcoSystem ecoSystem) {
        initComponents();
         products = new ArrayList<>();
        this.customer=customer;
        this.container=container;
        this.enterprise=enterprise;
        this.organization=organization;
        this.ecoSystem=ecoSystem;
        populateTable();
        order=customer.createAndAddOrder();
       
    }
   
    private void poplateTable1(){
       DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
       for(Network network:ecoSystem.getNetworks())
       {
          for(Enterprise enterprise:network.getEnterpriseList())
          {
            if(!(enterprise instanceof AmazonEnterprise))
            { 
              //to check whether is in the same state
              if(((SupplierEnterprise)enterprise).getLocation()!=null)
              if(((SupplierEnterprise)enterprise).getLocation().getState().equalsIgnoreCase(customer.getLocation().getState()))
                  
               for(Organization organization:enterprise.getOrganizationList())
                {
                 if(organization instanceof InventoryOrganization)  
                 {
                    for(Category category:((InventoryOrganization)organization).getCategoryCatalog())
                    {
                        for(Product product:category.getProductList())
                        {
                        Object obj[]=new Object[4];
                    //    obj[0]=product;
                        obj[0]=product;
                        obj[1]=product.getProductDescription();
                        obj[2]=product.getSupplyEnterprise();
                        obj[3]=((SupplierEnterprise)product.getSupplyEnterprise()).getRating();
                        model.addRow(obj);
                        }
                    }
                 }
              }  
            }
          }
       }
    
    }
    private void populateTable()
    {  
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
       for(Network network:ecoSystem.getNetworks())
       {
          for(Enterprise enterprise:network.getEnterpriseList())
          {
            if(!(enterprise instanceof AmazonEnterprise))
            {
              for(Organization organization:enterprise.getOrganizationList())
              {
                 if(organization instanceof InventoryOrganization)  
                 {
                    for(Category category:((InventoryOrganization)organization).getCategoryCatalog())
                    {
                        for(Product product:category.getProductList())
                        {
                        Object obj[]=new Object[4];
                    //    obj[0]=product;
                        
                        products.add(product);
                        obj[0]=product;
                        obj[1]=product.getProductDescription();
                        obj[2]=product.getSupplyEnterprise();
                        obj[3]=((SupplierEnterprise)product.getSupplyEnterprise()).getRating();

                        model.addRow(obj);
                        }
                    }
                 }
              }  
            }
          }
       }
    }
    
    private void searchAndPopulateTable(){
          String productName="";
          String categoryName="";
          String supplierName="";
        if(jComboBox2.getSelectedIndex()==0){
            productName=jTextField1.getText();
        }else if(jComboBox2.getSelectedIndex()==1)
        {
            categoryName=jTextField1.getText();
        }else if(jComboBox2.getSelectedIndex()==2)
        {
            supplierName=jTextField1.getText();
        }
        
        DefaultTableModel model=(DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        
        for(Product product : products)
        {
           if(product.getProductName().toLowerCase().contains(productName.toLowerCase()))
           {
                 Object obj[]=new Object[3];
                 obj[0]=product;
                 obj[1]=product.getProductDescription();
                 obj[2]=product.getSupplyEnterprise();
                 model.addRow(obj);
           }
        
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Search By Name", "Search By Category", "Search By Supplier" }));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ProductNaem", "ProductDescription", "SupplyEnterprise", "Rate(*****)"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Search For Product");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton7.setText("Visualize the location>>");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Automated>>");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 176, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jComboBox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 226, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(36, 36, 36)
                .add(jButton1)
                .add(0, 0, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 617, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jButton8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 163, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(jButton7)
                        .add(22, 22, 22))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(43, 43, 43)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton1)
                    .add(jComboBox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 229, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton7)
                    .add(jButton8))
                .add(97, 97, 97))
        );

        jTabbedPane1.addTab("Search The Product", jPanel2);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All Products", "24-hour Delivery Products", "8-hour Delivery Products" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductName", "ProductDecription", "SupplyEnterprise", "Rating"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton6.setText("Visualize The Location>>");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(49, 49, 49)
                .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 265, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jButton6)
                .add(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(41, 41, 41)
                .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 239, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 12, Short.MAX_VALUE)
                .add(jButton6)
                .addContainerGap())
        );

        jTabbedPane1.addTab("All The Product", jPanel1);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 418));

        jButton3.setText("Edit Cart>>");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 436, 151, -1));

        jButton4.setText("Add To Cart>>");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 436, 197, -1));

        jButton2.setText("<<Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 477, 151, -1));

        jButton5.setText("Proceed To Checkout>>");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 477, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       container.remove(this);
       CardLayout cl=(CardLayout) container.getLayout();
       cl.previous(container);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      String num= JOptionPane.showInputDialog("Please enter the number you want");
      int productQuantity=Integer.parseInt(num);
     
      int selectedProduct1=jTable1.getSelectedRow();
       int selectedProduct2=jTable2.getSelectedRow();
      if(selectedProduct1 >= 0)
      {
         Product product=(Product) jTable1.getValueAt(selectedProduct1, 0);
         if(product.getAvailability()<productQuantity){
           JOptionPane.showMessageDialog(null, "There is not so many in stock");
         }else{
           OrderItem orderItem=order.createAndAddOrderItem();
           orderItem.setProduct(product);
           orderItem.setQuantity(productQuantity);
           orderItem.setOrderItemPrice(orderItem.calculateItemPrice());
           if(!customer.getViewingHistory().getViewedOrderItems().contains(orderItem))
              customer.getViewingHistory().getViewedOrderItems().add(orderItem);
         }
      }
      if(selectedProduct2 >= 0)
      {
         Product product=(Product) jTable2.getValueAt(selectedProduct2, 0);
         if(product.getAvailability()<productQuantity){
           JOptionPane.showMessageDialog(null, "There is not so many in stock");
         }else{
           OrderItem orderItem=order.createAndAddOrderItem();
           orderItem.setProduct(product);
           orderItem.setQuantity(productQuantity);
           orderItem.setOrderItemPrice(orderItem.calculateItemPrice());
           customer.getViewingHistory().getViewedOrderItems().add(orderItem);
         }
      }
     
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        EditCartJPanel editCartJPanel=new EditCartJPanel(container,order);
        container.add(editCartJPanel,"editCartJPanel");
        CardLayout cl=(CardLayout) container.getLayout();
        cl.next(container);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       CheckoutJPanel checkoutJPanel=new CheckoutJPanel(order, customer, container, enterprise, ecoSystem);
       container.add(checkoutJPanel,"checkoutJPanel");
       CardLayout cl=(CardLayout) container.getLayout();
       cl.next(container);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int selectedNum=jComboBox1.getSelectedIndex();
        if(selectedNum==1){
          poplateTable1();
        }
        if(selectedNum==0){
          populateTable();
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       searchAndPopulateTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
       searchAndPopulateTable();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int selectedRow=jTable1.getSelectedRow();
        if(selectedRow>=0)
        {
           Product product=(Product) jTable1.getValueAt(selectedRow, 0);
           Location location=((SupplierEnterprise)product.getSupplyEnterprise()).getLocation();
           MapJFrame mapJFrame=new MapJFrame(location.getLatitude(),location.getLongtitude());
           mapJFrame.setVisible(true);
        
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         int selectedRow=jTable2.getSelectedRow();
        if(selectedRow>=0)
        {
           Product product=(Product) jTable2.getValueAt(selectedRow, 0);
           Location location=((SupplierEnterprise)product.getSupplyEnterprise()).getLocation();
           MapJFrame mapJFrame=new MapJFrame(location.getLatitude(),location.getLongtitude());
           mapJFrame.setVisible(true);
        
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       int rowSum=jTable1.getRowCount();
       Product temp=null;
       Location location=customer.getLocation();
       double sum=location.getLatitude()*location.getLatitude()+location.getLongtitude()*location.getLongtitude();
       if(rowSum>0)
       {
         for(int i=0;i<rowSum-1;i++)
         {
           Product product1= (Product) jTable1.getValueAt(i, 0);
           Location location1=((SupplierEnterprise)product1.getSupplyEnterprise()).getLocation();
           
           Product product2= (Product) jTable1.getValueAt(i+1, 0);
           Location location2=((SupplierEnterprise)product2.getSupplyEnterprise()).getLocation();
           double sum1=location1.getLatitude()*location1.getLatitude()+location1.getLongtitude()*location1.getLongtitude();
           double sum2=location2.getLatitude()*location2.getLatitude()+location2.getLongtitude()*location2.getLongtitude();
           if((sum-sum1)-(sum-sum2)>0){
             temp=product1;
           }else{
             temp=product2;
           }
           
         }
         String num= JOptionPane.showInputDialog("Please enter the number you want");
         int productQuantity=Integer.parseInt(num);
         OrderItem orderItem=order.createAndAddOrderItem();
         orderItem.setProduct(temp);
         orderItem.setQuantity(productQuantity);
         orderItem.setOrderItemPrice(orderItem.calculateItemPrice());
         customer.getViewingHistory().getViewedOrderItems().add(orderItem);
       
       }   
    }//GEN-LAST:event_jButton8ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
