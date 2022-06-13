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

public class ManagePostController {
    private static ManagePostController instance=null;

    public static ManagePostController getInstance(){
        if (instance==null){
            instance=new ManagePostController();
        }
        return instance;
    }
    public void writePost(PostBean p) throws SQLException{
        Entity factoryPost= Factory.getInstance().getObject(Types.POST);
        Post post= (Post)factoryPost.createObject();
        post.setTitle(p.getTitle());
        post.setCountry(p.getCountry());
        post.setRegion(p.getRegion());
        post.setCity(p.getCity());
        post.setKindOfPet(p.getKindOfPet());
        post.setCreator(p.getCreator());
        post.setPic(p.getPic());
        post.setDescription(p.getDescription());
        try{

                post.writePost();




            } catch (SQLException e) {
                e.getMessage();
            }
        }

    private ObservableList<PostBean> entityToBean(List<Post> src){
        Entity factory= Factory.getInstance().getObject(Types.POST);
        ObservableList<PostBean> dest= FXCollections.observableArrayList();
        for(PostBean i: ((PostFactory)factory).extractPostBeanList(src)){
            dest.add(i);
        }
        return dest;
    }


    public ObservableList<PostBean> getPosts(PostBean bean) throws NoResultFoundException{
        Entity factoryPost = Factory.getInstance().getObject(Types.POST);
        Post post = (Post)factoryPost.createObject();

        post.setCreator(bean.getCreator());


        try {
            List<Post> l = post.getMyPosts();
            return entityToBean(l);

        }catch (SQLException e) {
            throw new NoResultFoundException();
        }

    }




    public void deletePost(PostBean bean) throws SQLException{
        Entity factoryPost=Factory.getInstance().getObject(Types.POST);
        Post post=(Post) factoryPost.createObject();
        post.setIdPost(bean.getId());

            post.deletePost();

    }


}
