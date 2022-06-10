package CONTROLLER;

import Beans.PostBean;
import Beans.SlotAppuntamentoBean;
import Entities.Post;
import Entities.SlotAppuntamento;
import Exceptions.NoResultFoundException;
import Service.Entity;
import Service.Factories.PostFactory;
import Service.Factories.SlotAppuntamentoFactory;
import Service.Factory;
import Service.Types;
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
