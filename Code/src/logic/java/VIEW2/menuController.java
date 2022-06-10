package VIEW2;

import com.example.epet.MainMobile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class menuController {


    @FXML
    protected void adoptAPet() throws IOException{
        MainMobile H= new MainMobile();
        H.changeScene("fxml2/research.fxml");

    }

    @FXML
    protected void showFavorites() throws IOException{

        MainMobile H= new MainMobile();
        H.changeScene("fxml2/favoritesPage.fxml");


    }

    @FXML
    protected void scheduledApps(ActionEvent event) throws IOException {
        MainMobile M=new MainMobile();
        M.changeScene("fxml2/scheduledAppPage.fxml");
    }
    @FXML
    public void goBack() throws IOException {
        MainMobile M=new MainMobile();
        M.changeScene("fxml2/HomepageMobile.fxml");
    }


}
