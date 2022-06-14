package presentation.graphics;

import beans.PostBean;
import com.example.epet.MainComputer;
import com.example.epet.MainMobile;
import controller.ResearchController;
import exceptions.NoResultFoundException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import presentation.view.AdoptionController;
import presentation.view.PetItemController;
import presentation.view.utilities.SelectPet;
import utils.Kind;
import utils.PetItem;

import java.io.IOException;

import static utils.Kind.*;

public class AdoptionGraphic {




    public void initResults(ObservableList<PostBean> list,AdoptionGraphic a) throws IOException {

        if (a.getClass() == AdoptionController.class) {
            VBox resultsBox = ((AdoptionController) a).getResultsBox();

            resultsBox.getChildren().clear();

            for (PostBean i : list) {
                MainComputer m = new MainComputer();
                PetItem p = m.getItem("fxml1/petItem.fxml");
                PetItemController petItemController = p.getController();
                Pane pane = p.getPane();


                petItemController.setData(i.getTitle(), i.getDescription(), i.getCreator(), i.getId());
                resultsBox.getChildren().add(pane);
                resultsBox.setMargin(pane, new Insets(10, 10, 10, 10));


            }
        } else if(a.getClass() == presentation.viewmobile.ResearchController.class) {
            VBox resultsBox = ((presentation.viewmobile.ResearchController) a).getResultsBox();
            resultsBox.getChildren().clear();

            for (PostBean i : list) {
                MainMobile m = new MainMobile();
                PetItem p = m.getItem("fxml2/petItem.fxml");
                presentation.viewmobile.PetItemController itemController = p.getController2();
                Pane pane = p.getPane();


                itemController.setData(i.getTitle(), i.getDescription(), i.getCreator(), i.getId());
                resultsBox.getChildren().add(pane);
                resultsBox.setMargin(pane, new Insets(10, 10, 10, 10));


            }

        }
    }




    public String search(AdoptionGraphic a,String kind, String country, String city, String region) throws IOException{

        String noResults="";
        PostBean bean=new PostBean();

        bean.setKindOfPet(SelectPet.selectKind(kind));

        bean.setCountry(country);
        bean.setCity(city);
        bean.setRegion(region);

        try {

            initResults(ResearchController.getInstance().research(bean),a);

        }catch(NoResultFoundException e){
            if(a.getClass()==AdoptionController.class){
            ((AdoptionController)a).getResultsBox().getChildren().clear();}

            else if(a.getClass()==presentation.viewmobile.ResearchController.class){
                ((presentation.viewmobile.ResearchController)a).getResultsBox().getChildren().clear();
            }
                            noResults=e.getMessage();

        }
        return noResults;
}}
