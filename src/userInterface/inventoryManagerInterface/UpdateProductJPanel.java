/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.inventoryManagerInterface;

import business.product.Product;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author baochenhu
 */
public class UpdateProductJPanel extends javax.swing.JPanel {

    /**
     * Creates new form UpdateProductJPanel
     */
    JPanel container;
    Product product;
    public UpdateProductJPanel(JPanel container,Product product) {
        initComponents();
        this.container=container;
        this.product=product;
        populateProduct();
    }
    
    private void populateProduct(){
       jTextField1.setText(product.getProductName());
       jTextField2.setText(product.getPrice()+"");
       jTextField3.setText(product.getAvailability()+"");
       jTextField4.setText(product.getProductDescription());
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Product Name:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 81, -1, -1));
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 81, 287, -1));

        jLabel2.setText("Product Price:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 141, -1, -1));

        jLabel3.setText("Product Quantity:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 201, -1, -1));
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 131, 287, -1));
        add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 191, 287, -1));

        jLabel4.setText("Product Decription:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 251, -1, -1));
        add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 241, 287, -1));

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 315, -1, -1));

        jButton2.setText("<<Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 315, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       product.setProductName(jTextField1.getText());
       product.setPrice(Float.parseFloat(jTextField2.getText()));
       product.setAvailability(Integer.parseInt(jTextField3.getText()));
       product.setProductDescription(jTextField4.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      container.remove(this);
       CardLayout cl=(CardLayout) container.getLayout();
       cl.previous(container);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
