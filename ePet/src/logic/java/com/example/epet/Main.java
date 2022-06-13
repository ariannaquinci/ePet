package com.example.epet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage stg;
    private static Stage previous;
    private static Scene scene;
    private static Scene prevScene;

    public static Stage getStage(){return stg;}


    public static  void setPrevious(Stage stage){previous=stage;}
    public  Stage getPrevious(){return previous;}
    public static void setPrevScene(Scene sc){
        prevScene=sc;
    }
    public static Scene getPrevScene(){
        return prevScene;
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
        if(getPrevious()!=null){
            previous.close();}
        stg.show();
        return getScene();
    }
    @Override
    public void start(Stage stage) throws IOException {
            //override in MainComputer e MainMobile
    }

}
