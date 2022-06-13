package presentation.graphics;

import beans.AppointmentRequestBean;
import controller.ManageAppointmentController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import service.SessionFacade;

import java.sql.SQLException;

public class AppointmentRequestGraphic {

   protected void acceptAppRequest(String account, String date, String place){
       AppointmentRequestBean bean= new AppointmentRequestBean();
       bean.setApplicant(account);
       bean.setDate(date);
       bean.setReceiver(SessionFacade.getSession().getID());
       bean.setPlace(place);
       try{
           ManageAppointmentController.getInstance().acceptApp(bean);

       } catch (SQLException e) {
           e.getMessage();
       }
   }
    protected void denyAppRequest(String post, String account) {
        AppointmentRequestBean bean= new AppointmentRequestBean();
        bean.setPost(post);
        bean.setApplicant(account);
        try{
            ManageAppointmentController.getInstance().denyApp(bean);

        }catch(SQLException s){
            s.getMessage();
        }
    }

}
