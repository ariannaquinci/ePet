package presentation.view;

import beans.SlotAppuntamentoBean;
import controller.ManageSlotsController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import presentation.graphics.SlotItemGraphic;

import java.sql.SQLException;

public class SlotController extends SlotItemGraphic {

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


        public void delete() {
            super.delete(post.getText(), place.getText(),time.getText(),item);
        }
}
