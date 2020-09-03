package com.example.userdatamicroservice.Repository;

import com.example.userdatamicroservice.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUsername(String username);

}
