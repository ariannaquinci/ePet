package presentation.viewmobile;

import beans.PostBean;
import exceptions.NoResultFoundException;
import com.example.epet.MainMobile;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import presentation.graphics.AdoptionGraphic;
import utils.PetItem;
import presentation.view.utilities.SelectPet;

import java.io.IOException;

public class ResearchController extends AdoptionGraphic {
    @FXML
    private CheckMenuItem bunny;

    @FXML
    private CheckMenuItem cat;

    @FXML
    private TextField city;

    @FXML
    private TextField country;

    @FXML
    private CheckMenuItem dog;

    @FXML
    private CheckMenuItem hamster;

    @FXML
    private MenuButton kind;

    @FXML
    private Label noResults;

    @FXML
    private CheckMenuItem other;

    @FXML
    private TextField region;

    @FXML
    private VBox resultsBox;

    @FXML
    private Button search;

    public void setKind(){
        SelectPet.setCheckedMenuItem(kind,dog,cat,bunny,hamster,other);
    }

    public VBox getResultsBox() {
        return this.resultsBox;
    }

    public void goHome() throws IOException {
        MainMobile m=new MainMobile();
        m.changeScene("fxml2/HomepageMobile.fxml");
    }

    public void goBack() throws IOException {
        MainMobile m=new MainMobile();
        m.changeScene("fxml2/menu.fxml");
    }






    public void search() throws IOException{
            noResults.setText(super.search(this, kind.getText(),country.getText(),city.getText(),region.getText()));

    }

    public void initResults(ObservableList<PostBean> list) throws IOException {

    }

}
