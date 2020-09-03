package com.example.userdatamicroservice.Controller;

import com.example.userdatamicroservice.Models.Address;
import com.example.userdatamicroservice.Models.User;
import com.example.userdatamicroservice.Service.AddressService;
import com.example.userdatamicroservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

    @PostMapping("user/create")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping("user/get/{id}")
    public User getUser (@PathVariable ("id") int id) {
        return userService.getUser(id);
    }

    @PostMapping("user/update/{id}")
    public User updateUser(@RequestBody User newUser, @PathVariable("id") int id) {

        return userService.updateUser(newUser, id);
    }

    @GetMapping("user/delete/{id}")
    public void deleteUser (@PathVariable ("id") int id) {
        userService.deleteUser(id);
    }

    @GetMapping("user/{id}/address/get")
    public Set<Address> getAllAddress(@PathVariable ("id") int id) {
        return userService.getListOfAddress(id);
    }

    @PostMapping("user/{id}/address/add")
    public Address addAddress(@RequestBody Address address, @PathVariable("id") int id) {
        address.setUser(userService.getUser(id));
        return addressService.createAddress(address);
    }

    @GetMapping("user/{id}/address/get/{addressid}")
    public Address getAddress (@PathVariable ("id") int id, @PathVariable ("addressid") int addid) {
        return addressService.getAddressById(addid);
    }

    @PutMapping("user/{id}/address/update/{addressid}")
    public Address updateAddress(@RequestBody Address newAddress, @PathVariable ("id") int id, @PathVariable ("addressid") int addid) {
        return addressService.updateAddress(newAddress, addid);
    }

    @GetMapping("user/{id}/address/delete/{addressid}")
    public void deleteAddress (@PathVariable ("id") int id, @PathVariable ("addressid") int addid) {
        addressService.deleteAddressById(addid);
    }

    @GetMapping("user/checkusername/{name}")
    public String checkUserNameAvailaibility(@PathVariable("name") String name) {
        if (userService.checkUserNameAvailaibality(name)) {
            return "User name  availaible";
        }

        return "User name not availaible";
    }

    @GetMapping("user/get/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
