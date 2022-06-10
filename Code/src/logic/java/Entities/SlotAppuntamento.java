package Entities;

import Exceptions.NoResultFoundException;
import MODEL.DAO.SlotAppuntamentoDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class SlotAppuntamento {
    private String Slot;
    private String post;
    private String Address;
    private Boolean Occupato;

    public String getSlot() {
        return String.valueOf(this.Slot);
    }

    public void setSlot(String slot) {
        Slot = slot;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getAddress() {
        return this.Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public Boolean getOccupato() {
        return this.Occupato;
    }

    public void setOccupato(Boolean occupato) {
        this.Occupato = occupato;
    }

    public void occupy_slot() throws SQLException {
        SlotAppuntamentoDAO.selectSlot(this);
    }
    public void insertSlot() throws SQLException{
        SlotAppuntamentoDAO.InsertSlot(this);
    }

    public List<SlotAppuntamento> showSlots() throws SQLException, NoResultFoundException {
        return SlotAppuntamentoDAO.showSlots(this);
    }

    public void deleteSlot() throws SQLException {
        SlotAppuntamentoDAO.deleteSlot(this);
    }
}
