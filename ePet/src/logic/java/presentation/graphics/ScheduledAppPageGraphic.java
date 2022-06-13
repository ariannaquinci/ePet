package presentation.graphics;

import beans.ScheduledAppointmentBean;
import com.example.epet.MainComputer;
import com.example.epet.MainMobile;
import controller.ManageAppointmentController;
import exceptions.NoResultFoundException;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import presentation.view.ScheduledAppController;
import presentation.view.ScheduledAppItemController;
import presentation.viewmobile.SchedAppItemController;
import presentation.viewmobile.ScheduledAppPageController;
import service.SessionFacade;
import utils.ScheduledAppItem;

import java.io.IOException;

public class ScheduledAppPageGraphic {
    protected void initResults(ObservableList<ScheduledAppointmentBean> list, ScheduledAppPageGraphic sc) throws IOException, NoResultFoundException {



        if(sc.getClass()== ScheduledAppController.class){
            VBox resultsBox=((ScheduledAppController)sc).getResultsBox();
            resultsBox.getChildren().clear();
        for(ScheduledAppointmentBean i: list) {
            MainComputer m= new MainComputer();
            ScheduledAppItem s= m.getSchedAppItem("fxml1/scheduledAppItem.fxml");
            ScheduledAppItemController schedAppItemController=s.getController();
            Pane pane=s.getPane();

            schedAppItemController.setData( i.getData(),i.getLocation(),i.getUser1(),i.getUser2(), i.getScheduledAppID());
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane,new Insets(10,242,10,242));



        }}
        else if(sc.getClass()== ScheduledAppPageController.class){
            VBox resultsBox=((ScheduledAppPageController)sc).getResultsBox();
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

    }


    protected String showScheduledApps(ScheduledAppPageGraphic s) throws IOException{
        String noResults="";
        ScheduledAppointmentBean bean= new ScheduledAppointmentBean();
        bean.setUser1(SessionFacade.getSession().getID());
        try{
            initResults(ManageAppointmentController.getInstance().showScheduledApps(bean),s);


        }catch(NoResultFoundException n){
            noResults=n.getMessage();
        }
        return noResults;



    }
}
