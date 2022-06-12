package beans;

import utils.Kind;

public class FavoriteBean {
    private String post;
    private String description;
    private String creator;
    private String title;
    private Kind kindOfPet;
    private String user;
    private String region;
    private String country;
    private String city;

    public String getDescription() {
        return description;
    }

    public void setDescription(String des) {
        description = des;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String c) {
        creator = c;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public Kind getKindOfPet() {
        return kindOfPet;
    }

    public void setKindOfPet(Kind kind) {
        kindOfPet = kind;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String usr) {
        user = usr;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String reg) {
        region = reg;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String c) {
        country = c;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String c) {
        city = c;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String p) {  post = p; }
}
