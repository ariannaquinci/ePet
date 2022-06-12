package controller;


import beans.UserBean;

import entities.User;
import exceptions.DuplicatedUserException;
import service.Entity;
import service.Factory;
import service.SessionFacade;
import service.Types;

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
