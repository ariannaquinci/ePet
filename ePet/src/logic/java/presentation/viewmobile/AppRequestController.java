package presentation.viewmobile;

import presentation.graphics.AppointmentRequestGraphic;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;


public class AppRequestController extends AppointmentRequestGraphic {
    @FXML
    private TextArea date;

    @FXML
    private TextArea place;

    @FXML
    private TextArea account;

    @FXML
    private Pane item;
    @FXML
    private Label post;

    public void acceptAppRequest() {

            super.acceptAppRequest(account.getText(),place.getText(),date.getText());
            item.setVisible(false);

    }

        public void denyAppRequest() {
        super.denyAppRequest(post.getText(),account.getText());
            item.setVisible(false);

    }


    public void setData(String data, String posto, String acc,String id){
        date.setText(data);
        place.setText(posto);
        account.setText(acc);
        post.setText(id);
    }
}
