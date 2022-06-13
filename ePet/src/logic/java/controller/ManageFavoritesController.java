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
        fav.setUser(b.getUserB());
        fav.setPost(b.getPostB());
        fav.insertFavorite();
    }
    public void removeFromFavorites(FavoriteBean bean) throws SQLException {
        Entity factoryFav=Factory.getInstance().getObject(Types.FAVORITE);
        Favorite fav=(Favorite) factoryFav.createObject();
        fav.setPost(bean.getPostB());
        fav.setUser(bean.getUserB());

            fav.removeFromFavorites();

    }
    public ObservableList<FavoriteBean> showFavorites(FavoriteBean bean) throws NoResultFoundException{
        Entity factoryFav = Factory.getInstance().getObject(Types.FAVORITE);
        Favorite fav = (Favorite) factoryFav.createObject();

        fav.setUser(bean.getUserB());


        try {
            List<Favorite> l = fav.getFavorites();

            return entityToBean(l);


        } catch (SQLException e) {
           throw new NoResultFoundException();

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
