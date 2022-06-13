package presentation.view;

import beans.AppointmentRequestBean;
import controller.ManageAppointmentController;
import service.SessionFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import java.sql.SQLException;

public class AppRequestController {
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

    @FXML
    protected void acceptAppRequest(){
            AppointmentRequestBean bean= new AppointmentRequestBean();
            bean.setApplicant(account.getText());
            bean.setDate(date.getText());
            bean.setReceiver(SessionFacade.getSession().getID());
            bean.setPlace(place.getText());
            try{
                ManageAppointmentController.getInstance().acceptApp(bean);
                item.setVisible(false);
            } catch (SQLException e) {
                    e.getMessage();
            }

    }
    @FXML
    protected void denyAppRequest() {
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

    public void setData(String d, String p, String acc,String id){
        date.setText(d);
        place.setText(p);
        account.setText(acc);
        post.setText(id);
    }

}
