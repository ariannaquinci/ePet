package presentation.graphics;

import beans.SlotAppuntamentoBean;
import exceptions.NoResultFoundException;
import javafx.collections.ObservableList;

import java.io.IOException;

public interface PostItemGraphic {


    void addSlot();

    void showSlots() throws IOException;

    void initResults(ObservableList<SlotAppuntamentoBean> list) throws IOException, NoResultFoundException;


    void deletePost();
}
