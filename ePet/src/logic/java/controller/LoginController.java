package controller;

import beans.UserBean;
import entities.User;

import service.Entity;
import service.Factory;
import service.SessionFacade;
import service.Types;

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
