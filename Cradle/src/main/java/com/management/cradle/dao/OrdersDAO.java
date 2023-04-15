package com.management.cradle.dao;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.management.cradle.model.Counters;
import com.management.cradle.model.Orders;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Repository
public class OrdersDAO {
		
	static String ordId;
	LocalDate today = LocalDate.now();

	@Autowired
	EntityManager entityManager;
		
	public Collection<Orders> getAllOrderDetails(){
			
	try {
				
			return entityManager.createQuery("From Orders", Orders.class).getResultList();
				
		} catch(Exception e) {
				
			throw new RuntimeException(e);
		}
	}
		
	@Transactional
	public void saveOrdersDetails(Orders orders){
		try {

			Counters counterOrderId = entityManager.find(Counters.class, "order");
				 
			String OrderId = counterOrderId.getInitialValue() + counterOrderId.nextValue();
			ordId = OrderId;
				
			LocalDate orderDate = today.plusDays(+0);
			LocalDate DeliveryDate = today.plusDays(+10);
								
			orders.setOrderId(OrderId);
			orders.setOrderDate(orderDate);
			orders.setDeliveryDate(DeliveryDate);
			orders.setCustomerId(orders.getCustomerId());
			orders.setQuantity(orders.getQuantity());
				
			System.out.println("Order = [orderId = " + OrderId + " orderDate = " + orderDate + " deliveryDate = " + DeliveryDate + 
			"customerId = " + orders.getCustomerId() + " productId = " + orders.getProductId() + " quantity =" + orders.getQuantity() + "]");
				
			entityManager.persist(orders);
				
			} catch (Exception e) {
				
				throw new RuntimeException(e);
				
			}
		}
	

	
}







