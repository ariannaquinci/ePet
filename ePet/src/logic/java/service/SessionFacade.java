package service;

import utils.UserEnum;

public class SessionFacade {
    /*applico il pattern singleton per avere una sola istanza di SessionFacade*/
    private static SessionFacade instance = null;
    private UserEnum currUserType;

    private String UserID;

    private SessionFacade() {
        currUserType = null;

    }

    public static SessionFacade getSession() {
        if (instance == null) {
            instance = new SessionFacade();
        }
        return instance;
    }


    public UserEnum getCurrUserType() {
        return currUserType;
    }

    public void setCurrUserType(UserEnum currUser) {
        currUserType = currUser;
    }



    public String getID() {
        return UserID;
    }

    public void setID(String accountID) {
        UserID = accountID;
    }


}
