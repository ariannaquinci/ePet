package view;

import beans.PostBean;
import beans.SlotAppuntamentoBean;
import controller.ManagePostController;
import controller.ManageSlotsController;
import exceptions.NoResultFoundException;
import service.SessionFacade;
import com.example.epet.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import utils.SlotItem;

import java.io.*;
import java.sql.SQLException;

public class PostItemController {

    @FXML
    private Button appButton;
    @FXML
    private Label noResults;

    @FXML
    private Pane item;
    @FXML
    private TextArea description;

    @FXML
    private Button editButton;

    @FXML
    private Label titleLabel;
    @FXML
    private TextArea country;
    @FXML
    private HBox resultsBox;
    @FXML
    private TextArea region;
    @FXML
    private TextArea city;
    @FXML
    private Label ID;
    @FXML
    private Label errorMsg;
    @FXML
    private TextField address;
    @FXML
    private TextField time;




    public void setData( String title, String desc, String co, String ci, String reg,String id){
        ID.setText(id);
        titleLabel.setText(title);
        description.setText(desc);
        country.setText(co);
        region.setText(reg);
        city.setText(ci);


    }
    public String getDescription(){
        return description.getText();
    }
    public String getCountry(){
        return country.getText();
    }
    public String getRegion(){
        return region.getText();
    }
    public String getCity(){
        return city.getText();
    }
    public String getID(){return ID.getText();}


    public void editPost() throws IOException {



    }


    public void deletePost()  {

        PostBean bean = new PostBean();
        bean.setID(getID());
        bean.setCreator(SessionFacade.getSession().getID());

        ManagePostController.getInstance().deletePost(bean);
        item.setVisible(false);

    }

    @FXML
    protected void add_slot() {
        SlotAppuntamentoBean slotBean = new SlotAppuntamentoBean();
        slotBean.setPost(ID.getText());
        slotBean.setAddress(address.getText());
        slotBean.setDate(time.getText());
        try {
            errorMsg.setText("");
            ManageSlotsController.getInstance().Insert_slot(slotBean);
        }catch(SQLException s){
            errorMsg.setText(s.getMessage());
        }
    }


    @FXML
    protected void show_slots() throws IOException{
        SlotAppuntamentoBean bean= new SlotAppuntamentoBean();
        bean.setPost(ID.getText());
        try{
            noResults.setText("");
            initResults(ManageSlotsController.getInstance().showSlots(bean));


        }catch(NoResultFoundException n){
            noResults.setText(n.getMessage());
        }
    }

    private void initResults(ObservableList<SlotAppuntamentoBean> list) throws IOException, NoResultFoundException {

        resultsBox.getChildren().clear();

        for(SlotAppuntamentoBean i: list) {
            Main m= new Main();
            SlotItem p= m.getSlotItem("fxml1/slotItem.fxml");
            SlotController slotControl=p.getController();
            Pane pane=p.getPane();

            slotControl.setData( i.getDate(), i.getAddress(), i.getPost());
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane,new Insets(10,10,10,10));



        }

    }
}



