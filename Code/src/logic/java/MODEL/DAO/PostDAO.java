package MODEL.DAO;

import Entities.Post;
import Entities.User;
import Exceptions.NoResultFoundException;
import MODEL.ConnectionManager;
import MODEL.RoutinesID;
import MODEL.RoutinesManager;
import Service.Entity;
import Service.Factory;
import Service.SessionFacade;
import Service.Types;
import javafx.collections.ObservableList;
import utils.Kind;
import utils.fileToBlobConverter;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static utils.UserEnum.valueOf;

public class PostDAO {
    public static void deletePost(Post post) throws SQLException {

        CallableStatement stmt = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.DELETE_POST);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt, post.getIdPost());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("An error occured while trying to delete post");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public static void add_pic(Post post, File pic) throws SQLException{
        CallableStatement stmt = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.EDIT_POSITION);
            byte[] b = fileToBlobConverter.convertFileContentToBlob(String.valueOf(post.getPic()));
            RoutinesManager.bindParametersAndExec(stmt , b, post.getIdPost());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("An error occured while trying to adding picture to post");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public static List<Post> getPosts(Post post) throws NoResultFoundException, SQLException {

        ResultSet res = null;
        CallableStatement stmt = null;
        List<Post> list = new ArrayList<>();

        try {
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.GET_POSTS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            res = RoutinesManager.bindParametersAndExecNoOutParam(stmt, post.getCreator());

            processResearch(res, list);
        } catch (SQLException e) {
            throw new NoResultFoundException();

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return list;

    }
    public static void editPosition(Post post, String country, String city, String region) throws SQLException {

        CallableStatement stmt = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.EDIT_POSITION);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt, post.getIdPost(), country, city, region);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("An error occured while trying to delete post");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public static void editDescription(Post post, String description) throws SQLException {

        CallableStatement stmt = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.EDIT_DESCRIPTION);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt, post.getIdPost(), description);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("An error occured while trying to delete post");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public static void writePost(Post post) throws SQLException {

        CallableStatement stmt = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.WRITE_POST, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            if(post.getPic()!=null) {
                byte[] b = fileToBlobConverter.convertFileContentToBlob(String.valueOf(post.getPic()));
                RoutinesManager.bindParametersAndExec(stmt, b, post.getCreator(), post.getDescription(), post.getRegion(), post.getTitle(), String.valueOf(post.getKindOfPet()), post.getCountry(), post.getCity());
            }
            else{
                RoutinesManager.bindParametersAndExecNoOutParam(stmt, post.getCreator(), post.getDescription(), post.getRegion(), post.getTitle(), String.valueOf(post.getKindOfPet()), post.getCountry(), post.getCity());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("An error occured while trying to write post");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }


    public static void processResearch(ResultSet res, List<Post> list) throws SQLException, NoResultFoundException{
        if(!res.first()){
            throw new NoResultFoundException();
        }
        res.first();
        Entity postFactory= Factory.getInstance().getObject(Types.POST);
        do{
            Post post=(Post)postFactory.createObject();
            post.setIdPost(res.getString("idpost"));
            post.setCity(res.getString("city"));
            post.setCountry(res.getString("country"));
            post.setRegion(res.getString("region"));
            post.setCreator(res.getString("creator"));
            post.setDescription(res.getString("description"));
            post.setKindOfPet(Kind.valueOf(res.getString("KindOfPet")));
            post.setPic((File) res.getObject("pic"));
            post.setTitle(res.getString("title"));
            list.add(post);
        }while(res.next());
        res.close();
    }
    public static List<Post> research(Post post) throws SQLException, NoResultFoundException {

        ResultSet res = null;
        CallableStatement stmt = null;
        List<Post> list = new ArrayList<>();

        try {
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.RESEARCH, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            res = RoutinesManager.bindParametersAndExecNoOutParam(stmt, String.valueOf(post.getKindOfPet()), post.getCity(), post.getCountry(), post.getRegion());

            processResearch(res, list);
        } catch (SQLException e) {
            throw new NoResultFoundException();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return list;

    }


}