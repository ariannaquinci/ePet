package presentation.view;

import beans.PostBean;
import controller.ResearchController;
import exceptions.NoResultFoundException;
import com.example.epet.Main;
import presentation.AdoptionGraphic;
import utils.PetItem;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import presentation.view.utilities.SelectPet;

import java.io.File;
import java.io.IOException;

public class AdoptionController implements AdoptionGraphic {
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
    @Override
    public void setKind(){
        SelectPet.setCheckedMenuItem(kind,dog,cat,bunny,hamster,other);
    }

    @Override
    public void goHome() throws IOException {
        Main m=new Main();
        m.changeScene("fxml1/homepage.fxml");
    }



    @Override
    public void initResults(ObservableList<PostBean> list) throws IOException {
        noResults.setText("");
        resultsBox.getChildren().clear();

        for(PostBean i: list) {
               Main m= new Main();
               PetItem p= m.getItem("fxml1/petItem.fxml");
               PetItemController petItemController=p.getController();
               Pane pane=p.getPane();


                File image= null;
                if(i.getPic()!=null){
                    image=i.getPic();
                    petItemController.setData( i.getTitle(), i.getDescription(), i.getCreator(),i.getId(),image);

                }

                petItemController.setData( i.getTitle(), i.getDescription(),i.getCreator(),i.getId(),null);
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane,new Insets(10,10,10,10));


        }

    }

    @Override
    public void search() throws IOException{

        PostBean bean=new PostBean();

        bean.setKindOfPet(SelectPet.selectKind(kind.getText()));

        bean.setCountry(country.getText());
        bean.setCity(city.getText());
        bean.setRegion(region.getText());

        try {

            initResults(ResearchController.getInstance().research(bean));

        }catch(NoResultFoundException e){
            resultsBox.getChildren().clear();
            noResults.setText(e.getMessage());

        }

    }


}
