package VIEW2;

import Beans.PostBean;
import CONTROLLER.ManagePostController;
import Exceptions.NoResultFoundException;
import Service.SessionFacade;
import com.example.epet.MainMobile;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import utils.post_item;

import java.io.IOException;

public class PostsPageController {
    @FXML
    private Label ID;
    @FXML
    private Label noResults;

    @FXML
    private Button appButton1;

    @FXML
    private TextArea description;

    @FXML
    private VBox resultsBox;

    @FXML
    private Label titleLabel;

    private void initResults(ObservableList<PostBean> list) throws IOException, NoResultFoundException {

        resultsBox.getChildren().clear();

        for(PostBean i: list) {
            MainMobile M= new MainMobile();
            post_item p= M.getPostItem("fxml2/post_item_mobile.fxml");
            postItemController postController=p.getController2();
            Pane pane=p.getPane();

            postController.setData( i.getTitle(), i.getDescription(),  i.getID());
            resultsBox.getChildren().add(pane);
            resultsBox.setMargin(pane,new Insets(10,10,10,10));



        }

    }
    @FXML

    protected void goBack() throws IOException {
        MainMobile H= new MainMobile();
        H.changeScene("fxml2/HomepageMobile.fxml");
    }

    @FXML
    public void showPosts() throws IOException {

        PostBean bean= new PostBean();
        bean.setCreator(SessionFacade.getSession().getID());
        try{
            initResults(ManagePostController.getInstance().getPosts(bean));
        }catch(NoResultFoundException n){

            noResults.setText(n.getMessage());
        }
    }


}
