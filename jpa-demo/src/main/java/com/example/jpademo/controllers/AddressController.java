package com.example.jpademo.controllers;

import com.example.jpademo.beans.ResponseHandler;
import com.example.jpademo.models.Address;
import com.example.jpademo.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {


    @Autowired
    private AddressService addressService;

    @GetMapping("/")
    public ResponseEntity<Object> getAll()
    {
        return ResponseHandler.createResponse("Found", HttpStatus.OK,addressService.getAll());
    }


    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody Address address)
    {
        Address newAddress = addressService.create(address);
        return ResponseHandler.createResponse("Created",HttpStatus.CREATED,newAddress);
    }

}
