/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import business.organization.Organization;
import business.userAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author baochenhu
 */
public class WorkRequest {
    private UserAccount sender;
    private Organization receiver;
    private String status;

        private Date beginDate;
        private Date resolveDate;
    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public Organization getReceiver() {
        return receiver;
    }

    public void setReceiver(Organization receiver) {
        this.receiver = receiver;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

   

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
}
