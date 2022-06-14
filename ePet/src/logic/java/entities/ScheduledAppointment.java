package entities;

import exceptions.NoResultFoundException;
import persistence.dao.ScheduledAppointmentDAO;


import java.sql.SQLException;
import java.util.List;

public class ScheduledAppointment {
    private String scheduledAppId;
    private String data;
    private String user1;
    private String user2;
    private String location;

    public String getScheduledAppID() {
        return this.scheduledAppId;
    }

    public void setScheduledAppID(String scheduledAppID) {
        this.scheduledAppId = scheduledAppID;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUser1() {
        return this.user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getUser2() {
        return this.user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public List<ScheduledAppointment> seeScheduledAppointments() throws SQLException, NoResultFoundException {
        return ScheduledAppointmentDAO.seeScheduledApp(this);

    }

    public void deleteApp() throws SQLException {
        ScheduledAppointmentDAO.deleteApp(this);
    }
}
