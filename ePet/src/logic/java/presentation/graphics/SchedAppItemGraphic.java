package presentation.graphics;

import beans.ScheduledAppointmentBean;
import controller.ManageAppointmentController;
import javafx.scene.layout.Pane;

import java.sql.SQLException;

public class SchedAppItemGraphic {
    public void deleteApp(String id, Pane item)  {
        ScheduledAppointmentBean bean= new ScheduledAppointmentBean();
        bean.setScheduledAppID(id);
        try {
            ManageAppointmentController.getInstance().deleteApp(bean);
            item.setVisible(false);
        }catch(SQLException s){

            s.printStackTrace();
        }

    }
}
