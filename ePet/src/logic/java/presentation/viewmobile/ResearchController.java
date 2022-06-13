package presentation.viewmobile;

import beans.PostBean;
import exceptions.NoResultFoundException;
import com.example.epet.MainMobile;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import presentation.graphicInterfaces.AdoptionGraphic;
import utils.PetItem;
import presentation.view.utilities.SelectPet;

import java.io.IOException;

public class ResearchController implements AdoptionGraphic {
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
    @Override

    public void setKind(){
        SelectPet.setCheckedMenuItem(kind,dog,cat,bunny,hamster,other);
    }
    @Override
    public void goHome() throws IOException {
        MainMobile m=new MainMobile();
        m.changeScene("fxml2/HomepageMobile.fxml");
    }

    public void goBack() throws IOException {
        MainMobile m=new MainMobile();
        m.changeScene("fxml2/menu.fxml");
    }



    @Override
    public void initResults(ObservableList<PostBean> list) throws IOException {
        noResults.setText("");
        resultsBox.getChildren().clear();

        for(PostBean i: list) {
            MainMobile m= new MainMobile();
            PetItem p= m.getItem("fxml2/petItem.fxml");
            PetItemController itemController=p.getController2();
            Pane pane=p.getPane();




            itemController.setData( i.getTitle(), i.getDescription(),i.getCreator(),i.getId());
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

            initResults(controller.ResearchController.getInstance().research(bean));

        }catch(NoResultFoundException e){
            resultsBox.getChildren().clear();
            noResults.setText(e.getMessage());

        }

    }


}
