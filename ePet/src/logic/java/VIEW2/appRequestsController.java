package VIEW2;

import Beans.AppointmentRequestBean;
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
import utils.appReqItem;

import java.io.IOException;

public class appRequestsController {
    @FXML
    private Label noResults;

    @FXML
    private VBox resultsBox;
    @FXML
    protected void goBack() throws IOException {
        MainMobile m= new MainMobile();
        m.changeScene("fxml2/HomepageMobile.fxml");
    }

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

        resultsBox.getChildren().clear();

        for(AppointmentRequestBean i: list) {
            MainMobile M= new MainMobile();
            appReqItem p= M.getAppReqItem("fxml2/appRequestItem.fxml");
            AppRequestController appReqController=p.getController2();
            Pane pane=p.getPane();

            appReqController.setData( i.getDate(), i.getPlace(), i.getApplicant(), i.getPost());
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane,new Insets(10,10,10,10));



        }



}

}
