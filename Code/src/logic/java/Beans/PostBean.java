package Beans;

import Entities.Post;
import utils.Kind;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PostBean {
    private String ID;
    private String Title;


    private File Pic;
    private String Description;
    private String Country;
    private String Region;
    private String City;
    private Kind kindOfPet;
    private String Creator;

    public PostBean(String id, String title, String description, String country, String region, String city, Kind kind, String creator){
        this.ID=id;
        this.Title=title;
        this.Description=description;
        this.City=city;
        this.Country=country;
        this.Region=region;
        this.kindOfPet=kind;
        this.Creator=creator;

    }



    public PostBean() {
        //default constructor
    }


    public File getPic() {
        return Pic;
    }

    public void setPic(File pic) {
        Pic = pic;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public Kind getKindOfPet() {
        return kindOfPet;
    }

    public void setKindOfPet(Kind kindOfPet) {
        this.kindOfPet = kindOfPet;
    }

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String creator) {
        Creator = creator;
    }


}
