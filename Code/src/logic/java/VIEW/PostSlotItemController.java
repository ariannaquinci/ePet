package VIEW;

import Beans.SlotAppuntamentoBean;
import CONTROLLER.ManageAppointmentController;
import CONTROLLER.ManageSlotsController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import java.sql.SQLException;

public class PostSlotItemController {
    @FXML
    private Pane item;
    @FXML
    private Label post;

    @FXML
    private TextArea place;

    @FXML
    private TextArea time;
    @FXML
    protected void selectSlot(){
        SlotAppuntamentoBean bean= new SlotAppuntamentoBean();
        bean.setPost(post.getText());
        bean.setDate(time.getText());
        bean.setAddress(place.getText());
        try{
             ManageSlotsController.getInstance().Occupa_slot(bean);

            item.setVisible(false);
        }catch(SQLException s){
            s.getMessage();
        }

    }

    public void setData(String date, String address, String p) {
        post.setText(p);
        place.setText(address);
        time.setText(date);

    }
}
