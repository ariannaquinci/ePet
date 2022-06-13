package presentation.view;

import com.example.epet.Main;
import javafx.fxml.FXML;

import java.io.IOException;



public class StartController {

    @FXML
    protected void onLoginButtonClick() throws IOException{

        Main m= new Main();
        m.changeScene("fxml1/login.fxml");
    }

    @FXML
    protected void onRegisterButtonClick() throws IOException {
        Main m= new Main();
        m.changeScene("fxml1/register1.fxml");
    }


}