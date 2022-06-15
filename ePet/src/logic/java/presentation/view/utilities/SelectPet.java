package presentation.view.utilities;


import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuButton;
import utils.Kind;

import static utils.Kind.*;

public class SelectPet {
    private SelectPet(){
        //private constructor to hyde the default one
    }


    public static void setCheckedMenuItem(MenuButton kind, CheckMenuItem dog,CheckMenuItem cat,CheckMenuItem bunny, CheckMenuItem hamster, CheckMenuItem other){
        if(dog.isSelected()){
            kind.setText("dog");
            cat.setDisable(true);
            hamster.setDisable(true);
            other.setDisable(true);
            bunny.setDisable(true);
        }
        if(cat.isSelected()){
            kind.setText("cat");
            dog.setDisable(true);
            hamster.setDisable(true);
            other.setDisable(true);
            bunny.setDisable(true);
        }
        if(bunny.isSelected()){
            kind.setText("bunny");
            cat.setDisable(true);
            hamster.setDisable(true);
            other.setDisable(true);
            dog.setDisable(true);
        }
        if(hamster.isSelected()){
            kind.setText("hamster");
            cat.setDisable(true);
            dog.setDisable(true);
            other.setDisable(true);
            bunny.setDisable(true);
        }
        if(other.isSelected()){
            cat.setDisable(true);
            hamster.setDisable(true);
            dog.setDisable(true);
            bunny.setDisable(true);
            kind.setText("other");
        }
        if(!dog.isSelected()&&!cat.isSelected()&&!bunny.isSelected()&&!hamster.isSelected()&&!other.isSelected()){
            dog.setDisable(false);
            cat.setDisable(false);
            hamster.setDisable(false);
            other.setDisable(false);
            bunny.setDisable(false);

        }

    }

    public static Kind selectKind(String kind){

        if(kind.equals("dog")){return DOG;}

        else if(kind.equals("cat")){return CAT;}

        else if(kind.equals("bunny")){return BUNNY;}

        else if(kind.equals("hamster")){return HAMSTER;}

        else if(kind.equals("other")){return OTHER;}
        else {

            return null;}}

}
