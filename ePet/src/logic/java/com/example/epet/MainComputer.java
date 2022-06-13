package com.example.epet;

import presentation.view.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.*;

import java.io.IOException;

public class MainComputer extends Main{



    public PetItem getItem(String fxml) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(fxml));
        Pane pane= fxmlLoader.load();
        PetItemController petItemControl=fxmlLoader.getController();
        PetItem p= new PetItem();
        p.setPane(pane);
        p.setController(petItemControl);
        return p;
    }

    public FavoriteItem getFavItem(String fxml) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(fxml));
        Pane pane= fxmlLoader.load();
        FavItemController favItemControl=fxmlLoader.getController();
        FavoriteItem f= new FavoriteItem();
        f.setPane(pane);
        f.setController(favItemControl);
        return f;
    }


    public PostItem getPostItem(String fxml) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(fxml));
        Pane pane= fxmlLoader.load();
        PostItemController postItemControl=fxmlLoader.getController();
        PostItem p= new PostItem();
        p.setPane(pane);
        p.setController(postItemControl);
        return p;
    }
    public AppReqItem getAppReqItem(String fxml) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(fxml));
        Pane pane= fxmlLoader.load();
        AppRequestController appReqControl=fxmlLoader.getController();
        AppReqItem p= new AppReqItem();
        p.setPane(pane);
        p.setController(appReqControl);
        return p;
    }


    public ScheduledAppItem getSchedAppItem(String fxml) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(fxml));
        Pane pane= fxmlLoader.load();
        ScheduledAppItemController schedAppControl=fxmlLoader.getController();
        ScheduledAppItem s = new ScheduledAppItem();
        s.setPane(pane);
        s.setController(schedAppControl);
        return s;
    }

    public SlotItem getSlotItem(String fxml) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(fxml));
        Pane pane= fxmlLoader.load();
        presentation.view.SlotController slotControl=fxmlLoader.getController();
        SlotItem s = new SlotItem();
        s.setPane(pane);
        s.setController(slotControl);
        return s;
    }

    public PostSlotItem getPostSlotItem(String fxml) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(fxml));
        Pane pane= fxmlLoader.load();
        PostSlotController slotControl=fxmlLoader.getController();
        PostSlotItem s = new PostSlotItem();
        s.setPane(pane);
        s.setController(slotControl);
        return s;
    }

    @Override
    public void start(Stage stage) throws IOException {
        setStage(stage);
        stage.setResizable(false);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml1/start_menu.fxml"));
        Scene s = new Scene(fxmlLoader.load(), 1400, 800);
        stage.setTitle("ePet");
        stage.setScene(s);

        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}
