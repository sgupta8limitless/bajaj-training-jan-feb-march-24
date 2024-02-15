package com.example.jpademo.controllers;

import com.example.jpademo.beans.ResponseHandler;
import com.example.jpademo.models.Product;
import com.example.jpademo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<Object> getAll()
    {
        return ResponseHandler.createResponse("Found", HttpStatus.OK,productService.getAll());
    }


    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody Product product)
    {
        Product newProduct = productService.create(product);
        return ResponseHandler.createResponse("Created", HttpStatus.CREATED,newProduct);

    }


}
