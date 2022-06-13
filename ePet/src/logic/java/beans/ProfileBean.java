package beans;

import java.io.File;

public class ProfileBean {

    protected String user;
    protected String name;
    protected String lastName;
    protected String birthday;
    protected String nickname;
    protected String telephone;
    protected File pic;


    public ProfileBean(String u, String n, String lName, String bd) {
        this.user = u;
        this.name=n;
        this.lastName=lName;
        this.birthday=bd;
    }
    public ProfileBean(){
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public File getPic() {
        return pic;
    }

    public void setPic(File pic) {
        this.pic = pic;
    }
}
