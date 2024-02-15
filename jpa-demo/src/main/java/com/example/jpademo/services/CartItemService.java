package com.example.jpademo.services;

import com.example.jpademo.exceptions.EntityNotFoundException;
import com.example.jpademo.models.CartItem;
import com.example.jpademo.models.Customer;
import com.example.jpademo.models.Product;
import com.example.jpademo.repositories.CartItemRepository;
import com.example.jpademo.repositories.CustomerRepository;
import com.example.jpademo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public CartItem create(CartItem cartItem)
    {
        Optional<Product> productOptional = productRepository.findById(cartItem.getProduct().getId());

        Optional<Customer> customerOptional = customerRepository.findById(cartItem.getCustomer().getId());


        if(productOptional.isPresent() && customerOptional.isPresent() && cartItem.getQuantity()>0)
        {
            return cartItemRepository.save(cartItem);
        }

        throw new EntityNotFoundException("Product or Customer with given Id Doesnt Exist");

    }


    public List<Product> getCustomerCart(Long customer_id)
    {
        Optional<Customer> customerOptional = customerRepository.findById(customer_id);

        if(customerOptional.isPresent())
        {
            List<CartItem> cartItems = cartItemRepository.findByCustomer(customerOptional.get());

            if(cartItems.size()>0)
            {
                List<Product> products = cartItems.stream().map((cartItem -> cartItem.getProduct())).toList();
                return products;

            }


        }

        throw new EntityNotFoundException("Customer Doesnt Exist");

    }




}
