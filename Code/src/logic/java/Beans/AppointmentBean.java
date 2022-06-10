package Beans;

public class AppointmentBean {
    private UserBean User1;
    private UserBean User2;
    private String Location;
    private String date;
    private String appID;

    public UserBean getUser1() {
        return this.User1;
    }
    public void setUser1(UserBean user1) {
        this.User1 = user1;
    }


    public UserBean getUser2() {
        return this.User2;
    }

    public void setUser2(UserBean user2) {
        this.User2 = user2;
    }

    public String getLocation() {
        return this.Location;
    }

    public void setLocation(String location) {
        this.Location = location;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAppID() {
        return this.appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }


}
