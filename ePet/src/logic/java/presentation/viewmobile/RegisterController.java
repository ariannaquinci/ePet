package presentation.viewmobile;

import beans.ProfileBean;

import beans.UserBean;

import controller.LoginController;

import controller.ManageProfileController;
import exceptions.DuplicatedUserException;
import exceptions.InvalidFieldException;

import com.example.epet.MainMobile;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.sql.SQLException;

public class RegisterController {

    @FXML
    private DatePicker birthday;
    @FXML
    private Label errorMsg;

    @FXML
    private PasswordField confirmPwField;

    @FXML
    private TextField lastName;

    @FXML
    private TextField name;

    @FXML
    private TextField nickname;

    @FXML
    private PasswordField pwField;

    @FXML
    private TextField telephone;

    @FXML
    private TextField unField;


    @FXML
    protected void goBack() throws IOException {
        MainMobile m=new MainMobile();
        m.changeScene("fxml2/StartMenuMobile.fxml");

    }

    @FXML
    protected void register() throws SQLException,IOException {

        ProfileBean bean= new ProfileBean();
        UserBean usrb= new UserBean();
        usrb.setEmail(unField.getText());
        usrb.setPassword(pwField.getText());
        usrb.setRole("SIMPLE_USER");

        bean.setLastName(lastName.getText());
        bean.setName(name.getText());
        bean.setUser(unField.getText());

        bean.setTelephone(telephone.getText());
        bean.setNickname(nickname.getText());

        if(birthday.getValue()!=null){
            bean.setBirthday(birthday.getValue().toString());}
        if(birthday.getValue()==null){
            errorMsg.setText("insert your birthday");
        }

        try{

            controller.RegisterController.getInstance().register(usrb);
            usrb.verifySignUpSyntax(confirmPwField.getText());
            LoginController.getInstance().login(usrb);
            ManageProfileController.getInstance().createProfile(bean);
            MainMobile m= new MainMobile();
            m.changeScene("fxml2/HomepageMobile.fxml");


        }catch(DuplicatedUserException d){
            try {
                LoginController.getInstance().login(usrb);
                ManageProfileController.getInstance().createProfile(bean);
                MainMobile m= new MainMobile();
                m.changeScene("fxml2/HomepageMobile.fxml");
            }catch(SQLException s){
                errorMsg.setText(s.getMessage());

            }
        }catch(InvalidFieldException i){
            errorMsg.setText(i.getMessage());
        } catch (SQLException e) {
            errorMsg.setText("login failed");

        }catch(NullPointerException n){

            errorMsg.setText("fill every necessary field");
        }

    }



}
