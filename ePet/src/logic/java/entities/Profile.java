package entities;

import exceptions.NoResultFoundException;
import model.dao.ProfileDAO;

import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Profile {
    private String user;
    private String Name;
    private String SecondName;
    private String Birthday;
    private File ProfilePicture;
    private String Telephone;
    private String Nickname;

    public Profile(){
        //default constructor
    }
    public Profile(String u, String name, String secondName, LocalDate birthday){
        this.user=u;
        this.Name=name;
        this.SecondName=secondName;
        this.Birthday= String.valueOf(birthday);
    }

    public String getUser(){
        return this.user;
    }
    public String getName(){
        return this.Name;
    }
    public String getSecondName(){
        return this.SecondName;
    }

    public String getBirthday() {
        return this.Birthday;
    }
    public File getProfilePicture(){
        return this.ProfilePicture;
    }
    public String getTelephone(){
        return this.Telephone;
    }
    public String getNickname(){
        return this.Nickname;
    }

    public void setUser(String u){
        this.user=u;
    }
    public void setName(String n){
        this.Name=n;
    }
    public void setSecName(String sn){
        this.SecondName=sn;
    }

    public void setBirthday(String b) {
        this.Birthday= b;
    }
    public void setProfilePicture(File pic){
        this.ProfilePicture=pic;
    }
    public void setTelephone(String t){
        this.Telephone=t;
    }
    public void setNickname(String n){
        this.Nickname=n;
    }
    public void createProfile() throws SQLException {
        ProfileDAO.CreateProfile(this);
    }



    public List<Profile> getProfile() throws SQLException, NoResultFoundException {
         return ProfileDAO.getProfile(this);
    }
    public void deleteProfile() throws SQLException {
        ProfileDAO.deleteProfile(this);
    }
}
