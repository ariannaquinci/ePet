package VIEW;

import Beans.ProfileBean;
import CONTROLLER.ManageProfileController;
import Exceptions.NoResultFoundException;
import Service.SessionFacade;
import com.example.epet.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.SQLException;

public class ProfileController {


    @FXML
    private TextField Birthday;

    @FXML
    private TextField FirstName;

    @FXML
    private TextField SecondName;

    @FXML
    private TextField nickname;
    @FXML
    private Pane pane;


    @FXML
    private TextField phone_number;


    @FXML
    protected void showProfileInfo() throws NoResultFoundException, IOException {
       ProfileBean bean=new ProfileBean();
        bean.setUser(SessionFacade.getSession().getID());
        initResults(ManageProfileController.getInstance().showProfileInfo(bean));
    }

    @FXML
    protected void exit() throws IOException {
        Main m= new Main();

        m.getStage().close();
        m.getPrevious().close();
        SessionFacade.getSession().setID(null);
        SessionFacade.getSession().setCurrUserType(null);

     m.start(Main.getStage());
    }
    private void initResults(ObservableList<ProfileBean> list) throws IOException, NoResultFoundException {


        for (ProfileBean i : list) {

            setData(i.getName(), i.getSecName(), i.getBirthday(), i.getNickname(),i.getTelephone());


        }


    }
    public void setData(String name, String secName, String bd, String nick,String telephone){
            FirstName.setText(name);
            SecondName.setText(secName);
            Birthday.setText(bd);
            nickname.setText(nick);
            phone_number.setText(telephone);
    }

    @FXML
    protected void deleteProfile() throws SQLException, IOException {
        ProfileBean b=new ProfileBean();
        b.setUser(SessionFacade.getSession().getID());
        ManageProfileController.getInstance().deleteProfile(b);
        exit();
    }
}
