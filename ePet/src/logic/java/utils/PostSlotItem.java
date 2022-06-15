package utils;

import presentation.view.PostSlotController;
import presentation.viewmobile.PostSlotItemController;
import javafx.scene.layout.Pane;

public class PostSlotItem {
    private Pane pane;
    private PostSlotController control;
    private PostSlotItemController control2;

    public Pane getPane(){return this.pane;}
    public PostSlotController getController(){return this.control;}

    public PostSlotItemController getController2(){return this.control2;}
    public void setPane(Pane pane){this.pane=pane;}
    public void setController(PostSlotController controller){this.control=controller;}
    public void setControl2(PostSlotItemController controller){this.control2=controller;}

}
