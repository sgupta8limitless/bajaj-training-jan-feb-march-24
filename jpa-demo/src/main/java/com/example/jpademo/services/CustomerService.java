package com.example.jpademo.services;

import com.example.jpademo.exceptions.EntityAlreadyExistsException;
import com.example.jpademo.exceptions.EntityNotFoundException;
import com.example.jpademo.models.Customer;
import com.example.jpademo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

//    to fetch all customers
    public List<Customer> getAll()
    {
        return customerRepository.findAll();
    }


//    to fetch customer based on id
    public Customer get(Long id)
    {
         Optional<Customer> customerOptional =  customerRepository.findById(id);
         if(customerOptional.isPresent())
         {
             Customer customer = customerOptional.get();
             return customer;

         }

         throw new EntityNotFoundException("Customer With given ID is not present");
    }

//    to create a new customer
    public Customer create(Customer customer)
    {
        if(customerRepository.findByEmail(customer.getEmail()).isEmpty())
        {
            Customer newCustomer = customerRepository.save(customer);
            return newCustomer;

        }

        throw new EntityAlreadyExistsException("Customer with this email already exists");


    }




}
