package presentation.graphics;

import beans.SlotAppuntamentoBean;
import exceptions.NoResultFoundException;
import javafx.collections.ObservableList;

import java.io.IOException;

public interface PetItemGraphic {

    void addToFavorites();

    void showSlots() throws IOException;

    void initResults(ObservableList<SlotAppuntamentoBean> list) throws IOException, NoResultFoundException;

    void setData(String title, String desc, String cr, String id);
}
