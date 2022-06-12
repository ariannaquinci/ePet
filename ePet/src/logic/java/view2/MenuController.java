package view2;

import com.example.epet.MainMobile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MenuController {


    @FXML
    protected void adoptAPet() throws IOException{
        MainMobile m= new MainMobile();
        m.changeScene("fxml2/research.fxml");

    }

    @FXML
    protected void showFavorites() throws IOException{

        MainMobile m= new MainMobile();
        m.changeScene("fxml2/favoritesPage.fxml");


    }

    @FXML
    protected void scheduledApps(ActionEvent event) throws IOException {
        MainMobile m=new MainMobile();
        m.changeScene("fxml2/scheduledAppPage.fxml");
    }
    @FXML
    public void goBack() throws IOException {
        MainMobile m=new MainMobile();
        m.changeScene("fxml2/HomepageMobile.fxml");
    }


}
