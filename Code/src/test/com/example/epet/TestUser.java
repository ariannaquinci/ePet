package com.example.epet;

import Entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;


public class TestUser {
   @Test
   public void testLogin(){
      User u= new User("arianna.quinci99@gmail.com","password");
      Assertions.assertThrows(SQLException.class,()->u.login());
   }


}
