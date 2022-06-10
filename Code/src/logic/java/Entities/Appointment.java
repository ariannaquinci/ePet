package Entities;

import MODEL.DAO.AppointmentDAO;

import java.sql.SQLException;
import java.time.LocalDate;

public class Appointment {
    private User User1;
    private User User2;
    private String Location;
    private LocalDate date;
    private String appID;
    public void Appointment(User usr1, User usr2, String location, LocalDate date, String appID){
        this.User1=usr1;
        this.User2=usr2;
        this.Location=location;
        this.date=date;
        this.appID=appID;

    }
    public User getUser1() {
        return this.User1;
    }
    public void setUser1(User user1) {
        this.User1 = user1;
    }


    public User getUser2() {
        return this.User2;
    }

    public void setUser2(User user2) {
        this.User2 = user2;
    }

    public String getLocation() {
        return this.Location;
    }

    public void setLocation(String location) {
        this.Location = location;
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
