package presentation.view;

import beans.PostBean;
import beans.SlotAppuntamentoBean;
import com.example.epet.MainComputer;
import controller.ManagePostController;
import controller.ManageSlotsController;
import exceptions.NoResultFoundException;
import presentation.graphics.PostItemGraphic;
import service.SessionFacade;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import utils.SlotItem;

import java.io.*;
import java.sql.SQLException;

public class PostItemController extends PostItemGraphic {


    @FXML
    private Label noResults;

    @FXML
    private Pane item;
    @FXML
    private TextArea description;



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
    private Label id;

    @FXML
    private TextField address;
    @FXML
    private TextField time;




    public void setData(String title, String desc, String co, String ci, String reg, String i){
        id.setText(i);
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
    public String getID(){return id.getText();}
    public HBox getResultsBox(){return resultsBox;}






    public void deletePost()  {

        if (super.deletePost(getID())){

            item.setVisible(false);}

    }


    public void showSlots() throws IOException{
        noResults.setText(super.showSlots(id.getText(),this));
    }

    public void addSlot() {
        noResults.setText(super.addSlot(id.getText(),address.getText(), time.getText()));

    }


}



