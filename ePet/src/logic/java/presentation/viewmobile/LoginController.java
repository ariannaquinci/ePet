package presentation.viewmobile;

import beans.ProfileBean;
import beans.UserBean;
import exceptions.InvalidFieldException;
import service.SessionFacade;
import com.example.epet.MainMobile;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utils.UserEnum;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private PasswordField pwField;
    @FXML
    private Button loginButton;


    @FXML
    private TextField unField;
    @FXML
    private Label wrongAccess;



    @FXML
    protected void goBack() throws IOException {
        MainMobile m= new MainMobile();
        m.changeScene("fxml2/StartMenuMobile.fxml");
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
            controller.LoginController.getInstance().login(credentials);

        }catch (InvalidFieldException i){
            wrongAccess.setText(String.valueOf(i.getMessage()));
        }catch (SQLException s){
            wrongAccess.setText(String.valueOf(s.getMessage()));
        }


        if(SessionFacade.getSession().getCurrUserType() == UserEnum.SIMPLE_USER) {
            MainMobile m=new MainMobile();
            m.changeScene("fxml2/HomepageMobile.fxml");
        }


    }
}
