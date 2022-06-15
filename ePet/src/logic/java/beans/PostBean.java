package beans;



import utils.Kind;

import java.io.File;

public class PostBean {
    private String id;
    private String title;


    private File pic;
    private String description;
    private String country;
    private String region;
    private String city;
    private Kind kindOfPet;
    private String creator;

    public PostBean(){
        //default constructor

    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public File getPic() {
        return pic;
    }

    public void setPic(File pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Kind getKindOfPet() {
        return kindOfPet;
    }

    public void setKindOfPet(Kind kindOfPet) {
        this.kindOfPet = kindOfPet;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
