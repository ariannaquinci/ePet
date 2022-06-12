package controller;

import beans.FavoriteBean;
import entities.Favorite;
import exceptions.NoResultFoundException;
import service.Entity;
import service.factories.FavoriteFactory;
import service.Factory;
import service.Types;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public class ManageFavoritesController {

    private static ManageFavoritesController instance=null;

    public static ManageFavoritesController getInstance(){
        if (instance==null){
            instance=new ManageFavoritesController();
        }
        return instance;
    }

    public void insertFavorite(FavoriteBean b) throws SQLException {
        Entity factoryFav = Factory.getInstance().getObject(Types.FAVORITE);
        Favorite fav = (Favorite) factoryFav.createObject();
        fav.setUser(b.getUser());
        fav.setPost(b.getPost());
        fav.insertFavorite();
    }
    public void removeFromFavorites(FavoriteBean bean){
        Entity factoryFav=Factory.getInstance().getObject(Types.FAVORITE);
        Favorite fav=(Favorite) factoryFav.createObject();
        fav.setPost(bean.getPost());
        fav.setUser(bean.getUser());
        try{
            fav.removeFromFavorites();
        }catch(SQLException e){throw new RuntimeException();}
    }
    public ObservableList<FavoriteBean> showFavorites(FavoriteBean bean) throws NoResultFoundException{
        Entity factoryFav = Factory.getInstance().getObject(Types.FAVORITE);
        Favorite fav = (Favorite) factoryFav.createObject();

        fav.setUser(bean.getUser());


        try {
            List<Favorite> l = fav.getFavorites();

            return entityToBean(l);


        } catch (SQLException e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }
    private ObservableList<FavoriteBean> entityToBean(List<Favorite> src){
        Entity factory= Factory.getInstance().getObject(Types.FAVORITE);
        ObservableList<FavoriteBean> dest= FXCollections.observableArrayList();
        for(FavoriteBean i: ((FavoriteFactory)factory).extractFavBeanList(src)){
            dest.add(i);
        }
        return dest;
    }
}
