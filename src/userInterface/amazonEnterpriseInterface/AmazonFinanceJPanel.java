/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.amazonEnterpriseInterface;

import business.customer.Customer;
import business.customer.Invoicement;
import business.customer.Order;
import business.customer.OrderItem;
import business.customer.Payment;
import business.enterprise.Enterprise;
import business.organization.AmazonFinanceOrganization;
import business.organization.Organization;
import business.organization.SupplierFinanceOrganization;
import business.system.EcoSystem;
import business.workqueue.PaymentRequest;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baochenhu
 */
public class AmazonFinanceJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AmazonFinanceJPanel
     */
    JPanel container;
    Organization organization;
    Enterprise enterprise;
    EcoSystem ecosystem;
    public AmazonFinanceJPanel(JPanel container, Organization organization, Enterprise enterprise, EcoSystem ecosystem) {
        initComponents();
        this.container=container;
        this.organization=organization;
        this.enterprise=enterprise;
        this.ecosystem=ecosystem;
        populateTable();
    }
    
    public void populateTable(){
       DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
       model.setRowCount(0);
       for(Invoicement invoicement:((AmazonFinanceOrganization)organization).getInvoicementHistory().getInvoicementList())
       {
           Object[] obj=new Object[4];
           obj[0]  = invoicement;
           obj[2]  = invoicement.getPayment().getDate();
           obj[1]  = invoicement.getPayment().getPayment();
           obj[3]  = "Pending";
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Customer", "PaidAmount", "PaidTime", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 73, 580, 181));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pay to Supplier", "Return to Customer" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 266, 233, -1));

        jLabel2.setText("Process Way:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 270, -1, -1));

        jButton1.setText("Process");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 349, -1, -1));

        jLabel1.setFont(new java.awt.Font("Malayalam MN", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 0));
        jLabel1.setText("Amazon Finance Centor");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 17, 275, -1));

        jTabbedPane1.addTab("Payment Process", jPanel1);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int selectedRow=jTable1.getSelectedRow();
       if(selectedRow>=0){
          if(jComboBox1.getSelectedIndex()==0)
          {
             Invoicement invoicement=(Invoicement) jTable1.getValueAt(selectedRow, 0);
             Payment payment=invoicement.getPayment();
             PaymentRequest paymentRequest=new PaymentRequest();
             paymentRequest.setPayment(payment);
             paymentRequest.setBeginDate(new Date());
             Order order=invoicement.getOrder();
             for(OrderItem orderItem:order.getOrderItems())
             {
               for(Organization organization:  orderItem.getProduct().getSupplyEnterprise().getOrganizationList()){
                   if(organization instanceof SupplierFinanceOrganization){
                       organization.getWorkQueue().createAndAddWorkRequest(paymentRequest);
                   }
               }
             
             }
             jTable1.setValueAt("Processed", selectedRow, 3);
          }else{
             Invoicement invoicement=(Invoicement) jTable1.getValueAt(selectedRow, 0);
             Payment payment=invoicement.getPayment();
             PaymentRequest paymentRequest=new PaymentRequest();
             paymentRequest.setPayment(payment);
             paymentRequest.setBeginDate(new Date());
             Customer customer=invoicement.getCustomer();
             customer.getWorkQueue().createAndAddWorkRequest(paymentRequest);
             jTable1.setValueAt("Returned", selectedRow, 3);
          }
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
