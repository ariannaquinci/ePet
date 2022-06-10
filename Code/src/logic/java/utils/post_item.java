package utils;

import VIEW.PetItemController;
import VIEW.PostItemController;
import VIEW2.postItemController;
import javafx.scene.layout.Pane;

public class post_item {
    private Pane pane;
    private PostItemController control;
    private postItemController control2;

    public Pane getPane(){return this.pane;}
    public PostItemController getController(){return this.control;}
    public void setPane(Pane pane){this.pane=pane;}
    public void setController(PostItemController controller){this.control=controller;}
    public void setController(postItemController controller){this.control2=controller;}
    public postItemController getController2(){return this.control2;}

}
