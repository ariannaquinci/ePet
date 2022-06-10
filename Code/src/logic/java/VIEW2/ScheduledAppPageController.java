package VIEW2;

import Beans.ScheduledAppointmentBean;
import CONTROLLER.ManageAppointmentController;
import Exceptions.NoResultFoundException;
import Service.SessionFacade;
import com.example.epet.MainMobile;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import utils.ScheduledAppItem;

import java.io.IOException;

public class ScheduledAppPageController {


    @FXML
    private Label noResults;

    @FXML
    private VBox resultsBox;

    public void goBack() throws IOException {
        MainMobile M=new MainMobile();
        M.changeScene("fxml2/menu.fxml");
    }
    private void initResults(ObservableList<ScheduledAppointmentBean> list) throws IOException, NoResultFoundException {

        resultsBox.getChildren().clear();

        for(ScheduledAppointmentBean i: list) {
            MainMobile M= new MainMobile();
            ScheduledAppItem s= M.getSchedAppItem("fxml2/scheduledAppItem.fxml");
            schedAppItemController schedAppItemController=s.getControl2();
            Pane pane=s.getPane();

            schedAppItemController.setData( i.getData(),i.getLocation(),i.getUser1(),i.getUser2(), i.getScheduledAppID());
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane,new Insets(10,10,10,10));



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