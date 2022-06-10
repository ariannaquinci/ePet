package VIEW;

import Beans.AppointmentRequestBean;
import CONTROLLER.ManageAppointmentController;
import Exceptions.NoResultFoundException;
import Service.SessionFacade;
import com.example.epet.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import utils.appReqItem;

import java.io.IOException;

public class NotificationController {

    @FXML
    private Label noResults;
    @FXML
    private VBox results;
    @FXML
    private VBox post;

    @FXML
    protected void showAppRequests(){
        AppointmentRequestBean bean= new AppointmentRequestBean();
        bean.setReceiver(SessionFacade.getSession().getID());
        try{
            initResults(ManageAppointmentController.getInstance().showAppRequests(bean));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch(NoResultFoundException n){
            noResults.setText(n.getMessage());
        }
    }
    private void initResults(ObservableList<AppointmentRequestBean> list) throws IOException, NoResultFoundException {

        results.getChildren().clear();

        for(AppointmentRequestBean i: list) {
            Main M= new Main();
            appReqItem p= M.getAppReqItem("fxml1/appRequestItem.fxml");
            appRequestController appReqController=p.getController();
            Pane pane=p.getPane();

            appReqController.setData( i.getDate(), i.getPlace(), i.getApplicant(), i.getPost());
            results.getChildren().add(pane);
            results.setMargin(pane,new Insets(10,10,10,10));



        }

    }
}
