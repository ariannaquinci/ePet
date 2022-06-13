package presentation.graphics;

import beans.FavoriteBean;
import beans.SlotAppuntamentoBean;
import com.example.epet.MainComputer;
import com.example.epet.MainMobile;
import controller.ManageFavoritesController;
import controller.ManageSlotsController;
import exceptions.NoResultFoundException;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import presentation.view.FavItemController;
import presentation.view.PostSlotController;
import service.SessionFacade;
import utils.PostSlotItem;

import java.io.IOException;
import java.sql.SQLException;

public class FavoriteItemGraphic {
    protected FavoriteItemGraphic(){}



    protected void initResults(ObservableList<SlotAppuntamentoBean> list, FavoriteItemGraphic f) throws IOException, NoResultFoundException{
            if(f.getClass()== FavItemController.class){

                HBox resultsBox=((FavItemController) f).getResultsBox();
                resultsBox.getChildren().clear();

                for(SlotAppuntamentoBean i: list) {
                    MainComputer m= new MainComputer();
                    PostSlotItem p= m.getPostSlotItem("fxml1/postSlotItem.fxml");
                    PostSlotController slotControl=p.getController();
                    Pane pane=p.getPane();

                    slotControl.setData( i.getDate(), i.getAddress(), i.getPost());
                    resultsBox.getChildren().add(pane);
                    resultsBox.setMargin(pane,new Insets(10,10,10,10));



                }
                }


            else if(f.getClass()== presentation.viewmobile.FavoriteItemController.class){

                HBox resultsBox=((presentation.viewmobile.FavoriteItemController) f).getResultsBox();
                resultsBox.getChildren().clear();

                for(SlotAppuntamentoBean i: list) {
                    MainMobile m= new MainMobile();
                    PostSlotItem p= m.getPostSlotItem("fxml2/postSlotItem.fxml");
                    presentation.viewmobile.PostSlotItemController slotControl=p.getController2();
                    Pane pane=p.getPane();

                    slotControl.setData( i.getDate(), i.getAddress(), i.getPost());
                    resultsBox.getChildren().add(pane);
                    resultsBox.setMargin(pane,new Insets(10,10,10,10));



                }
            }

    }

    protected String showSlots(String idPost,FavoriteItemGraphic f) throws IOException{
        String noSlots="";
        SlotAppuntamentoBean bean= new SlotAppuntamentoBean();
        bean.setPost(idPost);
        try{
            noSlots="";
            initResults(ManageSlotsController.getInstance().showSlots(bean),f);


        }catch(NoResultFoundException n){
            noSlots=n.getMessage();
        }
        return noSlots;
    }

    protected boolean removeFromFavorites(String idPost){
        Boolean retvalue=false;
        FavoriteBean bean = new FavoriteBean();
        bean.setPostB(idPost);
        bean.setUserB(SessionFacade.getSession().getID());
        try {
            ManageFavoritesController.getInstance().removeFromFavorites(bean);
            retvalue=true;
        }catch(SQLException s){
            s.getMessage();

        }
        return retvalue;
    }


}
