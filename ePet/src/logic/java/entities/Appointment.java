package entities;

import persistence.dao.AppointmentDAO;

import java.sql.SQLException;
import java.time.LocalDate;

public class Appointment {
    private User user1;
    private User user2;
    private String location;
    private LocalDate date;
    private String appID;

    public Appointment(){
        //default constructor
    }
    public User getUser1() {
        return this.user1;
    }
    public void setUser1(User user1) {
        this.user1 = user1;
    }


    public User getUser2() {
        return this.user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAppID() {
        return this.appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public void scheduleApp() throws SQLException {
        AppointmentDAO.scheduleApp(this);
    }
}
