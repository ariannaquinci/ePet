package entities;

import exceptions.NoResultFoundException;
import model.dao.FavoriteDAO;
import utils.Kind;
import java.sql.SQLException;
import java.util.List;

public class Favorite {
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String r) {
        region = r;
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

    public void setPost(String p) {
        post = p;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String usr) {
        user = usr;
    }

    public List<Favorite> getFavorites() throws SQLException, NoResultFoundException {
        return FavoriteDAO.showFavorites(this);
    }
    public void insertFavorite() throws SQLException {
        FavoriteDAO.insertFavorite(this);
    }

    public void removeFromFavorites() throws SQLException{
        FavoriteDAO.removeFavorite(this);
    }
}
