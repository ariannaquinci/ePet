package com.example.epet;

import Beans.UserBean;
import Exceptions.InvalidFieldException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;





public class TestUserBean {
    @Test
    public void testVerifyEqualFields(){
        UserBean ub= new UserBean();
        ub.setPassword("ciao");

        Assertions.assertThrows(InvalidFieldException.class,()->ub.verifyEqualFields("password"));

    }
    @Test
    public void testVerifySintax(){
        UserBean ub= new UserBean();
        ub.setEmail("arianna.com");
        Assertions.assertThrows(InvalidFieldException.class,()->ub.verifySyntax());
    }

}
