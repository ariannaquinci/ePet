package viewmobile;

import beans.FavoriteBean;
import beans.SlotAppuntamentoBean;
import controller.ManageFavoritesController;
import controller.ManageSlotsController;
import exceptions.NoResultFoundException;
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

public class PetItemController {
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

    public String getTitle(){
        return titleLabel.getText();
    }


    @FXML
    protected void addToFavorites(){
        FavoriteBean bean= new FavoriteBean();
        bean.setUser(SessionFacade.getSession().getID());
        bean.setPost(idPost.getText());
        try{
            ManageFavoritesController.getInstance().insertFavorite(bean);}
        catch(SQLException s){
            s.printStackTrace();
        }

    }
    @FXML
    protected void showSlots() throws IOException {
        SlotAppuntamentoBean bean= new SlotAppuntamentoBean();
        bean.setPost(idPost.getText());
        try{
            noSlots.setText("");
            initResults(ManageSlotsController.getInstance().showSlots(bean));


        }catch(NoResultFoundException n){
            noSlots.setText(n.getMessage());
        }

    }



    private void initResults(ObservableList<SlotAppuntamentoBean> list) throws IOException, NoResultFoundException {

        resultsBox.getChildren().clear();

        for(SlotAppuntamentoBean i: list) {
            MainMobile m= new MainMobile();
            PostSlotItem p= m.getPostSlotItem("fxml2/postSlotItem.fxml");
            PostSlotItemController slotControl=p.getController2();
            Pane pane=p.getPane();

            slotControl.setData( i.getDate(), i.getAddress(), i.getPost());
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane,new Insets(10,10,10,10));



        }

    }



    public void setData(String title, String desc, String cr, String id){


        titleLabel.setText(title);
        description.setText(desc);
        creator.setText(cr);

        idPost.setText(id);




    }
}
