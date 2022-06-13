package service.factories;

import beans.SlotAppuntamentoBean;
import entities.SlotAppuntamento;
import service.Entity;

import java.util.ArrayList;
import java.util.List;

public class SlotAppuntamentoFactory implements Entity {
    @Override
    public SlotAppuntamento createObject() {
        return new SlotAppuntamento();
    }

    public List<SlotAppuntamentoBean> extractSlotBeanList(List<SlotAppuntamento> src) {
        List<SlotAppuntamentoBean> dest = new ArrayList<>();

        for(SlotAppuntamento i: src) {
            SlotAppuntamentoBean slotBean = new SlotAppuntamentoBean();
            slotBean.setDate(i.getSlot());
            slotBean.setAddress(i.getAddress());
            slotBean.setPost(i.getPost());

            dest.add(slotBean);
        }

        return dest;
    }
}
