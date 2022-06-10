package com.example.epet;

import Entities.Favorite;
import VIEW.FavoriteItemController;
import VIEW.PostItemController;
import javafx.scene.layout.Pane;

public class favoriteItem {
    private Pane pane;
    private FavoriteItemController control;
    private VIEW2.FavoriteItemController control2;

    public Pane getPane(){return this.pane;}
    public FavoriteItemController getController(){return this.control;}
    public void setPane(Pane pane){this.pane=pane;}
    public void setController(FavoriteItemController controller){this.control=controller;}

    public VIEW2.FavoriteItemController getControl2(){return this.control2;}
    public void setController2(VIEW2.FavoriteItemController favItemControl) {
        this.control2=favItemControl;
    }
}
