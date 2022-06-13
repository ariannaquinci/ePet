package presentation.viewmobile;

import beans.ProfileBean;
import com.example.epet.Main;
import controller.ManageProfileController;
import exceptions.NoResultFoundException;
import service.SessionFacade;
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
    private TextField birthday;


    @FXML
    private TextField firstName;

    @FXML
    private TextField nickname;

    @FXML
    private TextField phoneNumber;

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

        Main.getStage().close();
        if(m.getPrevious()!=null){
        m.getPrevious().close();
        }
        SessionFacade.getSession().setID(null);
        SessionFacade.getSession().setCurrUserType(null);
        m.start(Main.getStage());

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
    private void initResults(ObservableList<ProfileBean> list){


        for (ProfileBean i : list) {

            setData(i.getName(), i.getLastName(), i.getBirthday(), i.getNickname(),i.getTelephone());


        }


    }
    public void setData(String name, String secName, String bd, String nick,String telephone){
        firstName.setText(name);
        lastName.setText(secName);
        birthday.setText(bd);
        nickname.setText(nick);
        phoneNumber.setText(telephone);
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
