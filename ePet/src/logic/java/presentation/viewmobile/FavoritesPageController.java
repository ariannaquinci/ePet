package presentation.viewmobile;

import beans.FavoriteBean;
import presentation.graphicInterfaces.FavoritesPageGraphic;
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

public class FavoritesPageController implements FavoritesPageGraphic {

    @FXML
    private VBox resultsBox;
    @FXML
    private Label noResults;

    @Override
    public void goBack() throws IOException {
        MainMobile m= new MainMobile();
        m.changeScene("fxml2/menu.fxml");

    }

    @Override
    public void initResults(ObservableList<FavoriteBean> list) throws IOException, NoResultFoundException {

        resultsBox.getChildren().clear();

        for(FavoriteBean i: list) {
            MainMobile m= new MainMobile();
            FavoriteItem p= m.getFavItem("fxml2/FavoriteItem.fxml");
            presentation.viewmobile.FavoriteItemController favItemController=p.getControl2();
            Pane pane=p.getPane();

            favItemController.setData( i.getTitleB(), i.getDescriptionB(), i.getCreatorB(), i.getPostB());
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane,new Insets(10,10,10,10));



        }

    }

    @Override
    public void showFavorites() throws IOException{
        FavoriteBean bean= new FavoriteBean();
        bean.setUserB(SessionFacade.getSession().getID());
        try{
            initResults(ManageFavoritesController.getInstance().showFavorites(bean));
        }catch(NoResultFoundException n){

            noResults.setText(n.getMessage());
        }
    }

}
