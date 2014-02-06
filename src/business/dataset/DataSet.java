/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.dataset;

import java.util.ArrayList;

/**
 *
 * @author baochenhu
 */
public class DataSet {
    private ArrayList<Data> dataSet=new ArrayList<>();

    public ArrayList<Data> getDataSet() {
        return dataSet;
    }

    public void setDataSet(ArrayList<Data> dataSet) {
        this.dataSet = dataSet;
    }
    
    public void createData(Data data){
       dataSet.add(data);
    }
    
}
