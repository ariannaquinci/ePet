package MODEL.DAO;

import Entities.User;
import Exceptions.DuplicatedUserException;
import MODEL.ConnectionManager;
import MODEL.RoutinesID;
import MODEL.RoutinesManager;
import utils.UserEnum;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static void register(String username, String passwd, UserEnum role) throws SQLException, DuplicatedUserException{

        CallableStatement stmt = null;
        try{
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.REGISTER);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt, username, passwd, UserEnum.UserEnumToString(role));

        } catch (SQLException e) {

                throw new DuplicatedUserException();



        } finally {
            if(stmt != null) {
                stmt.close();
            }
        }
    }

    public static int login(User usr) throws SQLException {

        CallableStatement stmt = null;
        try{
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.LOGIN, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            return RoutinesManager.bindParametersAndExec(stmt, usr.getEmail(), usr.getPassword());


        } catch (SQLException e) {
            throw new SQLException("Wrong username or password");
        } finally {
            if(stmt != null) {
                stmt.close();
            }
        }

    }
    public static void deleteUser(User usr) throws SQLException {

        CallableStatement stmt = null;
        try{
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.DELETE_USER);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt, usr.getEmail());

        } catch (SQLException e) {
            throw new SQLException("An error occured while trying to delete the selected user");
        } finally {
            if(stmt != null) {
                stmt.close();
            }
        }
    }
    public static void editPassword(User user, String pwd) throws SQLException{
        CallableStatement stmt = null;
        try{
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.EDIT_PASSWORD);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt, pwd);

        } catch (SQLException e) {
            throw new SQLException("An error occured while trying to delete the selected user");
        } finally {
            if(stmt != null) {
                stmt.close();
            }
        }
    }
}
