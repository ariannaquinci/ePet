package presentation.graphics;

import beans.FavoriteBean;
import com.example.epet.MainComputer;
import com.example.epet.MainMobile;
import controller.ManageFavoritesController;
import exceptions.NoResultFoundException;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import presentation.view.FavItemController;
import presentation.view.FavoritesController;
import presentation.viewmobile.FavoritesPageController;
import service.SessionFacade;
import utils.FavoriteItem;

import java.io.IOException;

public class FavoritesPageGraphic {

    protected final String showFavorites(FavoritesPageGraphic f) throws IOException{
        String noResults="";
        FavoriteBean bean= new FavoriteBean();
        bean.setUserB(SessionFacade.getSession().getID());
        try{
            initResults(ManageFavoritesController.getInstance().showFavorites(bean),f);
        }catch(NoResultFoundException n){

            noResults=n.getMessage();
        }
        return noResults;
    }

    private void initResults(ObservableList<FavoriteBean> list, FavoritesPageGraphic f) throws IOException, NoResultFoundException {
       if(f.getClass()==FavoritesController.class) {
           VBox resultsBox = ((FavoritesController) f).getResultsBox();
           resultsBox.getChildren().clear();

           for (FavoriteBean i : list) {
               MainComputer m = new MainComputer();
               FavoriteItem p = m.getFavItem("fxml1/FavoriteItem.fxml");
               FavItemController favItemController = p.getController();
               Pane pane = p.getPane();

               favItemController.setData(i.getTitleB(), i.getDescriptionB(), i.getCreatorB(), i.getPostB());
               resultsBox.getChildren().add(pane);
               resultsBox.setMargin(pane, new Insets(10, 10, 10, 10));

           }
       }
       else if(f.getClass()== FavoritesPageController.class){
           VBox resultsBox=((FavoritesPageController)f).getResultsBox();
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
    }
    }
