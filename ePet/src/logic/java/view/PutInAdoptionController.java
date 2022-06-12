package view;

import beans.PostBean;
import service.SessionFacade;
import com.example.epet.Main;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import utils.Kind;
import java.io.IOException;
import java.sql.SQLException;

import static utils.Kind.*;

public class PutInAdoptionController {

        @FXML
        private CheckMenuItem bunny;

        @FXML
        private CheckMenuItem cat;

        @FXML
        private TextField city;

        @FXML
        private TextField country;

        @FXML
        private TextArea description;

        @FXML
        private CheckMenuItem dog;

        @FXML
        private Label errorMsg;

        @FXML
        private CheckMenuItem hamster;

        @FXML
        private MenuButton kind;

        @FXML
        private CheckMenuItem other;


        @FXML
        private TextField region;

        @FXML
        private TextArea title;

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
                if(!dog.isSelected()&&!cat.isSelected()&&!bunny.isSelected()&&!hamster.isSelected()&&!other.isSelected()){
                        dog.setDisable(false);
                        cat.setDisable(false);
                        hamster.setDisable(false);
                        other.setDisable(false);
                        bunny.setDisable(false);

                }


        }
        public Kind selectKind(){

                if(kind.getText().equals("dog")){return DOG;}

                else if(kind.getText().equals("cat")){return CAT;}

                else if(kind.getText().equals("bunny")){return BUNNY;}

                else if(kind.getText().equals("hamster")){return HAMSTER;}

                else if(kind.getText().equals("other")){return OTHER;}
                else {

                        return null;}

        }

        public void Post() throws IOException {
                PostBean postBean = new PostBean();


                postBean.setCity(city.getText());
                postBean.setCountry(country.getText());
                postBean.setRegion(region.getText());
                postBean.setDescription(description.getText());
                postBean.setTitle(title.getText());
                postBean.setCreator(SessionFacade.getSession().getID());
                postBean.setKindOfPet(selectKind());
                 try{
                         controller.ManagePostController.getInstance().writePost(postBean);
                         Main m=new Main();
                         m.changeScene("fxml1/post.fxml");

                 }catch(SQLException r){
                         errorMsg.setText(r.getMessage());
                         r.printStackTrace();
                 }


        }
}
