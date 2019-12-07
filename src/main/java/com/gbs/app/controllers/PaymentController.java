package com.gbs.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gbs.app.services.PaymentService;
import com.gbs.app.user.Payment;
import com.gbs.app.user.User;

@RestController
@RequestMapping("payment")
public class PaymentController {
	
	@Autowired
	PaymentService service;
	
	
	@PostMapping("create")
	public User createPayment(@RequestParam Long id,@RequestBody Payment payment)
	{
		return service.createorUpdatePayment(id, payment);
	}
	
	@PutMapping("update")
	public User updatePayment(@RequestParam Long id,@RequestBody Payment payment)
	{
		return service.createorUpdatePayment(id, payment);
	}
	
	@DeleteMapping("delete")
	public User deletePayment(@RequestParam Long id,@RequestParam Long paymentid)
	{
		return service.deletePayment(id, paymentid);
	}

}
