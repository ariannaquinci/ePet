package presentation.view;

import beans.AppointmentRequestBean;
import controller.ManageAppointmentController;
import exceptions.NoResultFoundException;
import service.SessionFacade;
import com.example.epet.MainComputer;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import utils.AppReqItem;

import java.io.IOException;

public class NotificationController {

    @FXML
    private Label noResults;
    @FXML
    private VBox results;


    @FXML
    protected void showAppRequests() throws IOException{
        AppointmentRequestBean bean= new AppointmentRequestBean();
        bean.setReceiver(SessionFacade.getSession().getID());
        try{
            initResults(ManageAppointmentController.getInstance().showAppRequests(bean));


        }catch(NoResultFoundException n){
            noResults.setText(n.getMessage());
        }
    }
    private void initResults(ObservableList<AppointmentRequestBean> list) throws IOException, NoResultFoundException {
        noResults.setText("");
        results.getChildren().clear();

        for(AppointmentRequestBean i: list) {
            MainComputer m= new MainComputer();
            AppReqItem p= m.getAppReqItem("fxml1/appRequestItem.fxml");
            AppRequestController appReqController=p.getController();
            Pane pane=p.getPane();

            appReqController.setData( i.getDate(), i.getPlace(), i.getApplicant(), i.getPost());
            results.getChildren().add(pane);
            results.setMargin(pane,new Insets(10,10,10,10));



        }

    }
}
