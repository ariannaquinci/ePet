package Service.Factories;

import Beans.PostBean;
import Beans.ProfileBean;
import Entities.Post;
import Entities.Profile;
import Service.Entity;

import java.util.ArrayList;
import java.util.List;

public class ProfileFactory implements Entity {
    @Override
    public Profile createObject() {
        return new Profile();
    }
    public List<ProfileBean> extractProfileBeanList(List<Profile> src){
        List<ProfileBean> dest = new ArrayList<>();

        for(Profile i: src) {
            ProfileBean bean=new ProfileBean();
            bean.setName(i.getName());
            bean.setSecName(i.getSecondName());
            bean.setBirthday(i.getBirthday());
            bean.setUser(i.getUser());
            bean.setNickname(i.getNickname());
            dest.add(bean);
        }

        return dest;
}}
