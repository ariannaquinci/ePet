package com.example.epet;

import MODEL.DAO.*;

import java.sql.SQLException;
import java.text.*;

public class MainTestDB {
    public static void main(String args[]) throws SQLException, ParseException {

        AppointmentDAO AD= new AppointmentDAO();
        AppointmentRequestDAO ARD= new AppointmentRequestDAO();
        FavoriteDAO FD=new FavoriteDAO();
        PostDAO POD= new PostDAO();
        ProfileDAO PD= new ProfileDAO();
        ScheduledAppointmentDAO SAD=new ScheduledAppointmentDAO();
        SlotAppuntamentoDAO SLAD= new SlotAppuntamentoDAO();
        UserDAO UD= new UserDAO();


       /* UD.login("arianna.quinci99@gmail.com","Morghi99");
        UD.deleteUser("arianna.quinci99@gmail.com");
       UD.register("arianna.quinci99@gmail.com","12345","simpleuser");
      POD.writePost("arianna.quinci99@gmail.com","ciao","Lazio","Cane cucciolo","DOG","Italy","Rome");

    AD.scheduleApp("2022/06/22 11:00", "giuliov.posta39@gmail.com", "arianna.quinci99@gmail.com");
       SLAD.InsertSlot("2022/06/22 12:00","1928293","via san bernardino da siena 55");
       ARD.requestApp("2022/06/22 11:00", "arianna.quinci99@gmail.com", "000222");

     FD.insert_favorite("0000191919","giuliov.posta39@gmail.com");
        FD.remove_favorite("giuliov.posta39@gmail.com", "0000191919");
        FD.show_favorites("arianna.quinci99@gmail.com");
        POD.deletePost("0001298");


        PD.CreateProfile("arianna.quinci99@gmail.com","arianna","quinci","1999/09/12");
        PD.editNickname("giuliov.posta39@gmail.com","giuls");

        PD.editTelephoneNumber("arianna.quinci99@gmail.com","3207729217");
        SAD.seeScheduledApp("arianna.quinci99@gmail.com");

        SLAD.OccupySlot("2022/05/20 12:00","1928293");*/

      /*  POD.editPosition("12673889", "italy", "rome", "lazio");
        POD.editDescription("34567890", "xcnjdefbdfhw");

        PD.editProfilePicture("arianna.quinci99@gmail.com", "/home/morghi/Downloads/cane.jpeg" );*/
    }
}
