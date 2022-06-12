package viewmobile;

import com.example.epet.MainMobile;
import javafx.fxml.FXML;

import java.io.IOException;

public class StartMenuController {
    @FXML
    protected void register() throws IOException {
        MainMobile m= new MainMobile();
        m.changeScene("fxml2/registerMobile.fxml");
    }
    @FXML
    protected void login() throws IOException {
        MainMobile m= new MainMobile();
        m.changeScene("fxml2/loginMobile.fxml");

    }
}
