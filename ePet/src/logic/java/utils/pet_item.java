package utils;

import VIEW.PetItemController;
import VIEW2.petItemController;
import javafx.scene.layout.Pane;

public class pet_item {
    private Pane pane;
    private PetItemController control;
    private petItemController control2;

    public Pane getPane(){return this.pane;}
    public PetItemController getController(){return this.control;}
    public void setPane(Pane pane){this.pane=pane;}
    public void setController(PetItemController controller){this.control=controller;}

    public void setController2(petItemController itemControl) {
        this.control2=itemControl;
    }
    public petItemController getController2(){return this.control2;}
}
