package view;

import beans.FavoriteBean;
import beans.SlotAppuntamentoBean;
import controller.ManageFavoritesController;
import controller.ManageSlotsController;
import exceptions.NoResultFoundException;
import service.SessionFacade;
import com.example.epet.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import utils.PostSlotItem;

import java.io.IOException;

public class FavoriteItemController {


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

    private void initResults(ObservableList<SlotAppuntamentoBean> list) throws IOException, NoResultFoundException {

        resultsBox.getChildren().clear();

        for(SlotAppuntamentoBean i: list) {
            Main m= new Main();
            PostSlotItem p= m.getPostSlotItem("fxml1/postSlotItem.fxml");
            PostSlotItemController slotControl=p.getController();
            Pane pane=p.getPane();

            slotControl.setData( i.getDate(), i.getAddress(), i.getPost());
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane,new Insets(10,10,10,10));



        }

    }
    @FXML
    protected void showSlots() throws IOException{
    SlotAppuntamentoBean bean= new SlotAppuntamentoBean();
        bean.setPost(idPost.getText());
        try{
            noSlots.setText("");
        initResults(ManageSlotsController.getInstance().showSlots(bean));


    }catch(NoResultFoundException n){
        noSlots.setText(n.getMessage());
    }
    }

    public void removeFromFavorites() {

            FavoriteBean bean = new FavoriteBean();
            bean.setPost(idPost.getText());
            bean.setUser(SessionFacade.getSession().getID());

            ManageFavoritesController.getInstance().removeFromFavorites(bean);
            item.setVisible(false);

        }

    public void setData(String title, String desc, String cr, String id){

        titleLabel.setText(title);
        description.setText(desc);
        creator.setText(cr);

        idPost.setText(id);




    }
}
