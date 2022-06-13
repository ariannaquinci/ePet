package presentation.graphics;

import beans.SlotAppuntamentoBean;
import exceptions.NoResultFoundException;
import javafx.collections.ObservableList;

import java.io.IOException;

public interface FavoriteItemGraphic {

    void initResults(ObservableList<SlotAppuntamentoBean> list) throws IOException, NoResultFoundException;

    void showSlots() throws IOException;

    void removeFromFavorites();

    void setData(String title, String desc, String cr, String id);
}
