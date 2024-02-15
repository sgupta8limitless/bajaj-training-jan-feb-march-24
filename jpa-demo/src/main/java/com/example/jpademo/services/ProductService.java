package com.example.jpademo.services;

import com.example.jpademo.models.Product;
import com.example.jpademo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll()
    {
        return productRepository.findAll();
    }


    public Product create(Product product)
    {
        return productRepository.save(product);
    }


}
