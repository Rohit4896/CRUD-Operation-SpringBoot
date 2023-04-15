package com.management.cradle.dao;

import java.time.LocalDate;

import java.util.Collection;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.management.cradle.model.Counters;
import com.management.cradle.model.PaymentInfo;

import jakarta.persistence.EntityManager;


@Repository
public class PaymentDAO {

	@Autowired
	EntityManager entityManager;
	
	public Collection<PaymentInfo> getAllPaymentDetails(){
		
		try {
			
			return entityManager.createQuery("From Payment", PaymentInfo.class).getResultList();
			
		} catch(Exception e) {
			
			throw new RuntimeException(e);
		}
	}
	
	@Transactional
	public void savePaymentDetails(PaymentInfo payment){
		try {
			
			Counters counterPaymentId = entityManager.find(Counters.class,"payment");			
			 
			String PaymentId = counterPaymentId.getInitialValue() + counterPaymentId.nextValue();	
			
			LocalDate today = LocalDate.now();
			LocalDate paymentDate = today.plusDays(+0);
			
			OrdersDAO ordersDAO = new OrdersDAO();
			
		
			payment.setPaymentId(PaymentId);
			payment.setPaymentDate(paymentDate);
			payment.setOrderId(OrdersDAO.ordId);
			payment.setCardCVV(payment.getCardCVV());
			payment.setCardExpiryDate(payment.getCardExpiryDate());
			payment.setCardHolderName(payment.getCardHolderName());
			payment.setCardNumber(payment.getCardNumber());
			payment.setAmount(payment.getAmount());

			System.out.println("PaymentInfo = [paymentId = " + PaymentId + " cardNumber = " + payment.getCardNumber() + 
			" cardCVV = " +  payment.getCardCVV() + " cardExpiryDate = " + payment.getCardExpiryDate() +
			" cardHolderName = " + payment.getCardHolderName() + "]");
			
			entityManager.persist(payment);

		}
		catch (Exception e) 
		{
			throw new RuntimeException(e);
		}
	}
	
}
