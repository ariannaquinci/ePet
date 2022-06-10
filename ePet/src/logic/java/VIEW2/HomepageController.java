package VIEW2;

import Beans.ProfileBean;
import CONTROLLER.ManageProfileController;
import Exceptions.NoResultFoundException;
import Service.SessionFacade;
import com.example.epet.MainMobile;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class HomepageController {
    @FXML
    private Button choiseMenu;
    @FXML
    private Label noResults;
    @FXML
    private TextField Birthday;


    @FXML
    private TextField firstName;

    @FXML
    private TextField nickname;

    @FXML
    private TextField phone_number;

    @FXML
    private TextField lastName;


    @FXML
    protected void deleteProfile() throws SQLException, IOException {
        ProfileBean b=new ProfileBean();
        b.setUser(SessionFacade.getSession().getID());
        ManageProfileController.getInstance().deleteProfile(b);
        logOut();
    }

    @FXML
    protected void logOut() throws IOException {
        MainMobile m= new MainMobile();

        m.getStage().close();
        SessionFacade.getSession().setID(null);
        SessionFacade.getSession().setCurrUserType(null);
        m.start(MainMobile.getStage());

    }

    @FXML
    public void showPosts() throws IOException {
        MainMobile m= new MainMobile();
        m.changeScene("fxml2/postsPageMobile.fxml");

    }

    @FXML
    protected void showProfInfo() throws NoResultFoundException, IOException {
        ProfileBean bean = new ProfileBean();
        bean.setUser(SessionFacade.getSession().getID());
        initResults(ManageProfileController.getInstance().showProfileInfo(bean));
    }
    private void initResults(ObservableList<ProfileBean> list) throws IOException, NoResultFoundException {


        for (ProfileBean i : list) {

            setData(i.getName(), i.getSecName(), i.getBirthday(), i.getNickname(),i.getTelephone());


        }


    }
    public void setData(String name, String secName, String bd, String nick,String telephone){
        firstName.setText(name);
        lastName.setText(secName);
        Birthday.setText(bd);
        nickname.setText(nick);
        phone_number.setText(telephone);
    }

    @FXML
    protected void openMenu() throws IOException {
        MainMobile m= new MainMobile();
        m.changeScene("fxml2/menu.fxml");
    }
    @FXML
    protected void notifications() throws IOException {
        MainMobile m= new MainMobile();
        m.changeScene("fxml2/appRequests.fxml");
    }
    @FXML
    protected void writePost() throws IOException {
        MainMobile m= new MainMobile();
        m.changeScene("fxml2/write_post.fxml");
    }


}
