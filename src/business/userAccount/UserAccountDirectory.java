/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.userAccount;

import java.util.ArrayList;

/**
 *
 * @author baochenhu
 */
public class UserAccountDirectory {
    ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
       userAccountList=new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount createAndAddUserAccount(){
        UserAccount userAccount=new UserAccount();
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public UserAccount AuthentificateUserAccount(String userName,String password){
        for(UserAccount ua:userAccountList)
        {
           if(userName.equals(ua.getUserName())&&password.equals(ua.getPasswork()))
           {
              return ua;
           
           }
        }
       return null;
    }
}
