package model.dao;

import entities.Appointment;
import model.ConnectionManager;
import model.RoutinesID;
import model.RoutinesManager;

import java.sql.*;

public class AppointmentDAO {
    public static void scheduleApp(Appointment app) throws SQLException {
        CallableStatement stmt = null;
        try{
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.SCHEDULE_APP);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt, String.valueOf(app.getDate()), String.valueOf(app.getUser1()), String.valueOf(app.getUser2()), app.getLocation());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("An error occured while trying to schedule appointment");
        } finally {
            if(stmt != null) {
                stmt.close();
            }
        }

    }
}
