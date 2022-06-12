package view2;

import com.example.epet.MainMobile;
import javafx.fxml.FXML;

import java.io.IOException;

public class StartMenuController {
    @FXML
    protected void Register() throws IOException {
        MainMobile m= new MainMobile();
        m.changeScene("fxml2/registerMobile.fxml");
    }
    @FXML
    protected void Login() throws IOException {
        MainMobile m= new MainMobile();
        m.changeScene("fxml2/loginMobile.fxml");

    }
}
