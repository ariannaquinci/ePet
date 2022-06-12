package entities;

import exceptions.DuplicatedUserException;
import model.dao.UserDAO;
import utils.UserEnum;

import java.sql.SQLException;

public class User {
    private String email;
    private String password;
    private UserEnum role;



    public User(String e, String pw) {
      this.email=e;
      this.password=pw;
    }
    public User() {
        //default constructor
    }

    public String getEmail(){
        return this.email;
    }
    public UserEnum getRole(){
        return this.role;
    }

    public String getPassword() {
        return this.password;
    }

    public void setEmail(String email){
        this.email=email;
    }
    public void setRole(UserEnum role){
        this.role=role;
    }
    public void setPassword(String pw){
        this.password=pw;
    }


    public void register() throws SQLException, DuplicatedUserException {

        UserDAO.register(this.getEmail(), this.getPassword(), this.getRole());
    }

    public void login()throws SQLException{
        int role=UserDAO.login(this);
        this.setRole(UserEnum.valueOf(role));
    }




}
