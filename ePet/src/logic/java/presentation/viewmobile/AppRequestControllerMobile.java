package presentation.viewmobile;

import presentation.graphics.AppointmentRequestGraphic;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;


public class AppRequestControllerMobile extends AppointmentRequestGraphic {


    @FXML
    private TextArea place;

    @FXML
    private TextArea date;


    @FXML
    private Pane item;
    @FXML
    private TextArea account;
    @FXML
    private Label post;

    public void acceptAppRequest() {

            super.acceptAppRequest(account.getText(),date.getText(),place.getText(),item);
            item.setVisible(false);

    }

    public void denyAppRequest() {
        super.denyAppRequest(post.getText(),account.getText(),item);
            item.setVisible(false);

    }


    public void setData(String data, String posto, String acc,String id){
        date.setText(data);
        place.setText(posto);
        account.setText(acc);
        post.setText(id);
    }
}
