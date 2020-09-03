package com.example.userdatamicroservice.Service;

import com.example.userdatamicroservice.Models.Address;
import com.example.userdatamicroservice.Models.User;
import com.example.userdatamicroservice.Repository.UserRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) {
        return userRepository.findById(id).get();
    }

    public User updateUser(User newUser ,int id) {
        return userRepository.findById(id).map(user -> {
            user.setEmail(newUser.getEmail());
            user.setName(newUser.getName());
            user.setPhone(newUser.getPhone());
            user.setUsername(newUser.getUsername());
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("user" + id + "not found"));

    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public Set<Address> getListOfAddress(int id) {
        return userRepository.findById(id).get().getAddressSet();
    }

    public boolean checkUserNameAvailaibality(String name) {
        User user = userRepository.findUserByUsername(name);
        if (user == null) {
            return true;
        }

        return false;
    }
}
