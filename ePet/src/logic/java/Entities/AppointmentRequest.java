package Entities;

import Exceptions.NoResultFoundException;
import MODEL.DAO.AppointmentRequestDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class AppointmentRequest {
    private String Applicant;
    private String Post;
    private String Location;
   private String Date;
   private String Receiver;

    public String getReceiver() {
        return this.Receiver;
    }

    public void setReceiver(String rec) {
        Receiver=rec;
    }

    public void AppointmentRequest(String applicant, String post, String location, String date){
        this.Applicant=applicant;
        this.Post=post;
        this.Location=location;
        this.Date=date;
    }

    public String getApplicant() {
        return this.Applicant;
    }

    public void setApplicant(String applicant) {
        this.Applicant = applicant;
    }

    public String getPost() {
        return this.Post;
    }

    public void setPost(String post) {
        this.Post = post;
    }

    public String getLocation() {
        return this.Location;
    }

    public void setLocation(String location) {
        this.Location = location;
    }

    public String getDate() {
        return this.Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public List<AppointmentRequest> show_app_requests() throws SQLException, NoResultFoundException {
        return AppointmentRequestDAO.showAppRequests(this);
    }
    public void deny_request() throws SQLException{
        AppointmentRequestDAO.denyAppReq(this);
    }

    public void acceptApp() throws SQLException{
        AppointmentRequestDAO.acceptAppReq(this);
    }
}
