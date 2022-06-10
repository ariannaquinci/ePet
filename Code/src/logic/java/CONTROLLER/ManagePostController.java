package CONTROLLER;

import Beans.FavoriteBean;
import Beans.PostBean;
import Entities.Post;
import Exceptions.NoResultFoundException;
import Service.Entity;
import Service.Factories.PostFactory;
import Service.Factory;
import Service.Types;
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

        if(post.getPic()==null){


                post.writePost();



        }
        else{
            try{
                post.writePost();
                post.insert_pic();
            } catch (SQLException e) {
                e.getMessage();
            }
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



    public void editDescription(){
        Entity factoryPost=Factory.getInstance().getObject(Types.POST);
        Post post=(Post) factoryPost.createObject();
        try{post.editDescription(post.getDescription());}catch(SQLException e){throw new RuntimeException();}
    }
    public void editPosition(PostBean b){
        Entity factoryPost=Factory.getInstance().getObject(Types.POST);
        Post post=(Post)factoryPost.createObject();
        if(b.getCity()!=""){
             post.setCity(b.getCity());}
        if(b.getCountry()!=""){
            post.setCity(b.getCountry());}
        if(b.getRegion()!=""){
            post.setRegion(b.getRegion());
        }
        try{
            post.editPosition(post.getCountry(),post.getCity(),post.getRegion());
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deletePost(PostBean bean){
        Entity factoryPost=Factory.getInstance().getObject(Types.POST);
        Post post=(Post) factoryPost.createObject();
        post.setIdPost(bean.getID());
        try{
            post.deletePost();
        }catch(SQLException e){throw new RuntimeException();}
    }


}
