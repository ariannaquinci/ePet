package presentation.graphics;

import beans.FavoriteBean;
import exceptions.NoResultFoundException;
import javafx.collections.ObservableList;

import java.io.IOException;

public interface FavoritesPageGraphic {

    void initResults(ObservableList<FavoriteBean> list) throws IOException, NoResultFoundException;

    void goBack() throws IOException;

    void showFavorites() throws IOException;
}
