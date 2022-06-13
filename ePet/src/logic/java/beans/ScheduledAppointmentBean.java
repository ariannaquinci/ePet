package beans;

public class ScheduledAppointmentBean {
    private String scheduledAppID;
    private String data;
    private String user1;
    private String user2;
    private String location;

    public String getScheduledAppID() {
        return scheduledAppID;
    }

    public void setScheduledAppID(String schedID) {
        scheduledAppID = schedID;
    }



    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
