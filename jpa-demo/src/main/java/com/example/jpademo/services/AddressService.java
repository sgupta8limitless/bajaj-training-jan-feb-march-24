package com.example.jpademo.services;

import com.example.jpademo.models.Address;
import com.example.jpademo.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAll()
    {
        return addressRepository.findAll();
    }


    public Address create(Address address)
    {
        Address newAddress = addressRepository.save(address);
        return newAddress;

    }






}
