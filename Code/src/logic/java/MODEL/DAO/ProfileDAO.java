package MODEL.DAO;

import Entities.Post;
import Entities.Profile;
import Exceptions.NoResultFoundException;
import MODEL.ConnectionManager;
import MODEL.RoutinesID;
import MODEL.RoutinesManager;
import Service.Entity;
import Service.Factory;
import Service.Types;
import utils.Kind;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.sql.rowset.serial.SerialBlob;

public class ProfileDAO {
    public static Boolean CreateProfile(Profile profile) throws SQLException{
        CallableStatement stmt = null;
       try{
           Connection conn = ConnectionManager.getConnection();
           stmt = conn.prepareCall(RoutinesID.CREATE_PROFILE);

           RoutinesManager.bindParametersAndExecNoOutParam(stmt, profile.getUser(), profile.getName(), profile.getSecondName(),  profile.getBirthday(),profile.getTelephone(),profile.getNickname());


       } finally {
           if(stmt != null) {
               stmt.close();
           }
       }
        return true;
    }
    public static void editProfilePicture(Profile p, String pic) throws SQLException {
        CallableStatement stmt = null;
        try{
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.EDIT_PROFILE_PIC);
            byte[] fileContent = Files.readAllBytes(Paths.get(pic));

            RoutinesManager.bindParametersAndExec(stmt, fileContent, String.valueOf(p.getUser()));

        } catch (IOException e) {
            throw new RuntimeException(e);  //per readAllBytes
        } finally {
            if(stmt != null) {
                stmt.close();
            }
        }

    }

    public static void editTelephoneNumber(Profile p, String tel) throws SQLException {
        CallableStatement stmt = null;
        try{
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.EDIT_TEL_NUM);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt, String.valueOf(p.getUser()),  tel);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("An error occured while trying to edit telephone number");
        } finally {
            if(stmt != null) {
                stmt.close();
            }
        }

    }

    public static void editNickname(Profile p, String nickname) throws SQLException {
        CallableStatement stmt = null;
        try{
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.EDIT_NICKNAME,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt, String.valueOf(p.getUser()), nickname);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("An error occured while trying to edit nickname");
        } finally {
            if(stmt != null) {
                stmt.close();
            }
        }

    }

    public static void processResearch(ResultSet res, List<Profile> list) throws SQLException, NoResultFoundException{
        if(!res.first()){
            throw new NoResultFoundException();
        }
        res.first();
        Entity profFactory= Factory.getInstance().getObject(Types.PROFILE);
        do{
           Profile prof=(Profile)profFactory.createObject();
           prof.setUser(res.getString("utente"));
           prof.setBirthday(String.valueOf(res.getDate("DataNascita").toLocalDate()));
           prof.setName(res.getString("nome"));
           prof.setSecName(res.getString("cognome"));
           prof.setTelephone(res.getString("ContattoTelefonico"));
           prof.setNickname(res.getString("nickname"));

            list.add(prof);
        }while(res.next());
        res.close();
    }
    public static List<Profile> getProfile(Profile prof) throws NoResultFoundException, SQLException {
        ResultSet res = null;
        CallableStatement stmt = null;
        List<Profile> list= new ArrayList<>();

        try {
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.GET_PROFILE, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            res = RoutinesManager.bindParametersAndExecNoOutParam(stmt, prof.getUser());

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

    public static void deleteProfile(Profile prof) throws SQLException {
        CallableStatement stmt = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.DELETE_USER);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt, prof.getUser());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("An error occured while trying to delete profile");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}
