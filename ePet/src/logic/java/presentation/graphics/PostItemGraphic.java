package presentation.graphics;

import beans.PostBean;
import beans.SlotAppuntamentoBean;
import com.example.epet.MainComputer;
import com.example.epet.MainMobile;
import controller.ManagePostController;
import controller.ManageSlotsController;
import exceptions.NoResultFoundException;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import presentation.view.PostItemController;
import presentation.view.SlotController;
import presentation.viewmobile.SlotItemController;
import service.SessionFacade;
import utils.SlotItem;

import java.io.IOException;
import java.sql.SQLException;

public class PostItemGraphic {



    protected  final String addSlot(String id,String address, String time) {
        String errorMsg="";
        SlotAppuntamentoBean slotBean = new SlotAppuntamentoBean();
        slotBean.setPost(id);
        slotBean.setAddress(address);
        slotBean.setDate(time);
        try {
            errorMsg="Slot added";
            ManageSlotsController.getInstance().insertSlot(slotBean);
        }catch(SQLException s){
           errorMsg=s.getMessage();
        }
        return errorMsg;

    }



    protected final  String showSlots(String id, PostItemGraphic p) throws IOException{
        String noResults="";
        SlotAppuntamentoBean bean= new SlotAppuntamentoBean();
        bean.setPost(id);
        try{

            initResults(ManageSlotsController.getInstance().showSlots(bean), p);


        }catch(NoResultFoundException n) {
            noResults=n.getMessage();
        }
        return noResults;

    }



    private void initResults(ObservableList<SlotAppuntamentoBean> list,PostItemGraphic p) throws IOException, NoResultFoundException {

        if(p.getClass()==presentation.view.PostItemController.class){
            HBox resultsBox=((presentation.view.PostItemController)p).getResultsBox();
            resultsBox.getChildren().clear();


            for(SlotAppuntamentoBean i: list) {
                MainComputer m= new MainComputer();
                SlotItem s= m.getSlotItem("fxml1/slotItem.fxml");
                SlotController slotControl=s.getController();
                Pane pane=s.getPane();

                slotControl.setData( i.getDate(), i.getAddress(), i.getPost());
                resultsBox.getChildren().add(pane);
                resultsBox.setMargin(pane,new Insets(10,10,10,10));



            }
        }
        else if(p.getClass()==presentation.viewmobile.PostItemController.class){

            HBox resultsBox=((presentation.viewmobile.PostItemController)p).getResultsBox();
            resultsBox.getChildren().clear();

            for(SlotAppuntamentoBean i: list){
                MainMobile m= new MainMobile();
                SlotItem s= m.getSlotItem("fxml2/slotItemMobile.fxml");
                SlotItemController slotControl=s.getController2();
                Pane pane=s.getPane();

                slotControl.setData( i.getDate(), i.getAddress(), i.getPost());
                resultsBox.getChildren().add(pane);
                resultsBox.setMargin(pane,new Insets(10,10,10,10));}

        }


    }


    protected final boolean deletePost(String id){

        Boolean retval=false;
        PostBean bean = new PostBean();
        bean.setId(id);
        bean.setCreator(SessionFacade.getSession().getID());
        try{
            ManagePostController.getInstance().deletePost(bean);
            retval=true;
        }
        catch(SQLException s){s.getMessage();
        }
        return retval;

    }

}
