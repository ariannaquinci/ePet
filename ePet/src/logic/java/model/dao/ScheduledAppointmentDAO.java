package model.dao;

import entities.ScheduledAppointment;
import exceptions.NoResultFoundException;
import model.ConnectionManager;
import model.RoutinesID;
import model.RoutinesManager;
import service.Entity;
import service.Factory;
import service.Types;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ScheduledAppointmentDAO {

    public static void deleteApp(ScheduledAppointment sapp) throws SQLException{
        CallableStatement stmt = null;
        try{
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.DELETE_APP);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt, sapp.getScheduledAppID());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("An error occured while trying to delete appointment");
        } finally {
            if(stmt != null) {
                stmt.close();
            }
        }
    }
    private static void processResearch(ResultSet res, List<ScheduledAppointment> list) throws SQLException, NoResultFoundException {
        if (!res.first()){
            throw new NoResultFoundException();
        }

        res.first();

        Entity factorySchedApp = Factory.getInstance().getObject(Types.SCHEDULEDAPPOINTMENT);


        do {
            ScheduledAppointment schedApp = (ScheduledAppointment) factorySchedApp.createObject();

            schedApp.setScheduledAppID(res.getString("idscheduledAppointment"));
            schedApp.setLocation(res.getString("location"));
            schedApp.setData(String.valueOf(res.getTimestamp("dataApp", Calendar.getInstance(Locale.ITALIAN)).toLocalDateTime()));
            schedApp.setUser1(res.getString("User1"));
            schedApp.setUser2(res.getString("User2"));



            list.add(schedApp);
        }while(res.next());

        res.close();

    }
    public static List<ScheduledAppointment> seeScheduledApp(ScheduledAppointment sapp) throws NoResultFoundException, SQLException {
        List<ScheduledAppointment> list=new ArrayList<>();
        ResultSet res=null;
        CallableStatement stmt = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.SEE_SCHEDULED_APP, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            res=RoutinesManager.bindParametersAndExecNoOutParam(stmt,  sapp.getUser1());
            processResearch(res, list);
        } catch (SQLException e) {
            throw new NoResultFoundException();
        }finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return list;
    }
}
