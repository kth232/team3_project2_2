package org.choongang.start;

import lombok.Getter;
import lombok.Setter;

public class UserSession {
    private static UserSession instance;
    @Setter @Getter
    private String userName;
    @Setter @Getter
    private String userJob;
    private UserSession(){}

    public static UserSession getInstance(){
        if (instance == null){
            instance = new UserSession();
        }
        return instance;
    }
//    public String getUserName(){
//        return userName;
//    }
//    public void setUserName(String userName){
//        this.userName = userName;
//    }
//    public String getUserJob(){
//        return userJob;
//    }
//    public void setUserJob(String userJob){
//        this.userJob = userJob;
//    }

}
