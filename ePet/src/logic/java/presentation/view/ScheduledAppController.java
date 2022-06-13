package presentation.view;

import beans.ScheduledAppointmentBean;
import controller.ManageAppointmentController;
import exceptions.NoResultFoundException;
import presentation.graphics.ScheduledAppPageGraphic;
import service.SessionFacade;
import com.example.epet.MainComputer;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import utils.ScheduledAppItem;

import java.io.IOException;

public class ScheduledAppController implements ScheduledAppPageGraphic {
    @FXML
    private VBox resultsBox;
    @FXML
    private Label noResults;
    @Override
    public void goBack() throws IOException {
        MainComputer m=new MainComputer();
        m.changeScene("fxml1/homepage.fxml");
    }
    @Override
    public void initResults(ObservableList<ScheduledAppointmentBean> list) throws IOException, NoResultFoundException {

        resultsBox.getChildren().clear();

        for(ScheduledAppointmentBean i: list) {
            MainComputer m= new MainComputer();
            ScheduledAppItem s= m.getSchedAppItem("fxml1/scheduledAppItem.fxml");
            ScheduledAppItemController schedAppItemController=s.getController();
            Pane pane=s.getPane();

            schedAppItemController.setData( i.getData(),i.getLocation(),i.getUser1(),i.getUser2(), i.getScheduledAppID());
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane,new Insets(10,242,10,242));



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