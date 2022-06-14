package entities;

import exceptions.NoResultFoundException;
import persistence.dao.PostDAO;
import utils.Kind;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

public class Post {
    private String idPost;
    private String description;


    private File pic;
    private String title;
    private Kind kindOfPet;
    private String creator;
    private String region;
    private String country;
    private String city;

    public Post() {
        //default
    }

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void deletePost() throws SQLException{
        PostDAO.deletePost(this);
    }


    public void writePost() throws SQLException {
        PostDAO.writePost(this);
    }
    public File getPic() {
        return this.pic;
    }

    public void setPic(File pic) {
        this.pic = pic;
    }
    public List<Post> research() throws SQLException, NoResultFoundException {
        return PostDAO.research(this);
    }
    public List<Post> getMyPosts() throws SQLException, NoResultFoundException {
        return PostDAO.getPosts(this);
    }


}
