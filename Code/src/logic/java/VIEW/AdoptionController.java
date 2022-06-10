package VIEW;

import Beans.PostBean;
import CONTROLLER.ResearchController;
import Exceptions.NoResultFoundException;
import com.example.epet.Main;
import utils.pet_item;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import utils.Kind;

import java.io.File;
import java.io.IOException;

import static utils.Kind.*;

public class AdoptionController {
    @FXML
    private MenuButton kind;

    @FXML
    private CheckMenuItem dog;
    @FXML
    private CheckMenuItem cat;
    @FXML
    private CheckMenuItem bunny;
    @FXML
    private CheckMenuItem hamster;
    @FXML
    private CheckMenuItem other;

    @FXML
    private TextField country;
    @FXML
    private TextField city;
    @FXML
    private TextField region;
    @FXML
    private Label noResults;
    @FXML
    private VBox resultsBox;

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
        Main H=new Main();
        H.changeScene("fxml1/homepage.fxml");
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
               Main M= new Main();
               pet_item p= M.getItem("fxml1/petItem.fxml");
               PetItemController petItemController=p.getController();
               Pane pane=p.getPane();


                File image= null;
                if(i.getPic()!=null){
                    image=i.getPic();
                    petItemController.setData( i.getTitle(), i.getDescription(), i.getCreator(),i.getID(),image);

                }

                petItemController.setData( i.getTitle(), i.getDescription(),i.getCreator(),i.getID(),null);
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane,new Insets(10,10,10,10));


        }

    }

    public void search() throws IOException{

        PostBean bean=new PostBean();

        bean.setKindOfPet(selectKind());

        bean.setCountry(country.getText());
        bean.setCity(city.getText());
        bean.setRegion(region.getText());

        try {

            initResults(ResearchController.getInstance().Research(bean));

        }catch(NoResultFoundException e){
            resultsBox.getChildren().clear();
            noResults.setText(e.getMessage());

        }

    }


}
