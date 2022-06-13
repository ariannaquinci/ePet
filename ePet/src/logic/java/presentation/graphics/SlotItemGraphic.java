package presentation.graphics;

import beans.SlotAppuntamentoBean;
import controller.ManageSlotsController;
import javafx.scene.layout.Pane;

import java.sql.SQLException;

public class SlotItemGraphic {
    public void delete(String post, String place, String time, Pane item) {
        SlotAppuntamentoBean bean = new SlotAppuntamentoBean();
        bean.setPost(post);
        bean.setAddress(place);
        bean.setDate(time);

        try {
            ManageSlotsController.getInstance().deleteSlot(bean);
            item.setVisible(false);
        }catch(SQLException s){s.getMessage();}

    }

}
