package beans;

import exceptions.DuplicatedUserException;
import exceptions.InvalidFieldException;
import service.SessionFacade;
import utils.UserEnum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserBean {

    private String Email;
    private String Password;
    private String Role;
    public UserBean(String email, String pw){
        this.Email=email;
        this.Password=pw;

    }

    public UserBean() {
        //default constructor
    }

    public String getEmail(){
        return this.Email;
    }
    public String getRole(){
        return this.Role;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setEmail(String email){
        this.Email=email;
    }
    public void setRole(String role){
        if(SessionFacade.getSession().getCurrUserType() == null){
            SessionFacade.getSession().setCurrUserType(UserEnum.stringToUserEnum(role));
            this.Role=role;
        }

    }
    public void setPassword(String pw){
        this.Password=pw;
    }

    public boolean checkFieldValidity(String s){return (s==null||s.equals(""));}
    public void verifyFields(String...params) throws InvalidFieldException {
        for (int i = 0; i < params.length; i++) {
            if (checkFieldValidity(params[i])) {
                throw new InvalidFieldException("Please, fill out every field");
            }
        }
    }

    public void verifySyntax() throws InvalidFieldException {
        Pattern pattern = Pattern.compile("^.+@.+\\..+$");
        Matcher matcher = pattern.matcher(Email);
        if(!matcher.matches()) {
            throw new InvalidFieldException("The email address is not valid");
        }
    }

    public void verifyEqualFields(String pwd) throws InvalidFieldException {
        if(!pwd.equals(this.Password)) {
            throw new InvalidFieldException("Passwords do not match");
        }
    }

    public void verifySignUpSyntax(String confpwd) throws InvalidFieldException, DuplicatedUserException {
        verifyFields(this.Email, confpwd);
        verifyEqualFields(confpwd);
        verifySyntax();


    }


}
