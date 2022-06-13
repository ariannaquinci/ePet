package presentation.view;

import beans.SlotAppuntamentoBean;
import controller.ManageSlotsController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import presentation.graphics.SlotItemGraphic;

import java.sql.SQLException;

public class SlotController implements SlotItemGraphic {

        @FXML
        private Pane item;
        @FXML
        private Label post;

        @FXML
        private TextArea place;

  @FXML
        private TextArea time;


  @Override
        public void setData(String date, String address, String p){

            post.setText(p);
                place.setText(address);
                time.setText(date);
        }

        @Override
        public void delete() {
           SlotAppuntamentoBean bean = new SlotAppuntamentoBean();
            bean.setPost(post.getText());
            bean.setAddress(place.getText());
            bean.setDate(time.getText());
        try{
            ManageSlotsController.getInstance().deleteSlot(bean);}catch(SQLException s){
            s.getMessage();
        }
            item.setVisible(false);
        }
}
