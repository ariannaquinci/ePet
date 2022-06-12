package model;

import java.sql.*;

public class RoutinesManager {

    private RoutinesManager(){
        /**/
    }


    public static int bindParametersAndExec(CallableStatement stmt, String ... params) throws SQLException {
        int count=1;
        int ris=-1000;

        for (int i = 0; i < params.length; i++) {
            stmt.setString(i+1, params[i]);
            count++;
        }

        stmt.registerOutParameter(count, Types.INTEGER);
        executeStmt(stmt);
        ris=stmt.getInt(count);
        return ris;
    }


    public static ResultSet bindParametersAndExec(CallableStatement stmt,  byte[] blob, String ... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            stmt.setString(i+1, params[i]);
        }
        stmt.setBytes(2, blob);

        return executeStmt(stmt);
    }

    public static ResultSet executeStmt(CallableStatement stmt) throws SQLException {
        if(stmt.execute()) {
            return stmt.getResultSet();
        }else {
            return null;
        }
    }
    public static ResultSet bindParametersAndExecNoOutParam(CallableStatement stmt, String ... params) throws SQLException {

        for (int i = 0; i < params.length; i++) {
            stmt.setString(i+1, params[i]);

        }

        return executeStmt(stmt);
    }

}