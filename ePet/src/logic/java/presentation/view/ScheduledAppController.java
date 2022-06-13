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

public class ScheduledAppController extends ScheduledAppPageGraphic {
    @FXML
    private VBox resultsBox;
    @FXML
    private Label noResults;

    public void showScheduledApps() throws IOException {
        super.showScheduledApps(this);
    }

    public void goBack() throws IOException {
        MainComputer m=new MainComputer();
        m.changeScene("fxml1/homepage.fxml");
    }

    public VBox getResultsBox(){
        return this.resultsBox;
    }


}
