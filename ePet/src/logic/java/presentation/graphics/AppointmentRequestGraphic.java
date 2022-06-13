package presentation.graphics;

import beans.AppointmentRequestBean;
import controller.ManageAppointmentController;

import javafx.scene.layout.Pane;
import service.SessionFacade;

import java.sql.SQLException;

public class AppointmentRequestGraphic {

   protected void acceptAppRequest(String account, String date, String place, Pane item){
       AppointmentRequestBean bean= new AppointmentRequestBean();
       bean.setApplicant(account);
       bean.setDate(date);
       bean.setReceiver(SessionFacade.getSession().getID());
       bean.setPlace(place);
       try{
           ManageAppointmentController.getInstance().acceptApp(bean);
           item.setVisible(false);

       } catch (SQLException e) {
           e.getMessage();
       }
   }
    protected void denyAppRequest(String post, String account,Pane item) {
        AppointmentRequestBean bean= new AppointmentRequestBean();
        bean.setPost(post);
        bean.setApplicant(account);
        try{
            ManageAppointmentController.getInstance().denyApp(bean);
            item.setVisible(false);

        }catch(SQLException s){
            s.getMessage();
        }
    }

}
