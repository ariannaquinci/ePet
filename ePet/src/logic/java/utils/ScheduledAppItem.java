package utils;

import presentation.view.ScheduledAppItemController;
import presentation.viewmobile.SchedAppItemController;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class ScheduledAppItem {
    @FXML
    private Pane pane;
    private ScheduledAppItemController control;
    private SchedAppItemController control2;

    public SchedAppItemController getControl2() {
        return control2;
    }

    public void setControl2(SchedAppItemController control2) {
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

