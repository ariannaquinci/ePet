package VIEW;

import com.example.epet.Main;
import javafx.fxml.FXML;
import javafx.scene.text.TextFlow;

import java.io.IOException;

public class PostController {
    @FXML
    TextFlow postText;



    public void goHome() throws IOException{
        Main H= new Main();
        H.changeScene("fxml1/homepage.fxml");
    }
}
