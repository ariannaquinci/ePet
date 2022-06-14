package presentation.viewmobile;

import beans.FavoriteBean;
import presentation.graphics.FavoritesPageGraphic;
import utils.FavoriteItem;
import controller.ManageFavoritesController;
import exceptions.NoResultFoundException;
import service.SessionFacade;
import com.example.epet.MainMobile;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class FavoritesPageController extends FavoritesPageGraphic {

    @FXML
    private VBox resultsBox;
    @FXML
    private Label noResults;

    public VBox getResultsBox(){return this.resultsBox;}
    public void goBack() throws IOException {
        MainMobile m= new MainMobile();
        m.changeScene("fxml2/menu.fxml");

    }


    public void showFavorites() throws IOException{

            noResults.setText(super.showFavorites(this));

    }

}
