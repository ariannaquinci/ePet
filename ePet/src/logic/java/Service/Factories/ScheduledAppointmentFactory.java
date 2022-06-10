package Service.Factories;

import Beans.PostBean;
import Beans.ScheduledAppointmentBean;
import Entities.Post;
import Entities.ScheduledAppointment;
import Service.Entity;

import java.util.ArrayList;
import java.util.List;

public class ScheduledAppointmentFactory implements Entity {
    @Override
    public ScheduledAppointment createObject() {
        return new ScheduledAppointment();
    }
    public List<ScheduledAppointmentBean> extractSchedAppBeanList(List<ScheduledAppointment> src){
        List<ScheduledAppointmentBean> dest = new ArrayList<>();

        for(ScheduledAppointment i: src) {
            ScheduledAppointmentBean schedAppBean=new ScheduledAppointmentBean();
            schedAppBean.setScheduledAppID(i.getScheduledAppID());
            schedAppBean.setUser1(i.getUser1());
            schedAppBean.setUser2(i.getUser2());
            schedAppBean.setLocation(i.getLocation());
            schedAppBean.setData(i.getData());
            dest.add(schedAppBean);
        }

        return dest;
    }

}
