package presentation.view;

import beans.PostBean;
import com.example.epet.MainComputer;
import controller.ResearchController;
import exceptions.NoResultFoundException;
import com.example.epet.Main;
import presentation.graphics.AdoptionGraphic;
import utils.PetItem;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import presentation.view.utilities.SelectPet;

import java.io.IOException;

public class AdoptionController  extends AdoptionGraphic{
    @FXML
    private MenuButton kind;

    @FXML
    private CheckMenuItem dog;
    @FXML
    private CheckMenuItem cat;
    @FXML
    private CheckMenuItem bunny;
    @FXML
    private CheckMenuItem hamster;
    @FXML
    private CheckMenuItem other;

    @FXML
    private TextField country;
    @FXML
    private TextField city;
    @FXML
    private TextField region;
    @FXML
    private Label noResults;
    @FXML
    private VBox resultsBox;

    public void setKind(){
        SelectPet.setCheckedMenuItem(kind,dog,cat,bunny,hamster,other);
    }


    public void goHome() throws IOException {
        MainComputer m=new MainComputer();
        m.changeScene("fxml1/homepage.fxml");
    }






    public void search() throws IOException{
        noResults.setText(super.search(this, kind.getText(),country.getText(),city.getText(),region.getText()));


    }


    public VBox getResultsBox() {
        return this.resultsBox;
    }
}
