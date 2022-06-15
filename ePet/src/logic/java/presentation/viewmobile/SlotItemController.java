package presentation.viewmobile;

import beans.SlotAppuntamentoBean;
import controller.ManageSlotsController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import presentation.graphics.SlotItemGraphic;

import java.sql.SQLException;

public class SlotItemController extends SlotItemGraphic {
    @FXML
    private Pane item;

    @FXML
    private TextArea place;

    @FXML
    private Label post;

    @FXML
    private TextArea time;

    public void delete(){
        super.delete(post.getText(), place.getText(),time.getText(),item);
    }
    public void setData(String date, String address, String p){

        post.setText(p);
        place.setText(address);
        time.setText(date);
    }
}
