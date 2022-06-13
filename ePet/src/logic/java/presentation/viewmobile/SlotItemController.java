package presentation.viewmobile;

import beans.SlotAppuntamentoBean;
import controller.ManageSlotsController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import presentation.graphicInterfaces.SlotItemGraphic;

import java.sql.SQLException;

public class SlotItemController implements SlotItemGraphic {
    @FXML
    private Pane item;

    @FXML
    private TextArea place;

    @FXML
    private Label post;

    @FXML
    private TextArea time;

    @Override
    public void delete() {
        SlotAppuntamentoBean bean = new SlotAppuntamentoBean();
        bean.setPost(post.getText());
        bean.setAddress(place.getText());
        bean.setDate(time.getText());

        try {
            ManageSlotsController.getInstance().deleteSlot(bean);
        }catch(SQLException s){s.getMessage();}
        item.setVisible(false);
    }
    @Override
    public void setData(String date, String address, String p){

        post.setText(p);
        place.setText(address);
        time.setText(date);
    }
}
