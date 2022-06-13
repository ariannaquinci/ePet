package presentation.graphicInterfaces;

import beans.ScheduledAppointmentBean;
import exceptions.NoResultFoundException;
import javafx.collections.ObservableList;

import java.io.IOException;

public interface ScheduledAppPageGraphic {
    void goBack() throws IOException;

    void initResults(ObservableList<ScheduledAppointmentBean> list) throws IOException, NoResultFoundException;

    void showScheduledApps() throws IOException;
}
