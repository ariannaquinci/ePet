package model.dao;

import entities.User;
import exceptions.DuplicatedUserException;
import model.ConnectionManager;
import model.RoutinesID;
import model.RoutinesManager;
import utils.UserEnum;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private UserDAO(){}
    public static void register(String username, String passwd, UserEnum role) throws SQLException, DuplicatedUserException{

        CallableStatement stmt = null;
        try{
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.REGISTER);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt, username, passwd, UserEnum.userEnumToString(role));

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

}
