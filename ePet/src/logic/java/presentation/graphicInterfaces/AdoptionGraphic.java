package presentation.graphicInterfaces;

import beans.PostBean;
import com.example.epet.Main;
import controller.ResearchController;
import exceptions.NoResultFoundException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import presentation.view.PetItemController;
import presentation.view.utilities.SelectPet;
import utils.PetItem;

import java.io.File;
import java.io.IOException;

public interface AdoptionGraphic {


    void setKind();


    void goHome() throws IOException;


    void initResults(ObservableList<PostBean> list) throws IOException;

    void search() throws IOException;
}
