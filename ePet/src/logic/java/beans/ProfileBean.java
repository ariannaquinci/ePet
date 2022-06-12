package beans;

import java.io.File;

public class ProfileBean {

    protected String User;
    protected String Name;
    protected String SecName;
    protected String Birthday;
    protected String Nickname;
    protected String Telephone;
    protected File Pic;


    public ProfileBean() {
        /*Default constructor*/
    }

    public ProfileBean(String u, String name, String secondName, String birthday) {
        this.User = u;
        this.Name=name;
        this.SecName=secondName;
        this.Birthday=birthday;
    }



    public void setName(String n){
        this.Name=n;
    }
    public String getName(){
        return this.Name;
    }

    public void setSecName(String n){
        this.SecName=n;
    }
    public String getSecName(){
        return this.SecName;
    }
    public String getUser() {
        return this.User;
    }

    public void setUser(String user) {
        this.User = user;
    }

    public File getPic() {
        return this.Pic;
    }

    public void setPic(File pic) {
        this.Pic = pic;
    }

    public void setBirthday(String date){this.Birthday=date;}
    public String getBirthday(){ return this.Birthday;}

    public void setNickname(String nickname) {
        this.Nickname=nickname;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getNickname() {
        return this.Nickname;
    }
}
