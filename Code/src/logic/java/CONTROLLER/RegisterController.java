package CONTROLLER;


import Beans.UserBean;

import Entities.User;
import Exceptions.DuplicatedUserException;
import Service.Entity;
import Service.Factory;
import Service.SessionFacade;
import Service.Types;

import java.sql.SQLException;

public class RegisterController {
    private static RegisterController instance = null;

    private RegisterController() {
        /*Default constructor*/
    }

    public static RegisterController getInstance() {
        if(instance == null) {
            instance = new RegisterController();
        }

        return instance;
    }

    public void Register(UserBean userbean) throws DuplicatedUserException, SQLException {


        Entity userFactory= Factory.getInstance().getObject(Types.USER);
        User usr= (User)userFactory.createObject();
        usr.setEmail(userbean.getEmail());
        usr.setPassword(userbean.getPassword());
        usr.setRole(SessionFacade.getSession().getCurrUserType());


            usr.register();




    }






    }
