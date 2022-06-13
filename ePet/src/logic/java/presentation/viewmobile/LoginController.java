package presentation.viewmobile;

import beans.ProfileBean;
import beans.UserBean;
import exceptions.InvalidFieldException;
import presentation.graphics.LoginGraphic;
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

public class LoginController extends LoginGraphic {
    @FXML
    private PasswordField pwField;
    @FXML
    private Button loginButton;


    @FXML
    private TextField unField;
    @FXML
    private Label wrongAccess;

    public void goBack() throws IOException {
        super.goBack("fxml2/StartMenuMobile.fxml");
    }
    public void checkLogin() throws IOException {
        wrongAccess.setText(super.checkLogin(unField.getText(),pwField.getText()));
        if(SessionFacade.getSession().getCurrUserType() == UserEnum.SIMPLE_USER) {
            MainMobile m=new MainMobile();
            m.changeScene("fxml2/HomepageMobile.fxml");
        }
    }



}
