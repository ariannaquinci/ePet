package presentation.viewmobile;

import beans.PostBean;
import beans.SlotAppuntamentoBean;
import controller.ManagePostController;
import controller.ManageSlotsController;
import exceptions.NoResultFoundException;
import presentation.graphics.PostItemGraphic;
import service.SessionFacade;
import com.example.epet.MainMobile;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import utils.SlotItem;

import java.io.IOException;
import java.sql.SQLException;

public class PostItemController extends PostItemGraphic {

    @FXML
    private Label id;

    @FXML
    private TextField address;
    @FXML
    private TextField time;

    @FXML
    private TextArea description;

    @FXML
    private HBox resultsBox;

    @FXML
    private Label titleLabel;
    @FXML
    private Label noResults;
    @FXML
    private Pane item;

    public void addSlot() {
        noResults.setText(super.addSlot(id.getText(),address.getText(), time.getText()));
    }

    public String getID(){return id.getText();}

    public void showSlots() throws IOException{
               noResults.setText(super.showSlots(id.getText(),this));

    }



    public void setData( String title, String desc, String ident){
        id.setText(ident);
        titleLabel.setText(title);
        description.setText(desc);

    }
  public void deletePost(){

       if (super.deletePost(getID())){

      item.setVisible(false);}

    }

    public HBox getResultsBox() {
        return resultsBox;
    }
}
