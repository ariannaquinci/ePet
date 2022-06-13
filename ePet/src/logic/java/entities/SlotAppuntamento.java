package entities;

import exceptions.NoResultFoundException;
import model.dao.SlotAppuntamentoDAO;

import java.sql.SQLException;
import java.util.List;

public class SlotAppuntamento {
    private String slot;
    private String post;
    private String address;
    private Boolean occupato;

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void occupySlot() throws SQLException {
        SlotAppuntamentoDAO.selectSlot(this);
    }
    public void insertSlot() throws SQLException{
        SlotAppuntamentoDAO.insertSlot(this);
    }

    public List<SlotAppuntamento> showSlots() throws SQLException, NoResultFoundException {
        return SlotAppuntamentoDAO.showSlots(this);
    }

    public void deleteSlot() throws SQLException {
        SlotAppuntamentoDAO.deleteSlot(this);
    }
}
