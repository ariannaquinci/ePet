package MODEL.DAO;

import Entities.Post;
import Entities.SlotAppuntamento;
import Exceptions.NoResultFoundException;
import MODEL.ConnectionManager;
import MODEL.RoutinesID;
import MODEL.RoutinesManager;
import Service.Entity;
import Service.Factory;
import Service.SessionFacade;
import Service.Types;
import utils.Kind;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class SlotAppuntamentoDAO {

    public static void DeleteSlot(SlotAppuntamento S) throws SQLException{
        CallableStatement stmt = null;
        try{
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.DELETE_SLOT);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt, S.getSlot(), String.valueOf(S.getPost()));

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("An error occured while trying to delete slot");
        } finally {
            if(stmt != null) {
                stmt.close();
            }
        }
    }
    public static void InsertSlot(SlotAppuntamento s) throws SQLException {
        CallableStatement stmt = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.INSERT_SLOT);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt, s.getSlot(), s.getPost(), s.getAddress());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("An error occured while trying to insert a new slot");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

    }


    public static void selectSlot(SlotAppuntamento slot) throws SQLException{

        CallableStatement stmt = null;
        try{
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.SELECT_SLOT);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt, SessionFacade.getSession().getID(), slot.getSlot(), slot.getPost());

        } catch (SQLException e) {

            throw new SQLException("An error occured while trying to request appointment");
        } finally {
            if(stmt != null) {
                stmt.close();
            }
        }
    }

    public static List<SlotAppuntamento> showSlots(SlotAppuntamento slot) throws NoResultFoundException, SQLException {
        ResultSet res = null;
        CallableStatement stmt = null;
        List<SlotAppuntamento> list = new ArrayList<>();

        try {
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.SHOW_SLOTS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            res = RoutinesManager.bindParametersAndExecNoOutParam(stmt, slot.getPost());

            processResearch(res, list);
        } catch (SQLException | NoResultFoundException e) {
            throw new NoResultFoundException();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return list;
    }

    public static void processResearch(ResultSet res, List<SlotAppuntamento> list) throws SQLException, NoResultFoundException{
        if(!res.first()){
            throw new NoResultFoundException();
        }
        res.first();
        Entity slotFactory= Factory.getInstance().getObject(Types.SLOTAPPUNTAMENTO);
        do{
            SlotAppuntamento slot=(SlotAppuntamento) slotFactory.createObject();
            slot.setPost(res.getString("post"));
            slot.setAddress(res.getString("address"));
            slot.setSlot(String.valueOf(res.getTimestamp("slot", Calendar.getInstance(Locale.ITALIAN)).toLocalDateTime()));
            list.add(slot);
        }while(res.next());
        res.close();
    }

    public static void deleteSlot(SlotAppuntamento slot) throws SQLException {
        CallableStatement stmt = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            stmt = conn.prepareCall(RoutinesID.DELETE_SLOT);
            RoutinesManager.bindParametersAndExecNoOutParam(stmt, slot.getSlot(), slot.getPost());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("An error occured while trying to delete slot");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}

