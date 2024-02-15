package com.example.jpademo.repositories;

import com.example.jpademo.models.Address;
import com.example.jpademo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {

    public List<Address> findByCustomer(Customer customer);

}
