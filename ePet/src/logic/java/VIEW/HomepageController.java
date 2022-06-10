package VIEW;

import com.example.epet.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class HomepageController {

        @FXML
        protected void goToProfile() throws IOException{

           Main H=new Main();


            H.createPopupScene("fxml1/profile.fxml");

        }

        @FXML
        protected void adoptAPet() throws IOException{
            Main H= new Main();
            H.changeScene("fxml1/adoption.fxml");

        }
        @FXML
        protected void putAPetInAdoption() throws IOException{
            Main H= new Main();
            H.changeScene("fxml1/putInAdoption.fxml");
            System.out.println("put a pet in adoption!");

        }

        @FXML
        protected void showFavorites() throws IOException{

            Main H= new Main();
            H.changeScene("fxml1/favorites.fxml");

        }
        @FXML
        protected void myPosts() throws IOException {

            Main H= new Main();
            H.changeScene("fxml1/posts_page.fxml");


            }
        @FXML
        protected void notifications() throws IOException {
            Main M = new Main();
            M.createPopupScene("fxml1/notifications.fxml");
        }

    public void scheduledApps(ActionEvent event) throws IOException {
            Main M=new Main();
            M.changeScene("fxml1/scheduled_app.fxml");
    }
}




