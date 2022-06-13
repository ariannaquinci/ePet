package presentation.view;

import beans.FavoriteBean;
import beans.SlotAppuntamentoBean;
import controller.ManageFavoritesController;
import controller.ManageSlotsController;
import exceptions.NoResultFoundException;
import presentation.graphics.FavoriteItemGraphic;
import service.SessionFacade;
import com.example.epet.MainComputer;
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

public class FavItemController extends FavoriteItemGraphic {


    @FXML
    private Label creator;

    @FXML
    private TextArea description;

    @FXML
    private Label idPost;
    @FXML
    private Pane item;
    @FXML
    private Label titleLabel;
    @FXML
    private HBox resultsBox;
    @FXML
    private Label noSlots;

    public FavItemController(){
        super();
    }

    public HBox getResultsBox(){
        return this.resultsBox;
    }






    public void removeFromFavorites()  {

           if(super.removeFromFavorites(idPost.getText())){
               item.setVisible(false);
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
