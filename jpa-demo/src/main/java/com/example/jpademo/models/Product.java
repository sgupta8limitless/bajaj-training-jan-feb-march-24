package com.example.jpademo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @ManyToMany(mappedBy = "products")
//    private List<Customer> customers;

    @OneToMany(mappedBy = "product")
    private List<Cart> carts;



}
