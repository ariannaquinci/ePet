package com.example.epet;

import view.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.*;
import view2.AppRequestController;

import java.io.IOException;

public class Main extends Application {
    private static Stage stg;
    private static Stage previous;
    private static Scene scene;
    private static Scene prev_scene;

    public static Stage getStage(){return stg;}


    public void setPrevious(Stage stage){previous=stage;}
    public Stage getPrevious(){return previous;}
    public static void setPrevScene(Scene sc){
        prev_scene=sc;
    }
    public static Scene getPrevScene(){
       return prev_scene;
    }

    public static void setScene(Scene sc){
        scene=sc;
    }
    public static Scene getScene(){
        return scene;
    }

    public static void setStage(Stage stage){stg=stage;}

   public Stage createPopupScene(String fxml) throws IOException{


        setPrevious(stg);
        setPrevScene(scene);

        FXMLLoader loader= new FXMLLoader();
        Parent root=loader.load(getClass().getResource(fxml));

        Stage stage=new Stage();
        stage.setTitle("ePet");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.initOwner(getStage().getScene().getWindow());
        setScene(stg.getScene());

        setStage(stage);
        return stage;


        }




    public Scene changeScene(String fxml) throws IOException{
        setPrevScene(stg.getScene());
        Parent pane= FXMLLoader.load(getClass().getResource(fxml));

        stg.getScene().setRoot(pane);
        setScene(stg.getScene());
        if(previous!=null){
        previous.close();}
        stg.show();
        return getScene();
    }



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
        FavoriteItemController favItemControl=fxmlLoader.getController();
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
        view.AppRequestController appReqControl=fxmlLoader.getController();
        AppReqItem p= new AppReqItem();
        p.setPane(pane);
        p.setController(appReqControl);
        return p;
    }


    public ScheduledAppItem getSchedAppItem(String fxml) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(fxml));
        Pane pane= fxmlLoader.load();
        ScheduledAppItemController SchedAppControl=fxmlLoader.getController();
        ScheduledAppItem s = new ScheduledAppItem();
        s.setPane(pane);
        s.setController(SchedAppControl);
        return s;
    }

    public SlotItem getSlotItem(String fxml) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(fxml));
        Pane pane= fxmlLoader.load();
        view.SlotController slotControl=fxmlLoader.getController();
        SlotItem s = new SlotItem();
        s.setPane(pane);
        s.setController(slotControl);
        return s;
    }

    public PostSlotItem getPostSlotItem(String fxml) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(fxml));
        Pane pane= fxmlLoader.load();
        PostSlotItemController slotControl=fxmlLoader.getController();
        PostSlotItem s = new PostSlotItem();
        s.setPane(pane);
        s.setController(slotControl);
        return s;
    }
    @Override
    public void start(Stage stage) throws IOException {
        stg=stage;
        stage.setResizable(false);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml1/start_menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1400, 800);
        stage.setTitle("ePet");
        stage.setScene(scene);
        setScene(stg.getScene());
        setPrevScene(null);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}
