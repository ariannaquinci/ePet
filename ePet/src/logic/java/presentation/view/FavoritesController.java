package presentation.view;

import beans.FavoriteBean;
import presentation.graphicInterfaces.FavoritesPageGraphic;
import utils.FavoriteItem;
import controller.ManageFavoritesController;
import exceptions.NoResultFoundException;
import service.SessionFacade;
import com.example.epet.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class FavoritesController implements FavoritesPageGraphic {

    @FXML
    private Label noResults;
    @FXML
    private VBox resultsBox;


    @Override

    public void initResults(ObservableList<FavoriteBean> list) throws IOException, NoResultFoundException {

        resultsBox.getChildren().clear();

        for(FavoriteBean i: list) {
            Main m= new Main();
            FavoriteItem p= m.getFavItem("fxml1/FavoriteItem.fxml");
            FavoriteItemController favItemController=p.getController();
            Pane pane=p.getPane();

            favItemController.setData( i.getTitleB(), i.getDescriptionB(), i.getCreatorB(), i.getPostB());
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane,new Insets(10,10,10,10));



        }

    }


    @Override
    public void goBack() throws IOException {
        Main m=new Main();
        m.changeScene("fxml1/homepage.fxml");
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
