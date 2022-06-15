package beans;

import exceptions.DuplicatedUserException;
import exceptions.InvalidFieldException;
import service.SessionFacade;
import utils.UserEnum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserBean {

    private String email;
    private String password;
    private String role;
    public UserBean(String email, String pw){
        this.email=email;
        this.password=pw;

    }

    public UserBean() {
        //default constructor
    }

    public String getEmail(){
        return this.email;
    }
    public String getRole(){
        return this.role;
    }

    public String getPassword() {
        return this.password;
    }

    public void setEmail(String email){
        this.email=email;
    }
    public void setRole(String role){
        if(SessionFacade.getSession().getCurrUserType() == null){
            SessionFacade.getSession().setCurrUserType(UserEnum.stringToUserEnum(role));
            this.role=role;
        }

    }
    public void setPassword(String pw){
        this.password=pw;
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
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()) {
            throw new InvalidFieldException("The email address is not valid");
        }
    }

    public void verifyEqualFields(String pwd) throws InvalidFieldException {
        if(!pwd.equals(this.password)) {
            throw new InvalidFieldException("Passwords do not match");
        }
    }

    public void verifySignUpSyntax(String confpwd) throws InvalidFieldException, DuplicatedUserException {
        verifyFields(this.email, confpwd);
        verifyEqualFields(confpwd);
        verifySyntax();


    }


}
