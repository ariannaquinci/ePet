package presentation.view;

import beans.AppointmentRequestBean;
import controller.ManageAppointmentController;
import presentation.graphics.AppointmentRequestGraphic;
import service.SessionFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import java.sql.SQLException;

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



   public void acceptAppRequest(){

                super.acceptAppRequest(account.getText(),date.getText(),place.getText());
                item.setVisible(false);


    }

   public void denyAppRequest() {
             super.denyAppRequest(post.getText(),account.getText());
            item.setVisible(false);



    }

    public void setData(String d, String p, String acc,String id){
        date.setText(d);
        place.setText(p);
        account.setText(acc);
        post.setText(id);
    }

}
