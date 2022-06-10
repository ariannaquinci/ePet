package Beans;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ScheduledAppointmentBean {
    private String ScheduledAppID;
    private String data;
    private String user1;
    private String user2;
    private String location;

    public String getScheduledAppID() {
        return ScheduledAppID;
    }

    public void setScheduledAppID(String scheduledAppID) {
        ScheduledAppID = scheduledAppID;
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
