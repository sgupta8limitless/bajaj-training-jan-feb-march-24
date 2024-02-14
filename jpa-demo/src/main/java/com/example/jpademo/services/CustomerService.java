package com.example.jpademo.services;

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
    public List<Customer> getAll()
    {
        return customerRepository.findAll();
    }


    public Optional<Customer> get(Long id)
    {
        return customerRepository.findById(id);
    }

    public Object create(Customer customer)
    {
        if(customerRepository.findByEmail(customer.getEmail()).isEmpty())
        {
            Customer newCustomer = customerRepository.save(customer);
            newCustomer.setPassword(null);
            return newCustomer;


        }

       return null;


    }

}
