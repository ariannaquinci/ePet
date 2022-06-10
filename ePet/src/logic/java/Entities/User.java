package Entities;

import Exceptions.DuplicatedUserException;
import MODEL.DAO.UserDAO;
import utils.UserEnum;

import javax.security.auth.login.FailedLoginException;
import java.sql.SQLException;

public class User {
    private String Email;
    private String Password;
    private UserEnum Role;

    public User(String e, String pwd){
        this.Email=e;
        this.Password=pwd;
    }

    public User() {
        //default constructor
    }

    public String getEmail(){
        return this.Email;
    }
    public UserEnum getRole(){
        return this.Role;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setEmail(String email){
        this.Email=email;
    }
    public void setRole(UserEnum role){
        this.Role=role;
    }
    public void setPassword(String pw){
        this.Password=pw;
    }


    public void register() throws SQLException, DuplicatedUserException {

        UserDAO.register(this.getEmail(), this.getPassword(), this.getRole());
    }

    public void login()throws SQLException{
        int role=UserDAO.login(this);
        this.setRole(UserEnum.valueOf(role));
    }




}
