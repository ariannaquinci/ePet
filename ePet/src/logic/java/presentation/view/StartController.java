package presentation.view;

import com.example.epet.MainComputer;
import javafx.fxml.FXML;

import java.io.IOException;



public class StartController {

    @FXML
    protected void onLoginButtonClick() throws IOException{

        MainComputer m= new MainComputer();
        m.changeScene("fxml1/login.fxml");
    }

    @FXML
    protected void onRegisterButtonClick() throws IOException {
        MainComputer m= new MainComputer();
        m.changeScene("fxml1/register1.fxml");
    }


}