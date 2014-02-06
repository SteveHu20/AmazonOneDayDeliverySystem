/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import java.util.ArrayList;

/**
 *
 * @author baochenhu
 */
public class WorkQueue {
    ArrayList<WorkRequest> workQueue;

    public WorkQueue() {
       workQueue=new ArrayList<>();   
    }

    public ArrayList<WorkRequest> getWorkQueue() {
        return workQueue;
    }
    
    public void createAndAddWorkRequest(WorkRequest workRequest){
       workQueue.add(workRequest);
    }   
    
}
