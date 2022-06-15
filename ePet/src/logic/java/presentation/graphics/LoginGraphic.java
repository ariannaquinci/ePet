package presentation.graphics;

import beans.ProfileBean;
import beans.UserBean;
import com.example.epet.Main;
import com.example.epet.MainMobile;
import exceptions.InvalidFieldException;
import service.SessionFacade;
import utils.UserEnum;

import java.io.IOException;
import java.sql.SQLException;

public class LoginGraphic {
    protected final void goBack(String fxml) throws IOException{
        Main m= new Main();
        m.changeScene(fxml);
    }
    protected final String checkLogin(String un,String pw) throws IOException{
        String wrongAccess="";
        try {
            UserBean credentials = new UserBean();
            credentials.setEmail(un);
            credentials.setPassword(pw);

            ProfileBean profilebean = new ProfileBean();
            profilebean.setUser(credentials.toString());

            credentials.verifyFields(un, pw);
            controller.LoginController.getInstance().login(credentials);

        }catch (InvalidFieldException i){
            wrongAccess=i.getMessage();
        }catch (SQLException s){
            wrongAccess=s.getMessage();
        }


        
        return wrongAccess;


    }
}
