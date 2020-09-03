package com.example.userdatamicroservice.Service;

import com.example.userdatamicroservice.Models.Address;
import com.example.userdatamicroservice.Repository.AddressRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public Address getAddressById(int id) {
        return addressRepository.findById(id).get();
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Address newAddress, int id) {
        return addressRepository.findById(id).map(address -> {
            address.setCity(newAddress.getCity());
            address.setCountry(newAddress.getCountry());
            address.setLine1(newAddress.getLine1());
            address.setLine2(newAddress.getLine2());
            address.setName(newAddress.getName());
            address.setPincode(newAddress.getPincode());
            address.setState(newAddress.getState());
            return addressRepository.save(address);
        }).orElseThrow(() -> new ResourceNotFoundException(id + "not found"));
    }

    public void deleteAddressById(int id) {
        addressRepository.deleteById(id);
    }

}
