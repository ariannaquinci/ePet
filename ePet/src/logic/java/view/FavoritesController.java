package view;

import beans.FavoriteBean;
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

public class FavoritesController {

    @FXML
    private Label noResults;
    @FXML
    private VBox resultsBox;



    private void initResults(ObservableList<FavoriteBean> list) throws IOException, NoResultFoundException {

        resultsBox.getChildren().clear();

        for(FavoriteBean i: list) {
            Main M= new Main();
            FavoriteItem p= M.getFavItem("fxml1/FavoriteItem.fxml");
            FavoriteItemController favItemController=p.getController();
            Pane pane=p.getPane();

            favItemController.setData( i.getTitle(), i.getDescription(), i.getCreator(), i.getPost());
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane,new Insets(10,10,10,10));



        }

    }


    @FXML
    protected void goBack() throws IOException {
        Main M=new Main();
        M.changeScene("fxml1/homepage.fxml");
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
