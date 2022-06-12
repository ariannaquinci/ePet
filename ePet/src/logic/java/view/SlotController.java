package view;

import beans.SlotAppuntamentoBean;
import controller.ManageSlotsController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class SlotController {

        @FXML
        private Pane item;
        @FXML
        private Label post;

        @FXML
        private TextArea place;

  @FXML
        private TextArea time;


        public void setData(String date, String address, String p){

            post.setText(p);
                place.setText(address);
                time.setText(date);
        }

        public void delete(ActionEvent event) {
           SlotAppuntamentoBean bean = new SlotAppuntamentoBean();
            bean.setPost(post.getText());
            bean.setAddress(place.getText());
            bean.setDate(time.getText());

            ManageSlotsController.getInstance().deleteSlot(bean);
            item.setVisible(false);
        }
}
