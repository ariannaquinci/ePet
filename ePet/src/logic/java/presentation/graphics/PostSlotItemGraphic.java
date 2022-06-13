package presentation.graphics;

import beans.SlotAppuntamentoBean;
import controller.ManageSlotsController;
import javafx.scene.layout.Pane;

import java.sql.SQLException;

public class PostSlotItemGraphic {

    public String selectSlot(String post, String time, String place, Pane item){
        String err="";
        SlotAppuntamentoBean bean= new SlotAppuntamentoBean();
        bean.setPost(post);
        bean.setDate(time);
        bean.setAddress(place);
        try{
            ManageSlotsController.getInstance().occupaSlot(bean);
            if(item!=null){
            item.setVisible(false);}

        }catch(SQLException s){
            err=s.getMessage();
        }

        return err;

    }
}
