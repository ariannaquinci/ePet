package presentation.graphics;

import beans.PostBean;
import com.example.epet.MainComputer;
import com.example.epet.MainMobile;
import javafx.stage.Stage;
import presentation.view.PutInAdoptionController;
import presentation.view.utilities.SelectPet;
import presentation.viewmobile.WriteController;
import service.SessionFacade;
import utils.Kind;

import java.io.IOException;
import java.sql.SQLException;

public class PutInAdoptionGraphic {

    protected final String  post(String city, String country, String region, String description, String title, Kind kind,PutInAdoptionGraphic adopt) throws IOException {
        String errorMsg="";
        PostBean postBean = new PostBean();
        postBean.setCity(city);
        postBean.setCountry(country);
        postBean.setRegion(region);
        postBean.setDescription(description);
        postBean.setTitle(title);
        postBean.setCreator(SessionFacade.getSession().getID());
        postBean.setKindOfPet(kind);
        if(adopt.getClass()== PutInAdoptionController.class){




            try{
                controller.ManagePostController.getInstance().writePost(postBean);
                MainComputer m=new MainComputer();
                m.changeScene("fxml1/post.fxml");

            }catch(SQLException r){
                errorMsg=r.getMessage();

            }
            return errorMsg;}
            else if(adopt.getClass()==WriteController.class){

                try{
                    controller.ManagePostController.getInstance().writePost(postBean);
                    MainMobile m=new MainMobile();
                    m.changeScene("fxml2/HomepageMobile.fxml");
                    Stage popup =m.createPopupScene("fxml2/post.fxml");
                    popup.show();
                }catch(SQLException r){
                    errorMsg=r.getMessage();

                }

        }
        return errorMsg;



}
}
