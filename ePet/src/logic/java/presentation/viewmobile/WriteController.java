package presentation.viewmobile;

import beans.PostBean;
import presentation.graphics.PutInAdoptionGraphic;
import service.SessionFacade;
import com.example.epet.MainMobile;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import presentation.view.utilities.SelectPet;

import java.io.IOException;
import java.sql.SQLException;

public class WriteController extends PutInAdoptionGraphic {
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


    public void goBack() throws IOException {
        MainMobile m= new MainMobile();
        m.changeScene("fxml2/HomepageMobile.fxml");
    }

    public void setKind(){
        SelectPet.setCheckedMenuItem(kind,dog,cat,bunny,hamster,other);
    }

    public void post() throws IOException {
        errorMsg.setText(super.post(city.getText(),country.getText(),region.getText(),description.getText(),title.getText(),SelectPet.selectKind(kind.getText()),this));


    }
}
