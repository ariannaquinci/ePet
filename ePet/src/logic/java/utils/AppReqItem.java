package utils;

import view.AppRequestController;
import javafx.scene.layout.Pane;

public class AppReqItem {
    private Pane pane;
    private view.AppRequestController control;
    private viewmobile.AppRequestController control2;
    public void setControl2(viewmobile.AppRequestController c2){
        this.control2=c2;
    }

    public Pane getPane(){return this.pane;}
    public AppRequestController getController(){return this.control;}
    public void setPane(Pane pane){this.pane=pane;}
    public void setController(AppRequestController controller){this.control=controller;}

    public viewmobile.AppRequestController getController2() {
        return this.control2;
    }
}
