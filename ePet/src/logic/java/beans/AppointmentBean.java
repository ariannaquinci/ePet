package beans;

public class AppointmentBean {
    private UserBean user1;
    private UserBean user2;
    private String location;
    private String date;
    private String appID;

    public UserBean getUser1() {
        return this.user1;
    }
    public void setUser1(UserBean user1) {
        this.user1 = user1;
    }


    public UserBean getUser2() {
        return this.user2;
    }

    public void setUser2(UserBean user2) {
        this.user2 = user2;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
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
