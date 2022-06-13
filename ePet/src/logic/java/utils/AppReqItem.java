package utils;

import presentation.view.AppRequestController;
import javafx.scene.layout.Pane;

public class AppReqItem {
    private Pane pane;
    private presentation.view.AppRequestController control;
    private presentation.viewmobile.AppRequestControllerMobile control2;
    public void setControl2(presentation.viewmobile.AppRequestControllerMobile c2){
        this.control2=c2;
    }

    public Pane getPane(){return this.pane;}
    public AppRequestController getController(){return this.control;}
    public void setPane(Pane pane){this.pane=pane;}
    public void setController(AppRequestController controller){this.control=controller;}

    public presentation.viewmobile.AppRequestControllerMobile getController2() {
        return this.control2;
    }
}
