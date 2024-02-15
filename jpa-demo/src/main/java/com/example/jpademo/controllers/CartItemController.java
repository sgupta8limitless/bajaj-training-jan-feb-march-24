package com.example.jpademo.controllers;

import com.example.jpademo.beans.ResponseHandler;
import com.example.jpademo.models.CartItem;
import com.example.jpademo.models.Product;
import com.example.jpademo.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/addtocart")
    public ResponseEntity<Object> create(@RequestBody CartItem cartItem)
    {
        CartItem newCartItem = cartItemService.create(cartItem);

        return ResponseHandler.createResponse("Added To Cart", HttpStatus.CREATED,newCartItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCartProducts(@PathVariable Long id)
    {
        List<Product> products = cartItemService.getCustomerCart(id);

        return ResponseHandler.createResponse("Found",HttpStatus.OK,products);

    }


}
