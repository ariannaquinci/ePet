package presentation.viewmobile;

import beans.ScheduledAppointmentBean;
import controller.ManageAppointmentController;
import exceptions.NoResultFoundException;
import presentation.graphicInterfaces.ScheduledAppPageGraphic;
import service.SessionFacade;
import com.example.epet.MainMobile;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import utils.ScheduledAppItem;

import java.io.IOException;

public class ScheduledAppPageController implements ScheduledAppPageGraphic {


    @FXML
    private Label noResults;

    @FXML
    private VBox resultsBox;

    @Override
    public void goBack() throws IOException {
        MainMobile m=new MainMobile();
        m.changeScene("fxml2/menu.fxml");
    }
    @Override
    public void initResults(ObservableList<ScheduledAppointmentBean> list) throws IOException, NoResultFoundException {

        resultsBox.getChildren().clear();

        for(ScheduledAppointmentBean i: list) {
            MainMobile m= new MainMobile();
            ScheduledAppItem s= m.getSchedAppItem("fxml2/scheduledAppItem.fxml");
            SchedAppItemController schedAppItemController=s.getControl2();
            Pane pane=s.getPane();

            schedAppItemController.setData( i.getData(),i.getLocation(),i.getUser1(),i.getUser2(), i.getScheduledAppID());
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane,new Insets(10,10,10,10));



        }

    }

    @Override
    public void showScheduledApps() throws IOException{
        ScheduledAppointmentBean bean= new ScheduledAppointmentBean();
        bean.setUser1(SessionFacade.getSession().getID());
        try{
            initResults(ManageAppointmentController.getInstance().showScheduledApps(bean));


        }catch(NoResultFoundException n){
            noResults.setText(n.getMessage());
        }



    }

}
