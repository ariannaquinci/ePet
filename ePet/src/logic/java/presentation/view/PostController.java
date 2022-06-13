package presentation.view;

import com.example.epet.MainComputer;

import java.io.IOException;

public class PostController {



    public void goHome() throws IOException{
        MainComputer m= new MainComputer();
        m.changeScene("fxml1/homepage.fxml");
    }
}
