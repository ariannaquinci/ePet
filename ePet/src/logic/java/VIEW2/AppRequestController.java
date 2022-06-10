package VIEW2;


import Beans.AppointmentRequestBean;
import CONTROLLER.ManageAppointmentController;
import Service.SessionFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import java.sql.SQLException;

public class AppRequestController {
    @FXML
    private TextArea Date;

    @FXML
    private TextArea Place;

    @FXML
    private TextArea account;

    @FXML
    private Pane item;
    @FXML
    private Label post;

    @FXML
    protected void acceptAppRequest() {
        AppointmentRequestBean bean = new AppointmentRequestBean();
        bean.setApplicant(account.getText());
        bean.setDate(Date.getText());
        bean.setReceiver(SessionFacade.getSession().getID());
        bean.setPlace(Place.getText());
        try {
            ManageAppointmentController.getInstance().acceptApp(bean);
            item.setVisible(false);
        } catch (SQLException e) {

            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
         @FXML
    private void denyAppRequest() {
        AppointmentRequestBean bean= new AppointmentRequestBean();
        bean.setPost(post.getText());
        bean.setApplicant(account.getText());
        try{
            ManageAppointmentController.getInstance().denyApp(bean);
            item.setVisible(false);
        }catch(SQLException s){
            s.getMessage();
        }
    }

    public void setData(String date, String place, String acc,String id){
        Date.setText(date);
        Place.setText(place);
        account.setText(acc);
        post.setText(id);
    }
}
