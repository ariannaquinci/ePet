package CONTROLLER;

import Beans.UserBean;
import Entities.User;

import Service.Entity;
import Service.Factory;
import Service.SessionFacade;
import Service.Types;
import utils.Scenes;

import javax.security.auth.login.FailedLoginException;
import java.sql.SQLException;

public class LoginController {
    /*applico Singleton*/
    private static LoginController instance = null;


    public static LoginController getInstance() {
        if(instance == null) {
            instance = new LoginController();
        }

        return instance;
    }

    public void Login(UserBean bean) throws SQLException {

            Entity factoryUsr = Factory.getInstance().getObject(Types.USER);
            User user = (User)factoryUsr.createObject();
            user.setEmail(bean.getEmail());
            user.setPassword(bean.getPassword());


            try {
                user.login();
                SessionFacade.getSession().setCurrUserType(user.getRole());
                SessionFacade.getSession().setID(user.getEmail());


            }catch (SQLException s) {
                throw new SQLException("Login failed, check your credentials or Sign Up.");
            }

    }
}
