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
import presentation.view.PetItemController;
import presentation.view.PostSlotController;
import service.SessionFacade;
import utils.PostSlotItem;

import java.io.IOException;
import java.sql.SQLException;

public class PetItemGraphic {
    protected final void addToFavorites(String idPost){
        FavoriteBean bean= new FavoriteBean();
        bean.setUserB(SessionFacade.getSession().getID());
        bean.setPostB(idPost);
        try{
            ManageFavoritesController.getInstance().insertFavorite(bean);}
        catch(SQLException s){
            s.printStackTrace();
        }

    }
    protected final String  showSlots(String idPost, PetItemGraphic p) throws IOException{
        SlotAppuntamentoBean bean= new SlotAppuntamentoBean();
        String noSlots="";
        bean.setPost(idPost);
        try{
            initResults(ManageSlotsController.getInstance().showSlots(bean),p );


        }catch(NoResultFoundException n){
            noSlots=n.getMessage();
        }
        return noSlots;

    }

    private void initResults(ObservableList<SlotAppuntamentoBean> list,PetItemGraphic pet) throws IOException, NoResultFoundException {

        if(pet.getClass()== PetItemController.class){
            HBox resultsBox= ((PetItemController)pet).getResultsBox();
            resultsBox.getChildren().clear();



        for(SlotAppuntamentoBean i: list) {
            MainComputer m= new MainComputer();
            PostSlotItem p= m.getPostSlotItem("fxml1/postSlotItem.fxml");
            PostSlotController slotControl=p.getController();
            Pane pane=p.getPane();

            slotControl.setData( i.getDate(), i.getAddress(), i.getPost());
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane,new Insets(10,10,10,10));



        }}
        else if(pet.getClass()== presentation.viewmobile.PetItemController.class){
            HBox resultsBox=((presentation.viewmobile.PetItemController)pet).getResultsBox();
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


}
