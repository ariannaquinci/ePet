package model.dao;

import entities.Post;
import exceptions.NoResultFoundException;
import model.ConnectionManager;
import model.RoutinesID;
import model.RoutinesManager;
import service.Entity;
import service.Factory;
import service.Types;
import utils.Kind;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static utils.UserEnum.valueOf;

public class PostDAO {
    private PostDAO(){}
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

    public static void writePost(Post post) throws SQLException {

        CallableStatement stmt = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.WRITE_POST, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                RoutinesManager.bindParametersAndExecNoOutParam(stmt, post.getCreator(), post.getDescription(), post.getRegion(), post.getTitle(), String.valueOf(post.getKindOfPet()), post.getCountry(), post.getCity());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("An error occured while trying to write post");
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