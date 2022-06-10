package MODEL.DAO;

import Beans.FavoriteBean;
import Entities.Favorite;
import Entities.Post;
import Entities.User;
import Exceptions.NoResultFoundException;
import MODEL.ConnectionManager;
import MODEL.RoutinesID;
import MODEL.RoutinesManager;
import Service.Entity;
import Service.Factory;
import Service.Types;
import utils.Kind;

import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static MODEL.DAO.PostDAO.processResearch;

public class FavoriteDAO {
    public static void insert_favorite(Favorite fav) throws SQLException {

        CallableStatement stmt = null;
        try{
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.INSERT_FAVORITE, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt, fav.getUser(), fav.getPost());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("An error occured while trying to insert favorite");
        } finally {
            if(stmt != null) {
                stmt.close();
            }
        }
    }

    public static void remove_favorite(Favorite f) throws SQLException {

        CallableStatement stmt = null;
        try{
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.REMOVE_FAVORITE);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt,  f.getUser(),f.getPost());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("An error occured while trying to remove favorite");
        } finally {
            if(stmt != null) {
                stmt.close();
            }
        }
    }

    public static List<Favorite> show_favorites(Favorite fav) throws SQLException, NoResultFoundException {

        ResultSet res = null;
        CallableStatement stmt = null;
        List<Favorite> list = new ArrayList<>();

        try {
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.SHOW_FAVORITES, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            res=RoutinesManager.bindParametersAndExecNoOutParam(stmt, fav.getUser());

            processResearch(res, list);

        } catch (SQLException e) {
            throw new NoResultFoundException();}

       finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        //fino qui tutto ok
        return list;
       }
    public static void processResearch(ResultSet res, List<Favorite> list) throws SQLException, NoResultFoundException{
        if(!res.first()){
            throw new NoResultFoundException();
        }
        res.first();
        Entity favFactory= Factory.getInstance().getObject(Types.FAVORITE);
        do{
            Favorite fav= (Favorite) favFactory.createObject();
           fav.setPost(res.getString("post"));

            fav.setCity(res.getString("City"));

            fav.setCountry(res.getString("Country"));

            fav.setRegion(res.getString("Region"));

            fav.setCreator(res.getString("Creator"));

            fav.setDescription(res.getString("Description"));

            fav.setKindOfPet(Kind.valueOf(res.getString("KindOfPet")));

            fav.setUser(res.getString("utente"));

            fav.setTitle(res.getString("Title"));

            list.add(fav);
        }while(res.next());
        res.close();
    }

}