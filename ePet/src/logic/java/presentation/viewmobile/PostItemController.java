package presentation.viewmobile;

import beans.PostBean;
import beans.SlotAppuntamentoBean;
import controller.ManagePostController;
import controller.ManageSlotsController;
import exceptions.NoResultFoundException;
import presentation.graphics.PostItemGraphic;
import service.SessionFacade;
import com.example.epet.MainMobile;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import utils.SlotItem;

import java.io.IOException;
import java.sql.SQLException;

public class PostItemController implements PostItemGraphic {

    @FXML
    private Label id;

    @FXML
    private TextField address;
    @FXML
    private TextField time;

    @FXML
    private TextArea description;

    @FXML
    private HBox resultsBox;

    @FXML
    private Label titleLabel;
    @FXML
    private Label noResults;
    @FXML
    private Pane item;

    @Override
    public void addSlot() {
        SlotAppuntamentoBean slotBean = new SlotAppuntamentoBean();
        slotBean.setPost(id.getText());
        slotBean.setAddress(address.getText());
        slotBean.setDate(time.getText());

        try{
            noResults.setText("Slot added");
             ManageSlotsController.getInstance().insertSlot(slotBean);


        }catch(SQLException s){
            noResults.setText("Error in adding slot");

        }

    }

    public String getID(){return id.getText();}
    @Override
    public void showSlots() throws IOException{

            SlotAppuntamentoBean bean= new SlotAppuntamentoBean();
            bean.setPost(id.getText());
            try{
                noResults.setText("");
                initResults(ManageSlotsController.getInstance().showSlots(bean));


            }catch(NoResultFoundException n) {
                noResults.setText(n.getMessage());
            }

    }

    @Override
    public void initResults(ObservableList<SlotAppuntamentoBean> list) throws IOException, NoResultFoundException {

        resultsBox.getChildren().clear();

        for (SlotAppuntamentoBean i : list) {
            MainMobile m = new MainMobile();
            SlotItem p = m.getSlotItem("fxml2/slotItemMobile.fxml");
            presentation.viewmobile.SlotItemController slotControl = p.getController2();
            Pane pane = p.getPane();

            slotControl.setData(i.getDate(), i.getAddress(), i.getPost());
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane, new Insets(10, 10, 10, 10));


        }

    }

    public void setData( String title, String desc, String ident){
        id.setText(ident);
        titleLabel.setText(title);
        description.setText(desc);

    }
  @Override
  public void deletePost(){

      PostBean bean = new PostBean();
      bean.setId(getID());
      bean.setCreator(SessionFacade.getSession().getID());
      try{
      ManagePostController.getInstance().deletePost(bean);}
      catch(SQLException s){s.getMessage();}
      item.setVisible(false);
    }

}
