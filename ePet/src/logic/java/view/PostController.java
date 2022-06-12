package view;

import com.example.epet.Main;

import java.io.IOException;

public class PostController {



    public void goHome() throws IOException{
        Main m= new Main();
        m.changeScene("fxml1/homepage.fxml");
    }
}
