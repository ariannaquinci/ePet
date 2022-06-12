package view;

import beans.ProfileBean;
import beans.UserBean;
import exceptions.InvalidFieldException;
import service.SessionFacade;
import com.example.epet.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utils.UserEnum;

import java.io.IOException;
import java.sql.SQLException;


public class LoginController {


    @FXML
    private TextField unField;
    @FXML
    private PasswordField pwField;
    @FXML
    private Label wrongAccess;

    @FXML
    protected void goBack() throws IOException {
        Main H= new Main();
        H.changeScene("fxml1/start_menu.fxml");
    }



    @FXML
    protected void checkLogin() throws IOException{
        try {
        UserBean credentials = new UserBean();
        credentials.setEmail(unField.getText());
        credentials.setPassword(pwField.getText());

        ProfileBean profilebean = new ProfileBean();
        profilebean.setUser(credentials.toString());

        credentials.verifyFields(unField.getText(), pwField.getText());
        controller.LoginController.getInstance().Login(credentials);

        }catch (InvalidFieldException i){
            wrongAccess.setText(String.valueOf(i.getMessage()));
        }catch (SQLException s){

            wrongAccess.setText(String.valueOf(s.getMessage()));
        }


        if(SessionFacade.getSession().getCurrUserType() == UserEnum.SIMPLE_USER) {
            Main H=new Main();
            H.changeScene("fxml1/homepage.fxml");
        }


    }
}
