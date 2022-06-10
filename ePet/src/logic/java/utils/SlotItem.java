package utils;

import VIEW.slotController;
import VIEW2.SlotItemController;
import javafx.scene.layout.Pane;

public class SlotItem {
    private Pane pane;
    private slotController control;
    private SlotItemController control2;

    public Pane getPane(){return this.pane;}
    public slotController getController(){return this.control;}
    public void setPane(Pane pane){this.pane=pane;}
    public void setController(slotController controller){this.control=controller;}
    public void setController2(SlotItemController controller){this.control2=controller;}
    public SlotItemController getController2(){return this.control2;}

}
