package com.example.userdatamicroservice;

import com.example.userdatamicroservice.Controller.UserController;
import com.example.userdatamicroservice.Models.Address;
import com.example.userdatamicroservice.Models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserDataMicroserviceApplicationTests {

    @Autowired
    UserController userController;

    @Test
    void contextLoads() {

    }

}
