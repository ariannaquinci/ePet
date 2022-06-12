package utils;

import view2.PetItemController;
import javafx.scene.layout.Pane;

public class PetItem {
    private Pane pane;
    private view.PetItemController control;
    private PetItemController control2;

    public Pane getPane(){return this.pane;}
    public view.PetItemController getController(){return this.control;}
    public void setPane(Pane pane){this.pane=pane;}
    public void setController(view.PetItemController controller){this.control=controller;}

    public void setController2(PetItemController itemControl) {
        this.control2=itemControl;
    }
    public PetItemController getController2(){return this.control2;}
}
