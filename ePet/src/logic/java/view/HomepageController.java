package view;

import com.example.epet.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;

public class HomepageController {

        @FXML
        protected void goToProfile() throws IOException{

           Main m=new Main();


           Stage popup= m.createPopupScene("fxml1/profile.fxml");

           popup.show();


        }

        @FXML
        protected void adoptAPet() throws IOException{
            Main m= new Main();
            m.changeScene("fxml1/adoption.fxml");

        }
        @FXML
        protected void putAPetInAdoption() throws IOException{
            Main m= new Main();
            m.changeScene("fxml1/putInAdoption.fxml");


        }

        @FXML
        protected void showFavorites() throws IOException{

            Main m= new Main();
            m.changeScene("fxml1/favorites.fxml");

        }
        @FXML
        protected void myPosts() throws IOException {

            Main m= new Main();
            m.changeScene("fxml1/posts_page.fxml");


            }
        @FXML
        protected void notifications() throws IOException {
            Main m = new Main();
            Stage popup= m.createPopupScene("fxml1/notifications.fxml");
            popup.centerOnScreen();
            popup.show();
        }
        @FXML

    protected void scheduledApps() throws IOException {
            Main m=new Main();
            m.changeScene("fxml1/scheduled_app.fxml");
    }
}




