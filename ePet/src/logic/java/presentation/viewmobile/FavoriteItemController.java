package presentation.viewmobile;

import presentation.graphics.FavoriteItemGraphic;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class FavoriteItemController extends FavoriteItemGraphic {
    @FXML
    private Label creator;

    @FXML
    private TextArea description;

    @FXML
    private Label idPost;

    @FXML
    private Pane item;

    @FXML
    private Label noSlots;

    @FXML
    private HBox resultsBox;

    @FXML
    private Label titleLabel;


    public HBox getResultsBox(){
        return this.resultsBox;
    }


   public void showSlots() throws IOException{
       noSlots.setText(super.showSlots(idPost.getText(),this));
    }


    public void removeFromFavorites() {

        if(super.removeFromFavorites(idPost.getText())){
            item.setVisible(false);
        }

    }


    public void setData(String title, String desc, String cr, String id){

        titleLabel.setText(title);
        description.setText(desc);
        creator.setText(cr);

        idPost.setText(id);




    }
}
