package com.example.userdatamicroservice;

import com.example.userdatamicroservice.Controller.UserController;
import com.example.userdatamicroservice.Models.Address;
import com.example.userdatamicroservice.Models.User;
import com.example.userdatamicroservice.Repository.AddressRepository;
import com.example.userdatamicroservice.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class UserDataMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserDataMicroserviceApplication.class, args);
    }

}
