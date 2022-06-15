package beans;


public class ProfileBean {

    protected String userB;
    protected String nameB;
    protected String lastNameB;
    protected String birthdayB;
    protected String nicknameB;
    protected String telephoneB;



    public ProfileBean(String u, String n, String lName, String bd) {
        this.userB = u;
        this.nameB=n;
        this.lastNameB=lName;
        this.birthdayB=bd;
    }
    public ProfileBean(){
        //default constructor
    }

    public String getUser() {
        return userB;
    }

    public void setUser(String user) {
        this.userB = user;
    }

    public String getName() {
        return nameB;
    }

    public void setName(String name) {
        this.nameB = name;
    }

    public String getLastName() {
        return lastNameB;
    }

    public void setLastName(String lastName) {
        this.lastNameB = lastName;
    }

    public String getBirthday() {
        return birthdayB;
    }

    public void setBirthday(String birthday) {
        this.birthdayB = birthday;
    }

    public String getNickname() {
        return nicknameB;
    }

    public void setNickname(String nickname) {
        this.nicknameB = nickname;
    }

    public String getTelephone() {
        return telephoneB;
    }

    public void setTelephone(String telephone) {
        this.telephoneB = telephone;
    }

}
