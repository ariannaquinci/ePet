package view2;

import beans.PostBean;
import exceptions.NoResultFoundException;
import com.example.epet.MainMobile;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import utils.Kind;
import utils.PetItem;

import java.io.IOException;

import static utils.Kind.*;

public class ResearchController {
    @FXML
    private CheckMenuItem bunny;

    @FXML
    private CheckMenuItem cat;

    @FXML
    private TextField city;

    @FXML
    private TextField country;

    @FXML
    private CheckMenuItem dog;

    @FXML
    private CheckMenuItem hamster;

    @FXML
    private MenuButton kind;

    @FXML
    private Label noResults;

    @FXML
    private CheckMenuItem other;

    @FXML
    private TextField region;

    @FXML
    private VBox resultsBox;

    @FXML
    private Button search;

    public void setKind(){
        if(dog.isSelected()){
            kind.setText("dog");
            cat.setDisable(true);
            hamster.setDisable(true);
            other.setDisable(true);
            bunny.setDisable(true);
        }
        if(cat.isSelected()){
            kind.setText("cat");
            dog.setDisable(true);
            hamster.setDisable(true);
            other.setDisable(true);
            bunny.setDisable(true);
        }
        if(bunny.isSelected()){
            kind.setText("bunny");
            cat.setDisable(true);
            hamster.setDisable(true);
            other.setDisable(true);
            dog.setDisable(true);
        }
        if(hamster.isSelected()){
            kind.setText("hamster");
            cat.setDisable(true);
            dog.setDisable(true);
            other.setDisable(true);
            bunny.setDisable(true);
        }
        if(other.isSelected()){
            cat.setDisable(true);
            hamster.setDisable(true);
            dog.setDisable(true);
            bunny.setDisable(true);
            kind.setText("other");
        }
        if(dog.isSelected()==false&&cat.isSelected()==false&&bunny.isSelected()==false&&hamster.isSelected()==false&&other.isSelected()==false){
            dog.setDisable(false);
            cat.setDisable(false);
            hamster.setDisable(false);
            other.setDisable(false);
            bunny.setDisable(false);

        }


    }

    public void goHome() throws IOException {
        MainMobile H=new MainMobile();
        H.changeScene("fxml2/HomepageMobile.fxml");
    }
    public void goBack() throws IOException {
        MainMobile M=new MainMobile();
        M.changeScene("fxml2/menu.fxml");
    }

    public Kind selectKind(){

        if(kind.getText()=="dog"){return DOG;}

        else if(kind.getText()=="cat"){return CAT;}

        else if(kind.getText()=="bunny"){return BUNNY;}

        else if(kind.getText()=="hamster"){return HAMSTER;}

        else if(kind.getText()=="other"){return OTHER;}
        else {

            return null;}

    }


    private void initResults(ObservableList<PostBean> list) throws IOException {
        noResults.setText("");
        resultsBox.getChildren().clear();

        for(PostBean i: list) {
            MainMobile M= new MainMobile();
            PetItem p= M.getItem("fxml2/petItem.fxml");
            PetItemController itemController=p.getController2();
            Pane pane=p.getPane();




            itemController.setData( i.getTitle(), i.getDescription(),i.getCreator(),i.getID());
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane,new Insets(10,10,10,10));


        }

    }

    @FXML
    protected void search() throws IOException{

        PostBean bean=new PostBean();

        bean.setKindOfPet(selectKind());

        bean.setCountry(country.getText());
        bean.setCity(city.getText());
        bean.setRegion(region.getText());

        try {

            initResults(controller.ResearchController.getInstance().Research(bean));

        }catch(NoResultFoundException e){
            resultsBox.getChildren().clear();
            noResults.setText(e.getMessage());

        }

    }


}
