package view;

import beans.PostBean;
import service.SessionFacade;
import com.example.epet.Main;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import utils.Kind;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import static utils.Kind.*;

public class PutInAdoptionController {

        @FXML
        private TextField City;

        @FXML
        private TextField Country;

        @FXML
        private TextField Region;

        @FXML
        private Button back;

        @FXML
        private CheckMenuItem bunny;

        @FXML
        private CheckMenuItem cat;

        @FXML
        private TextArea description;

        @FXML
        private CheckMenuItem dog;

        @FXML
        private CheckMenuItem hamster;

        @FXML
        private Button home;

        @FXML
        private MenuButton kind;

        @FXML
        private CheckMenuItem other;
        @FXML
        private TextArea title;

        @FXML
        private Button post;
        @FXML
        private ImageView pet_image;
        @FXML
        private TextField slot1time;

        @FXML
        private TextField slot1where;

        @FXML
        private TextField slot2time;

        @FXML
        private TextField slot2where;

        @FXML
        private TextField slot3time;

        @FXML
        private TextField slot3where;

        @FXML
        private TextField slot4where;
        @FXML
        private Label errorMsg;

        @FXML
        private TextField slot4time;

        @FXML
        protected void back() throws IOException {
                Main m=new Main();
                m.changeScene("fxml1/homepage.fxml");
        }
        @FXML
        protected void goHome() throws IOException{
                Main m=new Main();
                m.changeScene("fxml1/homepage.fxml");
        }



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
        public Kind selectKind(){

                if(kind.getText()=="dog"){return DOG;}

                else if(kind.getText()=="cat"){return CAT;}

                else if(kind.getText()=="bunny"){return BUNNY;}

                else if(kind.getText()=="hamster"){return HAMSTER;}

                else if(kind.getText()=="other"){return OTHER;}
                else {

                        return null;}

        }
         public PostBean set_pic(PostBean bean) throws IOException{

                        bean.setPic(new File(pet_image.getImage().toString()));
                        return bean;

        }
        public void Post() throws IOException {
                PostBean postBean = new PostBean();

                if (pet_image != null) {

                        postBean = set_pic(postBean);
                }
                postBean.setCity(City.getText());
                postBean.setCountry(Country.getText());
                postBean.setRegion(Region.getText());
                postBean.setDescription(description.getText());
                postBean.setTitle(title.getText());
                postBean.setCreator(SessionFacade.getSession().getID());
                postBean.setKindOfPet(selectKind());
                 try{
                         controller.ManagePostController.getInstance().writePost(postBean);
                         Main H=new Main();
                         H.changeScene("fxml1/post.fxml");

                 }catch(SQLException r){
                         errorMsg.setText(r.getMessage());
                         r.printStackTrace();
                 }


        }
}
