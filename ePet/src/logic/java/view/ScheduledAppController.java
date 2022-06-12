package view;

import beans.ScheduledAppointmentBean;
import controller.ManageAppointmentController;
import exceptions.NoResultFoundException;
import service.SessionFacade;
import com.example.epet.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import utils.ScheduledAppItem;

import java.io.IOException;

public class ScheduledAppController {
    @FXML
    private VBox resultsBox;
    @FXML
    private Label noResults;
    public void goBack() throws IOException {
        Main M=new Main();
        M.changeScene("fxml1/homepage.fxml");
    }
    private void initResults(ObservableList<ScheduledAppointmentBean> list) throws IOException, NoResultFoundException {

        resultsBox.getChildren().clear();

        for(ScheduledAppointmentBean i: list) {
            Main m= new Main();
            ScheduledAppItem s= m.getSchedAppItem("fxml1/scheduledAppItem.fxml");
            ScheduledAppItemController schedAppItemController=s.getController();
            Pane pane=s.getPane();

            schedAppItemController.setData( i.getData(),i.getLocation(),i.getUser1(),i.getUser2(), i.getScheduledAppID());
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane,new Insets(10,242,10,242));



        }

    }

    @FXML
    protected void showScheduledApps() throws IOException{
        ScheduledAppointmentBean bean= new ScheduledAppointmentBean();
        bean.setUser1(SessionFacade.getSession().getID());
        try{
            initResults(ManageAppointmentController.getInstance().showScheduledApps(bean));


        }catch(NoResultFoundException n){
           noResults.setText(n.getMessage());
        }



    }
}
