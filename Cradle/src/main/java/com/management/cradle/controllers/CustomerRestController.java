package com.management.cradle.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.cradle.dao.CustomerDAO;
import com.management.cradle.model.Customer;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerRestController {

	@Autowired
	CustomerDAO customerDAO;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Customer> getAllCustomer(){
		
		return customerDAO.getAllCustomers();
	}
	
	@PostMapping(value="/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void registerCustomer(@RequestBody Customer customer) {
		
		System.out.println(customer);
		customerDAO.registerCustomer(customer);
	}
	
	@PostMapping(value="/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public  Collection<Customer> loginCustomer(@RequestBody Customer cust)
	{
		System.out.println(cust);
		 return customerDAO.loginCustomer(cust);
	}
	
}
