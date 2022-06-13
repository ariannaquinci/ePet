package entities;

import exceptions.NoResultFoundException;
import model.dao.ProfileDAO;

import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Profile {
    private String user;
    private String name;
    private String lastName;
    private String birthday;
    private File profilePicture;
    private String telephone;
    private String nickname;

    public Profile(){
        //default constructor
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public File getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(File profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void createProfile() throws SQLException {
        ProfileDAO.createProfile(this);
    }



    public List<Profile> getProfile() throws SQLException, NoResultFoundException {
         return ProfileDAO.getProfile(this);
    }
    public void deleteProfile() throws SQLException {
        ProfileDAO.deleteProfile(this);
    }
}
