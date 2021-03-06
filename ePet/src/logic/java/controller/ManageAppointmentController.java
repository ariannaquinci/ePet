package controller;

import beans.AppointmentRequestBean;
import beans.ScheduledAppointmentBean;
import entities.*;
import exceptions.NoResultFoundException;
import service.Entity;
import service.factories.AppointmentRequestFactory;
import service.factories.ScheduledAppointmentFactory;
import service.Factory;
import service.Types;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public class ManageAppointmentController {
    /*applico singleton*/
    private static ManageAppointmentController instance=null;

    public static ManageAppointmentController getInstance(){
        if(instance==null){
            instance=new ManageAppointmentController();
        }
        return instance;
    }
    public void denyApp(AppointmentRequestBean bean) throws SQLException{



        Entity appRequest= Factory.getInstance().getObject(Types.APPOINTMENTREQUEST);
        AppointmentRequest appReq=(AppointmentRequest)appRequest.createObject();
        appReq.setPost(bean.getPost());
        appReq.setApplicant(bean.getApplicant());

        appReq.denyRequest();
    }

    public void acceptApp(AppointmentRequestBean bean) throws SQLException{
        Entity appRequest= Factory.getInstance().getObject(Types.APPOINTMENTREQUEST);
        AppointmentRequest appReq=(AppointmentRequest)appRequest.createObject();
        appReq.setDate(bean.getDate());
        appReq.setReceiver(bean.getReceiver());
        appReq.setApplicant(bean.getApplicant());
        appReq.acceptApp();
    }



    public ObservableList<AppointmentRequestBean> showAppRequests(AppointmentRequestBean bean) throws NoResultFoundException{
            Entity appReq=Factory.getInstance().getObject(Types.APPOINTMENTREQUEST);
            AppointmentRequest  appR=(AppointmentRequest)appReq.createObject();
            appR.setReceiver(bean.getReceiver());
            try{
                List<AppointmentRequest> l =appR.showAppRequests();
                return entityToBean(l);
            }catch(SQLException s){
                throw new NoResultFoundException();
            }
    }
    private ObservableList<AppointmentRequestBean> entityToBean(List<AppointmentRequest> src){
        Entity factory= Factory.getInstance().getObject(Types.APPOINTMENTREQUEST);
        ObservableList<AppointmentRequestBean> dest= FXCollections.observableArrayList();
        for(AppointmentRequestBean i: ((AppointmentRequestFactory)factory).extractAppReqBeanList(src)){
            dest.add(i);
        }
        return dest;
    }

    private ObservableList<ScheduledAppointmentBean> entityToBean2(List<ScheduledAppointment> src){
        Entity factory= Factory.getInstance().getObject(Types.SCHEDULEDAPPOINTMENT);
        ObservableList<ScheduledAppointmentBean> dest= FXCollections.observableArrayList();
        for(ScheduledAppointmentBean i: ((ScheduledAppointmentFactory)factory).extractSchedAppBeanList(src)){
            dest.add(i);
        }
        return dest;
    }

    public ObservableList<ScheduledAppointmentBean> showScheduledApps(ScheduledAppointmentBean bean) throws NoResultFoundException{
        Entity factorySchedApp = Factory.getInstance().getObject(Types.SCHEDULEDAPPOINTMENT);
        ScheduledAppointment schedApp = (ScheduledAppointment) factorySchedApp.createObject();

        schedApp.setUser1(bean.getUser1());


        try {
            List<ScheduledAppointment> l= schedApp.seeScheduledAppointments();
            return entityToBean2(l);



        } catch (SQLException e) {
            throw new NoResultFoundException("No appointments to show");
        }
    }

    public void deleteApp(ScheduledAppointmentBean bean) throws SQLException {

        Entity schedApp= Factory.getInstance().getObject(Types.SCHEDULEDAPPOINTMENT);
        ScheduledAppointment scheduledApp=(ScheduledAppointment) schedApp.createObject();
        scheduledApp.setScheduledAppID(bean.getScheduledAppID());
        scheduledApp.deleteApp();
    }
}
