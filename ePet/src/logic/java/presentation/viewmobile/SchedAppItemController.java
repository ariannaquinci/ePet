package presentation.viewmobile;

import beans.ScheduledAppointmentBean;
import controller.ManageAppointmentController;
import presentation.graphics.SchedAppItemGraphic;
import service.SessionFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import java.sql.SQLException;

public class SchedAppItemController implements SchedAppItemGraphic {
    @FXML
    private TextArea date;

    @FXML
    private TextArea place;

    @FXML
    private TextArea account;

    @FXML
    private Label id;

    @FXML
    private Pane item;

    @Override
    public void setData(String data, String location , String usr1, String usr2,String i){
        date.setText(data);
        place.setText(location);
        id.setText(i);
        if(usr1.equals(SessionFacade.getSession().getID())){
            account.setText(usr2);
        }
        if(usr2.equals(SessionFacade.getSession().getID())){
            account.setText(usr1);
        }




    }

    @Override
    public void deleteApp()  {
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
