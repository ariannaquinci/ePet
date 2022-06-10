package CONTROLLER;

import Beans.ProfileBean;
import Entities.Profile;
import Exceptions.NoResultFoundException;
import Service.Entity;
import Service.Factories.ProfileFactory;
import Service.Factory;
import Service.SessionFacade;
import Service.Types;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public class ManageProfileController {
    private static ManageProfileController instance=null;
    public static ManageProfileController getInstance(){
        if(instance==null){ instance=new ManageProfileController();}
        return instance;
    }

    public void CreateProfile(ProfileBean bean) throws SQLException {

        Entity factoryProf = Factory.getInstance().getObject(Types.PROFILE);
        Profile prof = (Profile) factoryProf.createObject();
        prof.setName(bean.getName());
        prof.setSecName(bean.getSecName());
        prof.setBirthday(bean.getBirthday());
        prof.setUser(bean.getUser());
        prof.setNickname(bean.getNickname());
        prof.setTelephone(bean.getTelephone());

        prof.createProfile();



    }

    public ObservableList<ProfileBean> showProfileInfo(ProfileBean bean) throws NoResultFoundException{
        Entity profileFactory= Factory.getInstance().getObject(Types.PROFILE);
        Profile prof = (Profile)profileFactory.createObject();

        prof.setUser(bean.getUser());


        try {
            List<Profile> p = prof.getProfile();
            return entityToBean(p);

        }catch (SQLException e) {
            throw new NoResultFoundException();
        }
    }

    public void deleteProfile(ProfileBean bean) throws SQLException{
        Entity profileFactory= Factory.getInstance().getObject(Types.PROFILE);
        Profile prof = (Profile)profileFactory.createObject();

        prof.setUser(bean.getUser());
        try{
            prof.deleteProfile();

        }catch(SQLException s){
            s.getMessage();

        }
    }
    private ObservableList<ProfileBean> entityToBean(List<Profile> src){
        Entity factory= Factory.getInstance().getObject(Types.PROFILE);
        ObservableList<ProfileBean> dest= FXCollections.observableArrayList();
        for(ProfileBean i: ((ProfileFactory)factory).extractProfileBeanList(src)){
            dest.add(i);
        }
        return dest;
    }


}
