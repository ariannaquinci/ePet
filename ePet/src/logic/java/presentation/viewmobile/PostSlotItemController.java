package presentation.viewmobile;

import beans.SlotAppuntamentoBean;
import controller.ManageSlotsController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import presentation.graphicInterfaces.PostSlotItemGraphic;

import java.sql.SQLException;

public class PostSlotItemController implements PostSlotItemGraphic {
    @FXML
    private Pane item;

    @FXML
    private TextArea place;

    @FXML
    private Label post;

    @FXML
    private TextArea time;

    @Override
    public void selectSlot(){
        SlotAppuntamentoBean bean= new SlotAppuntamentoBean();
        bean.setPost(post.getText());
        bean.setDate(time.getText());
        bean.setAddress(place.getText());
        try{
                ManageSlotsController.getInstance().occupaSlot(bean);}
        catch(SQLException s){
            s.printStackTrace();
        }
    }



    @Override
    public void setData(String date, String address, String p) {
        post.setText(p);
        place.setText(address);
        time.setText(date);

    }
}
