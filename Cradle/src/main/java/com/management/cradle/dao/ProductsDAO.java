package com.management.cradle.dao;

import java.util.Collection;


import org.springframework.stereotype.Repository;

import com.management.cradle.model.Products;

import jakarta.persistence.*;

@Repository
public class ProductsDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Collection<Products> getAllProducts(){
		
		try {
			
			return entityManager.createQuery("From Products", Products.class).getResultList();
			
		} catch(Exception e) {
			
			throw new RuntimeException(e);
		}
	}
}
