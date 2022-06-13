package controller;

import beans.PostBean;
import entities.Post;
import exceptions.NoResultFoundException;
import service.Entity;
import service.factories.PostFactory;
import service.Factory;
import service.Types;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public class ResearchController {
    private static ResearchController instance = null;


    public static ResearchController getInstance() {
        if(instance == null) {
            instance = new ResearchController();
        }

        return instance;
    }

    private ObservableList<PostBean> entityToBean(List<Post> src){
        Entity factory= Factory.getInstance().getObject(Types.POST);
        ObservableList<PostBean> dest= FXCollections.observableArrayList();
        for(PostBean i: ((PostFactory)factory).extractPostBeanList(src)){
            dest.add(i);
        }
        return dest;
    }
    public ObservableList<PostBean> research(PostBean bean) throws NoResultFoundException{

        Entity factoryPost = Factory.getInstance().getObject(Types.POST);
        Post post = (Post)factoryPost.createObject();

        post.setCity(bean.getCity());
        post.setCountry(bean.getCountry());
        post.setRegion(bean.getRegion());
        post.setKindOfPet(bean.getKindOfPet());


        try {
            List<Post> l= post.research();
            return entityToBean(l);

        } catch (SQLException ex) {
                    throw new NoResultFoundException();
        }





    }


}
