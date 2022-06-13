package presentation.view;

import beans.SlotAppuntamentoBean;
import controller.ManageSlotsController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import presentation.graphics.PostSlotItemGraphic;

import java.sql.SQLException;

public class PostSlotController extends PostSlotItemGraphic {
    @FXML
    private Pane item;
    @FXML
    private Label post;
    @FXML
    private TextArea place;
    @FXML
    private Label impossibleRequest;




    @FXML
    private TextArea time;




    public void selectSlot(){

            impossibleRequest.setText( super.selectSlot(post.getText(),time.getText(),place.getText(), item));




    }

    public void setData(String date, String address, String p) {
        post.setText(p);
        place.setText(address);
        time.setText(date);

    }
}
