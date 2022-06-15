package presentation.viewmobile;

import beans.ScheduledAppointmentBean;
import controller.ManageAppointmentController;
import exceptions.NoResultFoundException;
import presentation.graphics.ScheduledAppPageGraphic;
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

public class ScheduledAppPageController extends ScheduledAppPageGraphic {


    @FXML
    private Label noResults;

    @FXML
    private VBox resultsBox;


    public void goBack() throws IOException {
        MainMobile m=new MainMobile();
        m.changeScene("fxml2/menu.fxml");
    }

    public void showScheduledApps() throws IOException{
        noResults.setText(super.showScheduledApps(this));


    }
    public VBox getResultsBox(){
        return this.resultsBox;
    }

}
