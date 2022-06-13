package presentation.view;

import beans.PostBean;
import presentation.graphics.PutInAdoptionGraphic;
import service.SessionFacade;
import com.example.epet.MainComputer;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import presentation.view.utilities.SelectPet;

import java.io.IOException;
import java.sql.SQLException;

public class PutInAdoptionController implements PutInAdoptionGraphic {

        @FXML
        private TextField city;

        @FXML
        private TextField country;

        @FXML
        private TextField region;

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
        private Label errorMsg;



        @Override
        public void goBack() throws IOException {
                MainComputer m=new MainComputer();
                m.changeScene("fxml1/homepage.fxml");
        }



        @Override
        public void setKind(){
                SelectPet.setCheckedMenuItem(kind,dog,cat,bunny,hamster,other);

        }

        @Override
        public void post() throws IOException {
                PostBean postBean = new PostBean();

                postBean.setCity(city.getText());
                postBean.setCountry(country.getText());
                postBean.setRegion(region.getText());
                postBean.setDescription(description.getText());
                postBean.setTitle(title.getText());
                postBean.setCreator(SessionFacade.getSession().getID());
                postBean.setKindOfPet(SelectPet.selectKind(kind.getText()));
                 try{
                         controller.ManagePostController.getInstance().writePost(postBean);
                         MainComputer H=new MainComputer();
                         H.changeScene("fxml1/post.fxml");

                 }catch(SQLException r){
                         errorMsg.setText(r.getMessage());
                         r.printStackTrace();
                 }


        }
}
