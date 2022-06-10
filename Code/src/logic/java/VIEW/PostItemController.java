package VIEW;

import Beans.PostBean;
import Beans.SlotAppuntamentoBean;
import CONTROLLER.ManagePostController;
import CONTROLLER.ManageSlotsController;
import Exceptions.NoResultFoundException;
import Service.SessionFacade;
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
    private TextArea Country;
    @FXML
    private HBox resultsBox;
    @FXML
    private TextArea Region;
    @FXML
    private TextArea City;
    @FXML
    private Label ID;
    @FXML
    private Label errorMsg;
    @FXML
    private TextField address;
    @FXML
    private TextField time;




    public void setData( String title, String desc, String country, String city, String region,String id){
        ID.setText(id);
        titleLabel.setText(title);
        description.setText(desc);
        Country.setText(country);
        Region.setText(region);
        City.setText(city);


    }
    public String getDescription(){
        return description.getText();
    }
    public String getCountry(){
        return Country.getText();
    }
    public String getRegion(){
        return Region.getText();
    }
    public String getCity(){
        return City.getText();
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
            Main M= new Main();
            SlotItem p= M.getSlotItem("fxml1/slotItem.fxml");
            slotController slotControl=p.getController();
            Pane pane=p.getPane();

            slotControl.setData( i.getDate(), i.getAddress(), i.getPost());
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane,new Insets(10,10,10,10));



        }

    }
}



