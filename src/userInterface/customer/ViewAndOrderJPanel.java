/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.customer;

import business.customer.Customer;
import business.customer.OrderItem;
import business.customer.Payment;

import business.enterprise.Enterprise;
import business.enterprise.RateAndReview;
import business.enterprise.SupplierEnterprise;
import business.organization.Organization;
import business.system.EcoSystem;
import business.workqueue.OrderItemRequest;
import business.workqueue.PaymentRequest;
import business.workqueue.ReturnRequest;
import business.workqueue.WorkRequest;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baochenhu
 */
public class ViewAndOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewAndOrderJPanel
     */
    Customer customer;
    JPanel container;
    Organization  organization;
    Enterprise enterprise;
    EcoSystem ecoSystem;
    public ViewAndOrderJPanel(Customer customer, JPanel container,Organization  organization,Enterprise enterprise,EcoSystem ecoSystem) {
        initComponents();
        this.customer=customer;
        this.container=container;
        this.organization=organization;
        this.enterprise=enterprise;
        this.ecoSystem=ecoSystem;
        populateTable();
        populateTable1();
        populatePaymentTable();
        populateReturnedPayment();
    }
    //populate the payment table jTable4
    public void populatePaymentTable(){
       DefaultTableModel model=(DefaultTableModel) jTable4.getModel();
       model.setRowCount(0);
       for(Payment payment:customer.getFinancialAccount().getPayments())
       {
         for(OrderItem orderItem:payment.getOrder().getOrderItems())
         {
            Object[] obj=new Object[4];
            obj[0]=orderItem;
            obj[1]=orderItem.getQuantity();
            obj[2]=payment.getPayment();
            obj[3]=payment.getDate();
            model.addRow(obj);
         }
       }
    
    }
    
    //jTable3 return money
    public void populateReturnedPayment(){
       DefaultTableModel model=(DefaultTableModel) jTable3.getModel();
       model.setRowCount(0);
       for(WorkRequest workRequest:customer.getWorkQueue().getWorkQueue())
       {
          if(workRequest instanceof PaymentRequest )
          {  
             PaymentRequest paymentRequest=(PaymentRequest) workRequest;
             for(OrderItem orderItem:paymentRequest.getPayment().getOrder().getOrderItems())
             {  
                Object[] obj = new Object[4];
                obj[0] = paymentRequest.getPayment().getPayment();
                obj[1] = paymentRequest.getPayment().getDate();
                obj[2] = orderItem;
                obj[3] = orderItem.getQuantity();
                model.addRow(obj);
             }
          }
       }
    }
    
    public void populateTable(){
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for(WorkRequest workRequest : customer.getWorkQueue().getWorkQueue())
        {  if(workRequest instanceof OrderItemRequest){
           OrderItemRequest orderItemRequest=(OrderItemRequest) workRequest;
           if(!orderItemRequest.getStatus().equalsIgnoreCase("delivered"))
           {
              Object[] obj=new Object[4];
              obj[0] = orderItemRequest;
              obj[1] = orderItemRequest.getOrderItem().getQuantity();
              obj[2] = orderItemRequest.getOrderItem().getOrderItemPrice();
              obj[3] = orderItemRequest.getBeginDate();
           
              model.addRow(obj);
         
           }
         }
        }
    
    }
    //populate the history order
     public void populateTable1(){
        DefaultTableModel model=(DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        for(WorkRequest workRequest : customer.getWorkQueue().getWorkQueue())
        { 
           if(workRequest instanceof OrderItemRequest){
               
             OrderItemRequest orderItemRequest=(OrderItemRequest) workRequest;
           if(orderItemRequest.getStatus().equalsIgnoreCase("delivered"))
           {
              Object[] obj=new Object[5];
              obj[0] = orderItemRequest;
              obj[1] = orderItemRequest.getOrderItem().getQuantity();
              obj[2] = orderItemRequest.getOrderItem().getOrderItemPrice();
              obj[3] = orderItemRequest.getBeginDate();
              obj[4] = orderItemRequest.getStatus();
              model.addRow(obj);
         
           }
           }else if(workRequest instanceof ReturnRequest){
             ReturnRequest returnRequest=(ReturnRequest)workRequest;
             Object[] obj1=new Object[5];
             obj1[0] = returnRequest.getOrderItemRequest();
             obj1[1] = returnRequest.getOrderItemRequest().getOrderItem().getQuantity();
             obj1[2] = returnRequest.getOrderItemRequest().getOrderItem().getOrderItemPrice();
             obj1[3] = returnRequest.getOrderItemRequest().getBeginDate();
             obj1[4] = returnRequest.getStatus();
             model.addRow(obj1);
             
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(0, 204, 204));
        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setForeground(new java.awt.Color(0, 102, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Quantity", "Price", "OrderDate"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 170, 605, 145));

        jRadioButton1.setText("-------------");
        jRadioButton1.setEnabled(false);
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 79, -1, -1));

        jRadioButton2.setText("--------------");
        jRadioButton2.setEnabled(false);
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 79, -1, -1));

        jRadioButton3.setText("--------------");
        jRadioButton3.setEnabled(false);
        jPanel1.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 79, -1, -1));

        jRadioButton4.setText("--------------");
        jRadioButton4.setEnabled(false);
        jPanel1.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 79, -1, -1));

        jButton1.setText("Track Package");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 341, 188, -1));

        jLabel3.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        jLabel3.setText("Package");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 54, 75, -1));

        jLabel4.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        jLabel4.setText("Shipping");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 54, 75, -1));

        jLabel5.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        jLabel5.setText("Inventory");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 54, 75, -1));

        jLabel6.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        jLabel6.setText("Delivered");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 54, 75, -1));

        jTabbedPane1.addTab("Order Status", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Quantity", "Price", "OrderDate", "Status"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 29, 589, 138));
        jPanel2.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 217, -1, -1));

        jLabel1.setText("Rate This Service");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 224, -1, -1));
        jPanel2.add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 217, -1, -1));
        jPanel2.add(jRadioButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 217, -1, -1));
        jPanel2.add(jRadioButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 217, -1, -1));
        jPanel2.add(jRadioButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 217, -1, -1));

        jLabel2.setText("Reviews");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 301, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 288, -1, -1));

        jButton2.setText("Upload");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 412, -1, -1));

        jButton3.setText("Return>>");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 185, -1, -1));

        jTabbedPane1.addTab("Order History", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Amount", "Time", "Product", "Quantity"
            }
        ));
        jScrollPane4.setViewportView(jTable3);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 580, 140));

        jLabel7.setFont(new java.awt.Font("Malayalam MN", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 0));
        jLabel7.setText("All The Payment:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product", "Quantity", "AmountOfMoney", "Time"
            }
        ));
        jScrollPane5.setViewportView(jTable4);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 570, 160));

        jLabel8.setFont(new java.awt.Font("Malayalam MN", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 0));
        jLabel8.setText("Returned Money:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jTabbedPane1.addTab("Financial Status", jPanel3);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int selectedRow = jTable1.getSelectedRow();
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false); 
        jRadioButton4.setSelected(false);
         jRadioButton1.setForeground(Color.black);
        jRadioButton2.setForeground(Color.black);
        jRadioButton3.setForeground(Color.black);
        jRadioButton4.setForeground(Color.black);
       if(selectedRow>=0)
       {
          OrderItemRequest orderItemRequest=(OrderItemRequest) jTable1.getValueAt(selectedRow, 0);
          switch(orderItemRequest.getStatus()){
              case "Inventory":
                  jRadioButton1.setSelected(true);
                  jRadioButton1.setForeground(Color.yellow);
                  break;
              case "Packaging":
                  jRadioButton2.setSelected(true);
                  jRadioButton2.setForeground(Color.yellow);
                  break;
              case "Shipping":
                  jRadioButton3.setSelected(true);
                   jRadioButton3.setForeground(Color.yellow);
                  break;
              case "Delivered":
                  jRadioButton4.setSelected(true);
                   jRadioButton4.setForeground(Color.yellow);
                  break;
          }
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       int counter=0;
       if(jRadioButton5.isSelected())
          counter++;
       if(jRadioButton6.isSelected())
          counter++;
       if(jRadioButton7.isSelected())
          counter++;
       if(jRadioButton8.isSelected())
          counter++;
       if(jRadioButton9.isSelected())
          counter++;
       //Get the selected Product
       int selectedRow=jTable2.getSelectedRow();
       if(selectedRow>=0)
       {
          OrderItemRequest orderItemRequest=(OrderItemRequest) jTable2.getValueAt(selectedRow, 0);
          SupplierEnterprise supplierEnterprise=(SupplierEnterprise) orderItemRequest.getOrderItem().getProduct().getSupplyEnterprise();
          RateAndReview rateAndReview=new RateAndReview();
          rateAndReview.setRateNum(counter);
          rateAndReview.setReviews(jTextArea1.getText());
          supplierEnterprise.getRateAndReviewDir().add(rateAndReview);
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selectedRow = jTable2.getSelectedRow();
        if(selectedRow>=0)
        {
          OrderItemRequest orderItemRequest=(OrderItemRequest) jTable2.getValueAt(selectedRow, 0);
          ReturnRequest returnRequest=new ReturnRequest();
          returnRequest.setOrderItemRequest(orderItemRequest);
          returnRequest.setStatus("Returning");
          returnRequest.setSender(customer);
          customer.getWorkQueue().getWorkQueue().remove(orderItemRequest);
          orderItemRequest.getReceiver().getWorkQueue().createAndAddWorkRequest(returnRequest);
     //     populateTable1();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
