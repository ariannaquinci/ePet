package service.factories;

import beans.FavoriteBean;
import entities.Favorite;
import service.Entity;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFactory implements Entity {
    @Override
    public Favorite createObject() {
        return new Favorite();

    }

    public List<FavoriteBean> extractFavBeanList(List<Favorite> src){
        List<FavoriteBean> dest = new ArrayList<>();

        for(Favorite i: src) {
            FavoriteBean favoriteBean = new FavoriteBean();
            favoriteBean.setPostB(i.getPost());
            favoriteBean.setCreatorB(i.getCreator());
            favoriteBean.setDescriptionB(i.getDescription());
            favoriteBean.setTitleB(i.getTitle());

            dest.add(favoriteBean);
        }

        return dest;
    }
}
