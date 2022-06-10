package Service.Factories;

import Beans.AppointmentRequestBean;
import Beans.FavoriteBean;
import Entities.AppointmentRequest;
import Entities.Favorite;
import Service.Entity;

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
            appReqBean.setDate(i.getDate().toString());
            appReqBean.setPlace(i.getLocation());

            dest.add(appReqBean);
        }

        return dest;
    }
}
