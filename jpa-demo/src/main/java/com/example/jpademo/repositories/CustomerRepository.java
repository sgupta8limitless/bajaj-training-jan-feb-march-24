package com.example.jpademo.repositories;

import com.example.jpademo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByEmailAndAge(String email,int age);

    List<Customer> findByEmailOrAge(String email, int age);

    @Query("select c from Customer c where c.name = ?1 and c.age = ?2")
    List<Customer> findCustomers(String name,int age);

}
