package presentation.graphicInterfaces;

import beans.SlotAppuntamentoBean;
import exceptions.NoResultFoundException;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public interface PostItemGraphic {


    void addSlot();

    void showSlots() throws IOException;

    void initResults(ObservableList<SlotAppuntamentoBean> list) throws IOException, NoResultFoundException;


    void deletePost();
}
