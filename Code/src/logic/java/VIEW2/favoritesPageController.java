package VIEW2;

import Beans.FavoriteBean;
import CONTROLLER.ManageFavoritesController;
import Exceptions.NoResultFoundException;
import Service.SessionFacade;
import com.example.epet.MainMobile;
import com.example.epet.favoriteItem;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class favoritesPageController {

    @FXML
    private VBox resultsBox;
    @FXML
    private Label noResults;

    @FXML
    protected void goBack() throws IOException {
        MainMobile m= new MainMobile();
        m.changeScene("fxml2/menu.fxml");

    }

    @FXML
    private void initResults(ObservableList<FavoriteBean> list) throws IOException, NoResultFoundException {

        resultsBox.getChildren().clear();

        for(FavoriteBean i: list) {
            MainMobile M= new MainMobile();
            favoriteItem p= M.getFavItem("fxml2/favoriteItem.fxml");
            VIEW2.FavoriteItemController favItemController=p.getControl2();
            Pane pane=p.getPane();

            favItemController.setData( i.getTitle(), i.getDescription(), i.getCreator(), i.getPost());
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane,new Insets(10,10,10,10));



        }

    }

    @FXML
    protected void showFavorites() throws IOException{
        FavoriteBean bean= new FavoriteBean();
        bean.setUser(SessionFacade.getSession().getID());
        try{
            initResults(ManageFavoritesController.getInstance().showFavorites(bean));
        }catch(NoResultFoundException n){

            noResults.setText(n.getMessage());
        }
    }

}
