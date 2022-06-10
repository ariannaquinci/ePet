package utils;

import VIEW.ScheduledAppItemController;
import VIEW2.schedAppItemController;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class ScheduledAppItem {
    @FXML
    private Pane pane;
    private ScheduledAppItemController control;
    private schedAppItemController control2;

    public schedAppItemController getControl2() {
        return control2;
    }

    public void setControl2(schedAppItemController control2) {
        this.control2 = control2;
    }

    public Pane getPane() {
        return pane;
    }

    public ScheduledAppItemController getControl() {
        return control;
    }

    public void setPane(Pane pane){this.pane=pane;}
    public void setController(ScheduledAppItemController controller){this.control=controller;}

    public ScheduledAppItemController getController() {
        return this.control;
    }


}

