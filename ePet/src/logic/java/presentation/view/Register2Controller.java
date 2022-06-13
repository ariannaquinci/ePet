package presentation.view;

import beans.ProfileBean;
import controller.ManageProfileController;
import service.SessionFacade;
import com.example.epet.MainComputer;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class Register2Controller {

    @FXML
    private TextField nameField;
    @FXML
    private Label errorMsg;
    @FXML
    private TextField secNameField;

    @FXML
    private DatePicker bd;
    @FXML
    private TextField nickname;

    @FXML
    private TextField phone;

    public Register2Controller() {
        //default constructor

    }

    @FXML
    protected void goToRegister() throws IOException{
        MainComputer m=new MainComputer();
        m.changeScene("fxml1/register1.fxml");


    }
    @FXML
    protected void createProfile() throws IOException{

        ProfileBean bean = new ProfileBean();

        bean.setName(nameField.getText());
        bean.setLastName(secNameField.getText());
        if(bd.getValue()!=null){
            bean.setBirthday(bd.getValue().toString());}
        if(bd.getValue()==null){
            errorMsg.setText("insert your birthday");
        }
        bean.setNickname(nickname.getText());
        bean.setTelephone(phone.getText());
        bean.setUser(SessionFacade.getSession().getID());
        try {

            ManageProfileController.getInstance().createProfile(bean);
            MainComputer m= new MainComputer();
            m.changeScene("fxml1/homepage.fxml");
        }catch(SQLException s){
            errorMsg.setText(s.getMessage());

        }

    }


    }
