package view2;

import beans.PostBean;
import beans.SlotAppuntamentoBean;
import controller.ManagePostController;
import controller.ManageSlotsController;
import exceptions.NoResultFoundException;
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

public class PostItemController {

    @FXML
    private Label ID;

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

    @FXML
    protected void addSlot() throws SQLException {
        SlotAppuntamentoBean slotBean = new SlotAppuntamentoBean();
        slotBean.setPost(ID.getText());
        slotBean.setAddress(address.getText());
        slotBean.setDate(time.getText());

        try{
            noResults.setText("Slot added");
             ManageSlotsController.getInstance().Insert_slot(slotBean);


        }catch(SQLException s){
            noResults.setText("Error in adding slot");

        }

    }

    public String getID(){return ID.getText();}
    @FXML
    protected void showSlots() {

            SlotAppuntamentoBean bean= new SlotAppuntamentoBean();
            bean.setPost(ID.getText());
            try{
                noResults.setText("");
                initResults(ManageSlotsController.getInstance().showSlots(bean));


            }catch(NoResultFoundException n){
                noResults.setText(n.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }

    private void initResults(ObservableList<SlotAppuntamentoBean> list) throws IOException, NoResultFoundException {

        resultsBox.getChildren().clear();

        for (SlotAppuntamentoBean i : list) {
            MainMobile M = new MainMobile();
            SlotItem p = M.getSlotItem("fxml2/slotItemMobile.fxml");
            view2.SlotItemController slotControl = p.getController2();
            Pane pane = p.getPane();

            slotControl.setData(i.getDate(), i.getAddress(), i.getPost());
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane, new Insets(10, 10, 10, 10));


        }

    }
    public void setData( String title, String desc, String id){
        ID.setText(id);
        titleLabel.setText(title);
        description.setText(desc);

    }
  @FXML
    protected void deletePost(){

      PostBean bean = new PostBean();
      bean.setID(getID());
      bean.setCreator(SessionFacade.getSession().getID());

      ManagePostController.getInstance().deletePost(bean);
      item.setVisible(false);
    }

}
