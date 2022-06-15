package service.factories;

import beans.AppointmentRequestBean;
import entities.AppointmentRequest;
import service.Entity;

import java.util.ArrayList;
import java.util.List;

public class AppointmentRequestFactory implements Entity {
    @Override
    public AppointmentRequest createObject() {
        return new AppointmentRequest();
    }
    public List<AppointmentRequestBean> extractAppReqBeanList(List<AppointmentRequest> src){
        List<AppointmentRequestBean> dest = new ArrayList<>();

        for(AppointmentRequest i: src) {
            AppointmentRequestBean appReqBean = new AppointmentRequestBean();
            appReqBean.setPost(i.getPost());
            appReqBean.setApplicant(i.getApplicant());
            appReqBean.setDate(i.getDate());
            appReqBean.setPlace(i.getLocation());

            dest.add(appReqBean);
        }

        return dest;
    }
}
