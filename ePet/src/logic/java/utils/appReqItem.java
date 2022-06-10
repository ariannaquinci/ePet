package utils;

import VIEW.PetItemController;
import VIEW.appRequestController;
import VIEW2.AppRequestController;
import javafx.scene.layout.Pane;

public class appReqItem {
    private Pane pane;
    private appRequestController control;
    private AppRequestController control2;
    public void setControl2(AppRequestController c2){
        this.control2=c2;
    }

    public Pane getPane(){return this.pane;}
    public appRequestController getController(){return this.control;}
    public void setPane(Pane pane){this.pane=pane;}
    public void setController(appRequestController controller){this.control=controller;}

    public AppRequestController getController2() {
        return this.control2;
    }
}
