package view2;

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
        MainMobile M=new MainMobile();
        M.changeScene("fxml2/StartMenuMobile.fxml");

    }

    @FXML
    protected void register() throws SQLException {

        ProfileBean bean= new ProfileBean();
        UserBean usrb= new UserBean();
        usrb.setEmail(unField.getText());
        usrb.setPassword(pwField.getText());
        usrb.setRole("SIMPLE_USER");

        bean.setSecName(lastName.getText());
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

            controller.RegisterController.getInstance().Register(usrb);
            usrb.verifySignUpSyntax(confirmPwField.getText());
            LoginController.getInstance().Login(usrb);
            ManageProfileController.getInstance().CreateProfile(bean);
            MainMobile m= new MainMobile();
            m.changeScene("fxml2/HomepageMobile.fxml");


        }catch(DuplicatedUserException d){
            try {
                LoginController.getInstance().Login(usrb);
                ManageProfileController.getInstance().CreateProfile(bean);
                MainMobile m= new MainMobile();
                m.changeScene("fxml2/HomepageMobile.fxml");
            }catch(SQLException s){
                errorMsg.setText(s.getMessage());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }catch(InvalidFieldException i){
            errorMsg.setText(i.getMessage());
        } catch (SQLException e) {
            errorMsg.setText("login failed");

        }catch(NullPointerException n){

            errorMsg.setText("fill every necessary field");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
