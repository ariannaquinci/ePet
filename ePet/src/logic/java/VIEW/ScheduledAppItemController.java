package VIEW;



import Beans.AppointmentRequestBean;
import Beans.ScheduledAppointmentBean;
import CONTROLLER.ManageAppointmentController;
import Service.SessionFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ScheduledAppItemController {

    @FXML
    private Label id;
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

    public void setData(String data, String location , String usr1, String usr2,String ID){
            Date.setText(data);
            Place.setText(location);
            id.setText(ID);
            if(usr1.equals(SessionFacade.getSession().getID())){
                account.setText(usr2);
            }
            if(usr2.equals(SessionFacade.getSession().getID())){
                account.setText(usr1);
            }




    }

    @FXML
     protected void deleteApp()  {
        ScheduledAppointmentBean bean= new ScheduledAppointmentBean();
        bean.setScheduledAppID(id.getText());
        try {
            ManageAppointmentController.getInstance().deleteApp(bean);
            item.setVisible(false);
        }catch(SQLException s){

                s.printStackTrace();
        }

    }




}
