package utils;

import viewmobile.PostItemController;
import javafx.scene.layout.Pane;

public class PostItem {
    private Pane pane;
    private view.PostItemController control;
    private PostItemController control2;

    public Pane getPane(){return this.pane;}
    public view.PostItemController getController(){return this.control;}
    public void setPane(Pane pane){this.pane=pane;}
    public void setController(view.PostItemController controller){this.control=controller;}
    public void setController(PostItemController controller){this.control2=controller;}
    public PostItemController getController2(){return this.control2;}

}
