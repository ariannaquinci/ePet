package Beans;

import utils.Kind;

public class FavoriteBean {
    private String Post;
    private String Description;
    private String Creator;
    private String Title;
    private Kind KindOfPet;
    private String User;
    private String Region;
    private String Country;
    private String City;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String creator) {
        Creator = creator;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Kind getKindOfPet() {
        return KindOfPet;
    }

    public void setKindOfPet(Kind kindOfPet) {
        KindOfPet = kindOfPet;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String post) {
        Post = post;
    }
}
