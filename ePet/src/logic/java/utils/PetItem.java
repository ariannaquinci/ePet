package utils;

import presentation.viewmobile.PetItemController;
import javafx.scene.layout.Pane;

public class PetItem {
    private Pane pane;
    private presentation.view.PetItemController control;
    private PetItemController control2;

    public Pane getPane(){return this.pane;}
    public presentation.view.PetItemController getController(){return this.control;}
    public void setPane(Pane pane){this.pane=pane;}
    public void setController(presentation.view.PetItemController controller){this.control=controller;}

    public void setController2(PetItemController itemControl) {
        this.control2=itemControl;
    }
    public PetItemController getController2(){return this.control2;}
}
