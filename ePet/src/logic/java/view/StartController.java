package view;

import com.example.epet.Main;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;


public class StartController {
    public Stage stage;


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