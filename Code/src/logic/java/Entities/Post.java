package Entities;

import Beans.PostBean;
import Exceptions.NoResultFoundException;
import MODEL.DAO.PostDAO;
import utils.Kind;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

public class Post {
    private String idPost;
    private String Description;

    public Post() {
        //default
    }



    private File pic;
    private String Title;
    private Kind KindOfPet;
    private String Creator;
    private String Region;
    private String Country;
    private String City;

    public Post(String u, String idPost, String description, String title, Kind kindOfPet, String region, String country, String city,File Pic){
        this.Creator=u;
        this.idPost=idPost;
        this.Description=description;
        this.Title=title;
        this.KindOfPet=kindOfPet;
        this.Region=region;
        this.Country=country;
        this.City=city;
        this.pic=Pic;
    }

    public String getIdPost(){
        return this.idPost;
    }
    public String getDescription(){
        return this.Description;
    }
    public String getTitle(){
        return this.Title;
    }
    public Kind getKindOfPet(){
        return this.KindOfPet;
    }
    public String getCreator(){
        return this.Creator;
    }
    public String getRegion(){
        return this.Region;
    }
    public String getCountry(){
        return this.Country;
    }
    public String getCity(){
        return this.City;
    }

    public void setIdPost(String id){
        this.idPost=id;
    }
    public void setDescription(String description){
        this.Description=description;
    }
    public void setTitle(String title){
        this.Title=title;
    }
    public void setKindOfPet(Kind k){
        this.KindOfPet=k;
    }
    public void setCreator(String usr){
        this.Creator=usr;
    }
    public void setRegion(String region){
        this.Region=region;
    }
    public void setCountry(String country){
        this.Country=country;
    }
    public void setCity(String city){
        this.City=city;
    }
    public void deletePost() throws SQLException{
        PostDAO.deletePost(this);
    }
    public void editPosition(String country, String city, String region) throws SQLException {
        PostDAO.editPosition(this, country, city, region);
    }

    public void editDescription(String description) throws SQLException {
        PostDAO.editDescription(this, description);
    }

    public void writePost() throws SQLException {
        PostDAO.writePost(this);
    }
    public File getPic() {
        return this.pic;
    }

    public void insert_pic() throws SQLException{
        PostDAO.add_pic(this, this.getPic());
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
