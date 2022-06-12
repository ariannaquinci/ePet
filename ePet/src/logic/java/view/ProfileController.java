package view;

import beans.ProfileBean;
import controller.ManageProfileController;
import exceptions.NoResultFoundException;
import service.SessionFacade;
import com.example.epet.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.SQLException;

public class ProfileController {


    @FXML
    private TextField birthday;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField nickname;
    @FXML
    private Pane pane;


    @FXML
    private TextField phoneNumber;


    @FXML
    protected void showProfileInfo() throws NoResultFoundException, IOException {
       ProfileBean bean=new ProfileBean();
        bean.setUser(SessionFacade.getSession().getID());
        initResults(ManageProfileController.getInstance().showProfileInfo(bean));
    }

    @FXML
    protected void exit() throws IOException {
        Main m= new Main();
        Main.getStage().close();
        if(m.getPrevious()!=null){
            m.getPrevious().close();
        }


        SessionFacade.getSession().setID(null);
        SessionFacade.getSession().setCurrUserType(null);

        m.start(Main.getStage());
    }
    private void initResults(ObservableList<ProfileBean> list) throws IOException, NoResultFoundException {


        for (ProfileBean i : list) {

            setData(i.getName(), i.getLastName(), i.getBirthday(), i.getNickname(),i.getTelephone());


        }


    }
    public void setData(String name, String lName, String bd, String nick,String telephone){
            firstName.setText(name);
            lastName.setText(lName);
            birthday.setText(bd);
            nickname.setText(nick);
            phoneNumber.setText(telephone);
    }

    @FXML
    protected void deleteProfile() throws SQLException, IOException {
        ProfileBean b=new ProfileBean();
        b.setUser(SessionFacade.getSession().getID());
        ManageProfileController.getInstance().deleteProfile(b);
        exit();
    }
}
