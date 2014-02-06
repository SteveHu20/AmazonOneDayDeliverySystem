/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.amazonEnterpriseInterface;

import business.customer.Customer;
import business.enterprise.Enterprise;
import business.organization.CustomerOrganization;
import business.organization.Organization;
import business.role.CustomerRole;
import business.system.EcoSystem;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baochenhu
 */
public class CustomerManagerJPanel extends javax.swing.JPanel {
    JPanel container;
    Organization organization;
    Enterprise enterprise;
    EcoSystem ecosystem;
    /**
     * Creates new form CustomerMananerJPanel
     */
    public CustomerManagerJPanel(JPanel container, Organization organization, Enterprise enterprise, EcoSystem ecosystem) {
        initComponents();
        this.container=container;
        this.organization=organization;
        this.enterprise=enterprise;
        this.ecosystem=ecosystem;
        populateTable();
    }
    
    public void populateTable()
    {  DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
       model.setRowCount(0);
       for(Customer customer:((CustomerOrganization)organization).getCustomerList())
       {
          Object[] obj=new Object[4];
          obj[0]=customer;
          obj[1]=customer.getCustomerName();
          obj[2]=customer.getCustomerPassword();              
          model.addRow(obj);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CustomerID", "CustomerName", "CustomerPd"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 80, 610, 167));

        jButton1.setText("Delete");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 449, -1, -1));

        jLabel1.setText("CustomerName:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 271, -1, -1));

        jLabel2.setText("CustomerPassword:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 332, -1, -1));
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 265, 240, -1));
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 326, 240, -1));

        jButton2.setText("Add>>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 449, -1, -1));

        jLabel3.setFont(new java.awt.Font("Malayalam Sangam MN", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 0));
        jLabel3.setText("Customer Administrator Centor");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       CustomerOrganization customerOrganization=(CustomerOrganization) organization;
//     Customer customer=customerOrganization.createAndAddCustomer();
       Customer customer=new Customer();
       CustomerRole role=new CustomerRole();
       customer.setRole(role);
  
       customer.setCustomerName(jTextField1.getText());
       customer.setCustomerPassword(jTextField2.getText());
       customerOrganization.createAndAddCustomer(customer);
       populateTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
