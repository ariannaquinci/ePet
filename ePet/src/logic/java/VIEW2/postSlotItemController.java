package VIEW2;

import Beans.SlotAppuntamentoBean;
import CONTROLLER.ManageSlotsController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import java.sql.SQLException;

public class postSlotItemController {
    @FXML
    private Pane item;

    @FXML
    private TextArea place;

    @FXML
    private Label post;

    @FXML
    private TextArea time;

    @FXML
    protected void selectSlot(){
        SlotAppuntamentoBean bean= new SlotAppuntamentoBean();
        bean.setPost(post.getText());
        bean.setDate(time.getText());
        bean.setAddress(place.getText());
        try{
        ManageSlotsController.getInstance().Occupa_slot(bean);}
        catch(SQLException s){
            s.printStackTrace();
        }
    }



    public void setData(String date, String address, String p) {
        post.setText(p);
        place.setText(address);
        time.setText(date);

    }
}
