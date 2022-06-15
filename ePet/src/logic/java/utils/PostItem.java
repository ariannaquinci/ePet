package utils;

import presentation.viewmobile.PostItemController;
import javafx.scene.layout.Pane;

public class PostItem {
    private Pane pane;
    private presentation.view.PostItemController control;
    private PostItemController control2;

    public Pane getPane(){return this.pane;}
    public presentation.view.PostItemController getController(){return this.control;}
    public void setPane(Pane pane){this.pane=pane;}
    public void setController(presentation.view.PostItemController controller){this.control=controller;}
    public void setController(PostItemController controller){this.control2=controller;}
    public PostItemController getController2(){return this.control2;}

}
