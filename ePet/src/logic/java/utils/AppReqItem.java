package utils;

import presentation.view.AppRequestController;
import javafx.scene.layout.Pane;

public class AppReqItem {
    private Pane pane;
    private presentation.view.AppRequestController control;
    private presentation.viewmobile.AppRequestController control2;
    public void setControl2(presentation.viewmobile.AppRequestController c2){
        this.control2=c2;
    }

    public Pane getPane(){return this.pane;}
    public AppRequestController getController(){return this.control;}
    public void setPane(Pane pane){this.pane=pane;}
    public void setController(AppRequestController controller){this.control=controller;}

    public presentation.viewmobile.AppRequestController getController2() {
        return this.control2;
    }
}
