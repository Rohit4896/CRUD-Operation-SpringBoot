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

import com.management.cradle.dao.PaymentDAO;
import com.management.cradle.model.PaymentInfo;





@RestController
@CrossOrigin
@RequestMapping("/payment")
public class PaymentRestController {

	@Autowired
	PaymentDAO paymentDAO;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<PaymentInfo> getAllPaymentDetails(){
		
		return paymentDAO.getAllPaymentDetails();
		
	}
	
	@PostMapping(value="/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void savePaymentDetails(@RequestBody PaymentInfo payment) {
		
//		System.out.println(payment);
		paymentDAO.savePaymentDetails(payment);
	}
}
