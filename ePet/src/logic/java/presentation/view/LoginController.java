package presentation.view;

import beans.ProfileBean;
import beans.UserBean;
import com.example.epet.MainMobile;
import exceptions.InvalidFieldException;
import presentation.graphics.LoginGraphic;
import service.SessionFacade;
import com.example.epet.MainComputer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utils.UserEnum;

import java.io.IOException;
import java.sql.SQLException;


public class LoginController extends LoginGraphic {


    @FXML
    private TextField unField;
    @FXML
    private PasswordField pwField;
    @FXML
    private Label wrongAccess;


    public void goBack() throws IOException {
        super.goBack("fxml1/start_menu.fxml");
    }

    public void checkLogin() throws IOException{
        wrongAccess.setText(super.checkLogin(unField.getText(),pwField.getText()));


        if(SessionFacade.getSession().getCurrUserType() == UserEnum.SIMPLE_USER) {
            MainComputer m=new MainComputer();
            m.changeScene("fxml1/homepage.fxml");
        }


    }
}
