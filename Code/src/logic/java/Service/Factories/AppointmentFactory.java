package Service.Factories;

import Beans.AppointmentBean;
import Beans.UserBean;
import Entities.Appointment;
import Service.Entity;


public class AppointmentFactory implements Entity {
    @Override
    public Appointment createObject() {
        return new Appointment();
    }

    public AppointmentBean extractAppointmentBean(Appointment app){
        UserBean userbean1= new UserBean();
        UserBean userbean2= new UserBean();
        AppointmentBean appBean= new AppointmentBean();

        appBean.setAppID(app.getAppID());
        appBean.setDate(String.valueOf(app.getDate()));
        appBean.setLocation(app.getLocation());

        userbean1.setEmail(String.valueOf(app.getUser1()));
        userbean2.setEmail(String.valueOf(app.getUser2()));
        appBean.setUser1(userbean1);
        appBean.setUser2(userbean2);

        return appBean;
    }
}
