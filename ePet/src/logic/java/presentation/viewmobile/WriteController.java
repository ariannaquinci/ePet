package presentation.viewmobile;

import beans.PostBean;
import service.SessionFacade;
import com.example.epet.MainMobile;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import presentation.view.utilities.SelectPet;

import java.io.IOException;
import java.sql.SQLException;

public class WriteController {
    @FXML
    private TextField city;

    @FXML
    private TextField country;

    @FXML
    private TextField region;


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
    private MenuButton kind;

    @FXML
    private CheckMenuItem other;
    @FXML
    private TextArea title;

    @FXML
    private Label errorMsg;


    @FXML
    protected void goBack() throws IOException {
        MainMobile m= new MainMobile();
        m.changeScene("fxml2/HomepageMobile.fxml");
    }



    public void setKind(){
        SelectPet.setCheckedMenuItem(kind,dog,cat,bunny,hamster,other);
    }

    @FXML
    protected void post() throws IOException {
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
            MainMobile m=new MainMobile();
            m.changeScene("fxml2/HomepageMobile.fxml");
            Stage popup =m.createPopupScene("fxml2/post.fxml");
            popup.show();


        }catch(SQLException r){
            errorMsg.setText(r.getMessage());
            r.printStackTrace();
        }


    }
}
