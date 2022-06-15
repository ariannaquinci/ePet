package presentation.viewmobile;

import beans.FavoriteBean;
import beans.SlotAppuntamentoBean;
import controller.ManageFavoritesController;
import controller.ManageSlotsController;
import exceptions.NoResultFoundException;
import presentation.graphics.PetItemGraphic;
import service.SessionFacade;
import com.example.epet.MainMobile;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import utils.PostSlotItem;

import java.io.IOException;
import java.sql.SQLException;

public class PetItemController extends PetItemGraphic {
    @FXML
    private Label creator;
    @FXML
    private Label idPost;

    @FXML
    private TextArea description;

    @FXML
    private Label titleLabel;
    @FXML
    private HBox resultsBox;
    @FXML
    private Label noSlots;

    public HBox getResultsBox(){
        return this.resultsBox;
    }
    public String getTitle(){
        return titleLabel.getText();
    }



   public void addToFavorites(){
        FavoriteBean bean= new FavoriteBean();
        bean.setUserB(SessionFacade.getSession().getID());
        bean.setPostB(idPost.getText());
        try{
            ManageFavoritesController.getInstance().insertFavorite(bean);}
        catch(SQLException s){
            s.printStackTrace();
        }

    }


    public void showSlots() throws IOException {
        noSlots.setText(super.showSlots(idPost.getText(),this));
    }




    public void setData(String title, String desc, String cr, String id){


        titleLabel.setText(title);
        description.setText(desc);
        creator.setText(cr);

        idPost.setText(id);




    }
}
