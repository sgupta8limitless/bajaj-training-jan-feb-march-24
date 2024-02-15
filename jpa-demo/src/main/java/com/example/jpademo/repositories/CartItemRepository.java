package com.example.jpademo.repositories;

import com.example.jpademo.models.CartItem;
import com.example.jpademo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    public List<CartItem> findByCustomer(Customer customer);

}
