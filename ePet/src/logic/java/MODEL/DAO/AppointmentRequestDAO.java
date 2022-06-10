package MODEL.DAO;

import Entities.AppointmentRequest;
import Entities.Post;
import Exceptions.NoResultFoundException;
import MODEL.ConnectionManager;
import MODEL.RoutinesID;
import MODEL.RoutinesManager;
import Service.Entity;
import Service.Factory;
import Service.Types;


import java.sql.*;

import java.util.*;


public class AppointmentRequestDAO {

    private static void processResearch(ResultSet res, List<AppointmentRequest> list) throws SQLException, NoResultFoundException {
        if (!res.first()) {
            throw new NoResultFoundException("No appointement requests to show");
        }

        res.first();

        Entity factoryAppReq = Factory.getInstance().getObject(Types.APPOINTMENTREQUEST);

        do {
            AppointmentRequest appReq = (AppointmentRequest) factoryAppReq.createObject();
            appReq.setApplicant(res.getString("Applicant"));
            appReq.setPost(res.getString("Post"));

            appReq.setDate(String.valueOf(res.getTimestamp("date", Calendar.getInstance(Locale.ITALIAN)).toLocalDateTime()));
            appReq.setLocation(res.getString("place"));


            list.add(appReq);
        } while (res.next());
        res.close();
    }

    public static void denyAppReq(AppointmentRequest appReq) throws SQLException {

        CallableStatement stmt = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.DENY_APP_REQ);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt, appReq.getPost(),appReq.getApplicant());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("An error occured while trying to deny appointment request");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

        public static List<AppointmentRequest> showAppRequests(AppointmentRequest A) throws SQLException,NoResultFoundException{
             CallableStatement stmt = null;
             ResultSet res= null;
             List<AppointmentRequest> list=new ArrayList<>();
              try{
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.SHOW_APP_REQUESTS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            res=RoutinesManager.bindParametersAndExecNoOutParam(stmt, A.getReceiver());
            processResearch(res, list);


            } catch (SQLException e) {

                    throw new NoResultFoundException("No appointment requests to show");
            } finally {
            if(stmt != null) {
                stmt.close();
            }
        }

    return list;
    }

    public static void acceptAppReq(AppointmentRequest appReq) throws SQLException{
        CallableStatement stmt = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.SCHEDULE_APP);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt, appReq.getDate(), appReq.getReceiver(),appReq.getApplicant());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("An error occured while trying to accept appointment request");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}
