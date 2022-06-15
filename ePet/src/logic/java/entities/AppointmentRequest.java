package entities;

import exceptions.NoResultFoundException;
import persistence.dao.AppointmentRequestDAO;

import java.sql.SQLException;
import java.util.List;

public class AppointmentRequest {
    private String applicant;
    private String post;
    private String location;
   private String date;
   private String receiver;

    public String getReceiver() {
        return this.receiver;
    }

    public void setReceiver(String rec) {
       receiver=rec;
    }

    public AppointmentRequest(){//default constructor
        //
    }

    public String getApplicant() {
        return this.applicant;
    }

    public void setApplicant(String app){
        this.applicant = app;
    }

    public String getPost() {
        return this.post;
    }

    public void setPost(String p) {
        this.post = p;
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

    public void setDate(String d) {
        date = d;
    }

    public List<AppointmentRequest> showAppRequests() throws SQLException, NoResultFoundException {
        return AppointmentRequestDAO.showAppRequests(this);
    }
    public void denyRequest() throws SQLException{
        AppointmentRequestDAO.denyAppReq(this);
    }

    public void acceptApp() throws SQLException{
        AppointmentRequestDAO.acceptAppReq(this);
    }
}
