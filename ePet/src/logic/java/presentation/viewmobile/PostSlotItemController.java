package presentation.viewmobile;

import beans.SlotAppuntamentoBean;
import controller.ManageSlotsController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import presentation.graphics.PostSlotItemGraphic;

import java.sql.SQLException;

public class PostSlotItemController extends PostSlotItemGraphic {


    @FXML
    private TextArea place;

    @FXML
    private Label post;

    @FXML
    private TextArea time;
    @FXML
    private Label impossibleRequest;



    public void setData(String date, String address, String p) {
        post.setText(p);
        place.setText(address);
        time.setText(date);

    }

    public void selectSlot(){
        impossibleRequest.setText(super.selectSlot(post.getText(),time.getText(),place.getText(),null));
    }
}
