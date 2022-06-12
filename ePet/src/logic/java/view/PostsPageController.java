package view;

import beans.PostBean;
import controller.ManagePostController;
import exceptions.NoResultFoundException;
import service.SessionFacade;
import com.example.epet.Main;
import utils.PostItem;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class PostsPageController {
    @FXML
    private Button back;

    @FXML
    private VBox resultsBox;
    @FXML
    private Label noResults;


    private void initResults(ObservableList<PostBean> list) throws IOException, NoResultFoundException {

            resultsBox.getChildren().clear();

            for(PostBean i: list) {
            Main m= new Main();
            PostItem p= m.getPostItem("fxml1/post_item.fxml");
            PostItemController postItemController=p.getController();
            Pane pane=p.getPane();

            postItemController.setData( i.getTitle(), i.getDescription(), i.getCity(), i.getCountry(), i.getRegion(), i.getID());
                resultsBox.getChildren().add(pane);
                resultsBox.setMargin(pane,new Insets(10,10,10,10));



        }

    }
    public void goBack() throws IOException {
        Main m=new Main();
        m.changeScene("fxml1/homepage.fxml");
    }

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
