package view2;

import beans.ScheduledAppointmentBean;
import controller.ManageAppointmentController;
import service.SessionFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import java.sql.SQLException;

public class SchedAppItemController {
    @FXML
    private TextArea Date;

    @FXML
    private TextArea Place;

    @FXML
    private TextArea account;

    @FXML
    private Label id;

    @FXML
    private Pane item;

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
