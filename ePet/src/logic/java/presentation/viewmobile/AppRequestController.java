package presentation.viewmobile;


import beans.AppointmentRequestBean;
import controller.ManageAppointmentController;
import presentation.graphicInterfaces.AppointmentRequestGraphic;
import service.SessionFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import java.sql.SQLException;

public class AppRequestController implements AppointmentRequestGraphic {
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

    @Override
    public void acceptAppRequest() {
        AppointmentRequestBean bean = new AppointmentRequestBean();
        bean.setApplicant(account.getText());
        bean.setDate(date.getText());
        bean.setReceiver(SessionFacade.getSession().getID());
        bean.setPlace(place.getText());
        try {
            ManageAppointmentController.getInstance().acceptApp(bean);
            item.setVisible(false);
        } catch (SQLException e) {
            e.getMessage();
        }
    }
        @Override
        public void denyAppRequest() {
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

    @Override
    public void setData(String data, String posto, String acc,String id){
        date.setText(data);
        place.setText(posto);
        account.setText(acc);
        post.setText(id);
    }
}
