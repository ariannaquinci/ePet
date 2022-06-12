package view;

import java.io.IOException;
import java.sql.SQLException;

import beans.UserBean;
import controller.LoginController;
import exceptions.DuplicatedUserException;
import exceptions.InvalidFieldException;
import com.example.epet.Main;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.security.auth.login.FailedLoginException;


public class RegisterController {
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField pwField;
    @FXML
    private PasswordField confPwField;
    @FXML
    private Label errorMsg;

    @FXML
    private RadioButton type;


    @FXML
    public String getEmail(){
       return this.emailField.getText();
    }
    @FXML
    protected void goToStart() throws IOException {
        Main m = new Main();
        m.changeScene("fxml1/start_menu.fxml");
    }


    @FXML
    public void createUser() throws IOException,  SQLException, FailedLoginException {
        UserBean credentials = new UserBean();
        credentials.setEmail(emailField.getText());
        credentials.setPassword(pwField.getText());
        credentials.setRole("SIMPLE_USER");


        try{

            credentials.verifySignUpSyntax(confPwField.getText());
            controller.RegisterController.getInstance().Register(credentials);
            LoginController.getInstance().Login(credentials);
            Main m= new Main();
            m.changeScene("fxml1/register2.fxml");

        }catch(InvalidFieldException i){
            errorMsg.setText(String.valueOf(i.getMessage()));
        }catch (DuplicatedUserException d){
            try{
                 LoginController.getInstance().Login(credentials);
                 Main m= new Main();
                  m.changeScene("fxml1/register2.fxml");
            }catch(SQLException s){
                      errorMsg.setText(s.getMessage());
            }
        } catch (SQLException e) {
            errorMsg.setText(e.getMessage());

        }


    }
}

