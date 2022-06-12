package utils;

import view2.PostSlotItemController;
import javafx.scene.layout.Pane;

public class PostSlotItem {
    private Pane pane;
    private view.PostSlotItemController control;
    private PostSlotItemController control2;

    public Pane getPane(){return this.pane;}
    public view.PostSlotItemController getController(){return this.control;}

    public PostSlotItemController getController2(){return this.control2;}
    public void setPane(Pane pane){this.pane=pane;}
    public void setController(view.PostSlotItemController controller){this.control=controller;}
    public void setControl2(PostSlotItemController controller){this.control2=controller;}

}
