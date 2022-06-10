package utils;

import Beans.SlotAppuntamentoBean;
import VIEW.PostSlotItemController;
import VIEW.slotController;
import VIEW2.postSlotItemController;
import javafx.scene.layout.Pane;

public class PostSlotItem {
    private Pane pane;
    private PostSlotItemController control;
    private postSlotItemController control2;

    public Pane getPane(){return this.pane;}
    public PostSlotItemController getController(){return this.control;}

    public postSlotItemController getController2(){return this.control2;}
    public void setPane(Pane pane){this.pane=pane;}
    public void setController(PostSlotItemController controller){this.control=controller;}
    public void setControl2(postSlotItemController controller){this.control2=controller;}

}
