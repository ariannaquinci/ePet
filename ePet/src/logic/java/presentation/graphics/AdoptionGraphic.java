package presentation.graphics;

import beans.PostBean;
import javafx.collections.ObservableList;

import java.io.IOException;

public interface AdoptionGraphic {


    void setKind();


    void goHome() throws IOException;


    void initResults(ObservableList<PostBean> list) throws IOException;

    void search() throws IOException;

}
