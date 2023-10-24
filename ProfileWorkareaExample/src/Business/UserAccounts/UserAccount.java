/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccounts;

import Business.Profiles.Profile;
import org.mindrot.jbcrypt.BCrypt;



/**
 *
 * @author kal bugrara
 */
public class UserAccount {
    
    Profile profile;
    String username;
    String password;
    boolean isEnabled;
    
    public UserAccount (Profile profile, String un, String pw, boolean isEnabled){
        username = un;
         password = pw;
         this.profile = profile;
         this.isEnabled = isEnabled;

    }

    public String getPersonId(){
        return profile.getPerson().getPersonId();
    }
    
    public String getUserLoginName(){
        return username;
    }

        public boolean isMatch(String id){
        if(getPersonId().equals(id)) return true;
        return false;
    }
        
        //for Login 
        public boolean IsValidUser(String un, String pw){
        
            if (username.equalsIgnoreCase(un) && BCrypt.checkpw(pw, this.password)) return true;
            else return false;
        
        }
        public String getRole(){
            return profile.getRole();
        }
        
        public Profile getAssociatedPersonProfile(){
            return profile;
        }

    public boolean isIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }
        
        
        
    @Override
        public String toString(){
            
            return getUserLoginName();
        }
        
}

