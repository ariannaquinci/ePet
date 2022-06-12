package controller;

import beans.SlotAppuntamentoBean;
import entities.SlotAppuntamento;
import exceptions.NoResultFoundException;
import service.Entity;
import service.factories.SlotAppuntamentoFactory;
import service.Factory;
import service.Types;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public class ManageSlotsController {
    private static ManageSlotsController instance=null;
    public static  ManageSlotsController getInstance(){
        if(instance==null){instance=new ManageSlotsController();}
        return instance;
    }

    public void Occupa_slot(SlotAppuntamentoBean bean) throws SQLException{
        Entity factorySlot=Factory.getInstance().getObject(Types.SLOTAPPUNTAMENTO);
        SlotAppuntamento slot=(SlotAppuntamento) factorySlot.createObject();
        slot.setSlot(bean.getDate());
        slot.setPost(bean.getPost());
        slot.setAddress(bean.getAddress());

            slot.occupy_slot();

    }
    public void Insert_slot(SlotAppuntamentoBean bean) throws SQLException{
        Entity factorySlot= Factory.getInstance().getObject(Types.SLOTAPPUNTAMENTO);
        SlotAppuntamento slot=(SlotAppuntamento) factorySlot.createObject();
        slot.setSlot(bean.getDate());
        slot.setAddress(bean.getAddress());
        slot.setPost(bean.getPost());
        slot.insertSlot();

    }

    private ObservableList<SlotAppuntamentoBean> entityToBean(List<SlotAppuntamento> src){
        Entity factory= Factory.getInstance().getObject(Types.SLOTAPPUNTAMENTO);
        ObservableList<SlotAppuntamentoBean> dest= FXCollections.observableArrayList();
        for(SlotAppuntamentoBean i: ((SlotAppuntamentoFactory)factory).extractSlotBeanList(src)){
            dest.add(i);
        }
        return dest;
    }
    public ObservableList<SlotAppuntamentoBean> showSlots(SlotAppuntamentoBean bean) throws NoResultFoundException {
        Entity factorySlot=Factory.getInstance().getObject(Types.SLOTAPPUNTAMENTO);
        SlotAppuntamento slot= (SlotAppuntamento)factorySlot.createObject();
        slot.setPost(bean.getPost());
        try {
            List<SlotAppuntamento> l = slot.showSlots();
            return entityToBean(l);
        }catch(SQLException s){
            throw new NoResultFoundException();
        }

    }

    public void deleteSlot(SlotAppuntamentoBean bean) {
        Entity factorySlot=Factory.getInstance().getObject(Types.SLOTAPPUNTAMENTO);
        SlotAppuntamento slot=(SlotAppuntamento) factorySlot.createObject();
        slot.setPost(bean.getPost());
        slot.setSlot(bean.getDate());
        try{
            slot.deleteSlot();
        }catch(SQLException e){throw new RuntimeException();}
    }
}
