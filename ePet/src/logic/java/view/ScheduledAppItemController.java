package view;



import beans.ScheduledAppointmentBean;
import controller.ManageAppointmentController;
import service.SessionFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import java.sql.SQLException;

public class ScheduledAppItemController {


    @FXML
    private TextArea account;

    @FXML
    private TextArea date;

    @FXML
    private Label id;

    @FXML
    private Pane item;

    @FXML
    private TextArea place;







    public void setData(String data, String location , String usr1, String usr2,String ID){
            date.setText(data);
            place.setText(location);
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
