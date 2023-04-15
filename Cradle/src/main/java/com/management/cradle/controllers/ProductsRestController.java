package com.management.cradle.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.management.cradle.dao.ProductsDAO;
import com.management.cradle.model.Products;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductsRestController {

	@Autowired
	ProductsDAO productsDAO;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Products> getAllProduct(){
		
		return productsDAO.getAllProducts();
		
	}
}
