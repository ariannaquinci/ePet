package utils;

import presentation.view.FavItemController;
import javafx.scene.layout.Pane;

public class FavoriteItem {
    private Pane pane;
    private FavItemController control;
    private presentation.viewmobile.FavoriteItemController control2;

    public Pane getPane(){return this.pane;}
    public FavItemController getController(){return this.control;}
    public void setPane(Pane pane){this.pane=pane;}
    public void setController(FavItemController controller){this.control=controller;}

    public presentation.viewmobile.FavoriteItemController getControl2(){return this.control2;}
    public void setController2(presentation.viewmobile.FavoriteItemController favItemControl) {
        this.control2=favItemControl;
    }
}
