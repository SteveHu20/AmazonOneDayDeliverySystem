/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.enterpriseAdminRole;

import business.customer.Customer;
import business.dataset.Data;
import business.enterprise.Enterprise;
import business.enterprise.SupplierEnterprise;
import business.organization.InventoryOrganization;
import business.organization.Organization;
import business.organization.ShipOrganization;
import business.product.Category;
import business.product.Product;
import business.system.EcoSystem;
import business.workqueue.OrderItemRequest;
import business.workqueue.WorkRequest;
import java.awt.Color;
import java.awt.Font;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author baochenhu
 */
public class AnalysisJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AnalysisJPanel
     */
    JPanel container;
    Enterprise enterprise;
    EcoSystem ecosystem;
    //traning data array
    int[] a1;
    int[] b1;
    Integer[] dataIntSet;
    Integer[] x;
    int predictValue;
    //the parameter of linear line
    double a,b;
    //create map to contain history data
    Map<String,Integer> map=new HashMap<String,Integer>();
    public AnalysisJPanel(JPanel container, Enterprise enterprise, EcoSystem ecosystem) {
        initComponents();
        this.container=container;
        this.enterprise=enterprise;
        this.ecosystem=ecosystem;
        populateComboBox();
        populateOrderItemTable();
    }
    //populate the order item table
    public void populateOrderItemTable(){
        DefaultTableModel model=(DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
       for(Organization organization:enterprise.getOrganizationList())
       {
          if(organization instanceof ShipOrganization)
          {
             for(WorkRequest workRequest:organization.getWorkQueue().getWorkQueue())
             {
                OrderItemRequest orderItemRequest=(OrderItemRequest)workRequest;
                Object[] obj=new Object[4];
                obj[0] = orderItemRequest;
                obj[1] = ((Customer)orderItemRequest.getSender()).getCustomerName();
                obj[2] = orderItemRequest.getBeginDate();
                obj[3] = orderItemRequest.getShipDate();
                model.addRow(obj);
             }
          }
       
       }
    }
    
    
    public void populateComboBox()
    {  
       jComboBox1.removeAll();
       if(enterprise instanceof SupplierEnterprise)
       {
          SupplierEnterprise supplierEnterprise=(SupplierEnterprise)enterprise;
          for(Organization organization:supplierEnterprise.getOrganizationList())
          {
             if(organization instanceof InventoryOrganization)
             {
                InventoryOrganization inventoryOrganization=(InventoryOrganization)organization;
                for(Category category:inventoryOrganization.getCategoryCatalog()){
                   for(Product product:category.getProductList())
                   {
                      jComboBox1.addItem(product.getProductName());           
                   }
                }
             } 
          }
       }
    }
   
    public void leastSquare(int[] x,int[] y)
    {
       int n=0;
       double t1=0,t2=0,t3=0,t4=0;
       for(int i=0;i<y.length;++i)
       {
           t1 += x[i]*x[i];            
           t2 += x[i];
           t3 += x[i]*y[i];
           t4 += y[i];
           n++;
       
       }
        a = (t3*n - t2*t4) / (t1*n - t2*t2);  
        b = (t1*t4 - t2*t3) / (t1*n - t2*t2);     
    
    }
    public double getY(double x)
    {
       return a*x+b;
    }
    
    public ArrayList<Integer> getData(String productName){
        ArrayList<Integer> tempList=new ArrayList<>();
        if(enterprise instanceof SupplierEnterprise)
       {
          SupplierEnterprise supplierEnterprise=(SupplierEnterprise)enterprise;
          for(Organization organization:supplierEnterprise.getOrganizationList())
          {
             if(organization instanceof InventoryOrganization)
             {
                InventoryOrganization inventoryOrganization=(InventoryOrganization)organization;
                for(Data data : inventoryOrganization.getDataSet().getDataSet())
                {
                   if(data.getProductName().equals(productName))
                   {
                      tempList.add(data.getSaleAmount());
                   }
                   
                }
             }
          }
       }  
       return tempList;
    
    }
    private void storeData(){
        int count=0;
        ArrayList<Integer> tempList;
         if(enterprise instanceof SupplierEnterprise)
       {
          SupplierEnterprise supplierEnterprise=(SupplierEnterprise)enterprise;
          for(Organization organization:supplierEnterprise.getOrganizationList())
          {
             if(organization instanceof InventoryOrganization)
             {
                InventoryOrganization inventoryOrganization=(InventoryOrganization)organization;
                for(Category category:inventoryOrganization.getCategoryCatalog())
                {
                   for(Product product:category.getProductList())
                   {
                      tempList=getData(product.getProductName());
                       if(tempList!=null)
                      {
                         for(Integer num:tempList)
                         {
                            count+=num.intValue();
                         }
                         map.put(product.getProductName(), count);
                         count=0;
                      }
                   
                   }
                }
             }
          }
       }
     
     
     }
    private XYDataset createDataset(){
       final XYSeries series1 = new XYSeries("The real Sale Data");
       for(int i=0;i<a1.length;i++){
          series1.add(a1[i], b1[i]);
       }
       final XYSeries series2 = new XYSeries("The prediction line");
       series2.add(a1[0], b1[0]);
       series2.add(a1[a1.length-1]+1, predictValue);
       
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        return dataset;
    }
    
     private JFreeChart createChart(final XYDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "Machine Learning Result",      // chart title
            "X",                      // x axis label
            "Y",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

//        final StandardLegend legend = (StandardLegend) chart.getLegend();
  //      legend.setDisplaySeriesShapes(true);
        
        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
    //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.
                
        return chart;
        
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
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Train>>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("View>>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sales", "Time"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Malayalam Sangam MN", 1, 18)); // NOI18N
        jLabel1.setText("The Next Month Sale May be:");

        jLabel2.setFont(new java.awt.Font("Malayalam Sangam MN", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 51, 0));

        jPanel2.setLayout(new java.awt.BorderLayout());

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane1))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(45, 45, 45)
                                .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 147, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(48, 48, 48)
                                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(32, 32, 32)
                                .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(34, 34, 34)
                                .add(jLabel1)
                                .add(46, 46, 46)
                                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 219, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(0, 39, Short.MAX_VALUE)))
                .addContainerGap())
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton1)
                    .add(jButton2))
                .add(18, 18, 18)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(30, 30, 30)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Prediction", jPanel1);

        jButton3.setText("View The Demand Map");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel4.setLayout(new java.awt.BorderLayout());

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(41, 41, 41)
                .add(jButton3)
                .addContainerGap(340, Short.MAX_VALUE))
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(14, 14, 14)
                .add(jButton3)
                .add(32, 32, 32)
                .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Analysis Demand", jPanel3);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ProductName", "Customer", "BeginTimeStamp", "EndTimeStamp"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel3.setFont(new java.awt.Font("Malayalam MN", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 0));
        jLabel3.setText("All the order item:");

        jButton4.setText("Visualize the proportion>>");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel6.setLayout(new java.awt.BorderLayout());

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE))
            .add(jPanel5Layout.createSequentialGroup()
                .add(23, 23, 23)
                .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 174, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jButton4)
                .add(38, 38, 38))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 161, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jButton4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Analysis Customer", jPanel5);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
   
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        ArrayList<Integer> dataSet=getData(jComboBox1.getSelectedItem().toString());
        dataIntSet=dataSet.toArray(new Integer[dataSet.size()]);
        x=new Integer[dataIntSet.length];
        for(int i=0;i<dataIntSet.length;i++)
        {
           x[i]=i;
        }
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for(int j=0;j<dataIntSet.length;j++)
        {
           Object[] obj=new Object[2];
           obj[0]=dataIntSet[j];
           obj[1]=x[j];
           model.addRow(obj);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed
   
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        a1=new int[x.length];
        b1=new int[x.length];
        for(int i=0;i<x.length;i++){
          a1[i]=x[i].intValue();
          b1[i]=dataIntSet[i].intValue();
       }
        leastSquare(a1, b1);
        Double a=getY(x[x.length-1]+1);
        predictValue=a.intValue();
        jLabel2.setText(predictValue+"");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        
        jPanel2.add(chartPanel);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       storeData();
       System.out.println(map.isEmpty());
       for(Map.Entry entry:map.entrySet()){
          System.out.println((String)entry.getKey()+(Integer)entry.getValue()+"");
          dataset.setValue((Integer)entry.getValue(), "Demand", (String)entry.getKey());
       
       }
  //     dataset.addValue(30, "Demand", "bb");
       JFreeChart chart = ChartFactory.createBarChart("Demand of All Product",
"Product", "Demant", dataset, PlotOrientation.VERTICAL,false, true, false);
       final ChartPanel chartPanel = new ChartPanel(chart);
       jPanel4.add(chartPanel);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       int selectedRow= jTable2.getSelectedRow();
       if(selectedRow>=0)
       {
         
         OrderItemRequest orderItemRequest=(OrderItemRequest) jTable2.getValueAt(selectedRow, 0);
         DefaultPieDataset dataset = new DefaultPieDataset();
         long inventoryPeriod=orderItemRequest.getInventoryDate().getTime()-orderItemRequest.getBeginDate().getTime();
         long packagePeriod=orderItemRequest.getPackageDate().getTime()-orderItemRequest.getInventoryDate().getTime();
         long shipPeriod=orderItemRequest.getShipDate().getTime()-orderItemRequest.getPackageDate().getTime();
         long sum=inventoryPeriod+packagePeriod+shipPeriod;
//         System.out.println(sum);
//         System.out.println(packagePeriod*100/sum);
//         System.out.println(shipPeriod*100/sum);
         //inventoryPeriod/sum
         //packagePeriod/sum
         //shipPeriod/sum
         dataset.setValue("InventoryPerioud", inventoryPeriod*100/sum);
         dataset.setValue("PackagePeriod",packagePeriod*100/sum);
         dataset.setValue("ShipPeriod", shipPeriod*100/sum);
      
         JFreeChart chart=ChartFactory.createPieChart3D("Time Period Analysis", dataset, true, false, false);
       
         PiePlot pieplot = (PiePlot) chart.getPlot();
       //  pieplot.setLabelFont(new Font("宋体",0,12));
         pieplot.setNoDataMessage("There is no data");
         pieplot.setCircular(false);
         pieplot.setLabelGap(0.02D);
         final ChartPanel chartPanel = new ChartPanel(chart);
         jPanel6.removeAll();
         jPanel6.add(chartPanel);
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
