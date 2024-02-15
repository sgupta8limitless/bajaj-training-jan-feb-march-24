package com.example.jpademo.controllers;

import com.example.jpademo.beans.ResponseHandler;
import com.example.jpademo.models.Customer;
import com.example.jpademo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @GetMapping("/")
    public ResponseEntity<?> getAll()
    {
        return ResponseHandler.createResponse("Found Customers",HttpStatus.OK,customerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id)
    {
        Customer customer = customerService.get(id);
        return ResponseHandler.createResponse("Found",HttpStatus.OK,customer);

    }

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody Customer customer)
    {

        Customer createdCustomer = customerService.create(customer);
        return ResponseHandler.createResponse("Created",HttpStatus.CREATED,createdCustomer);



    }




}
