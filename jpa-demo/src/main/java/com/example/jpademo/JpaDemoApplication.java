package com.example.jpademo;

import com.example.jpademo.models.Address;
import com.example.jpademo.models.Customer;
import com.example.jpademo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public abstract class JpaDemoApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {


		Customer customer = new Customer("Saurabh","sgupta@gmail.com","1234",23);

		Address address1= new Address(201,"Dummy 1","Mumbai",6757);
		address1.setCustomer(customer);
		Address address2= new Address(2301,"Dummy 2","Bengaluru",6707);
		address2.setCustomer(customer);


		List<Address> addr = new ArrayList<>();
		addr.add(address1);
		addr.add(address2);

		customer.setAddresses(addr);


		customerRepository.save(customer);






	}
}
