package com.gbs.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
	public User createPayment(@RequestBody Payment payment,@RequestHeader(value="x-auth-token") String authtoken,@RequestParam(required = false) Long userId)
	{
		return service.createorUpdatePayment(userId, payment);
	}
	
	@PutMapping("update")
	public User updatePayment(@RequestBody Payment payment,@RequestHeader(value="x-auth-token") String authtoken,@RequestParam(required = false) Long userId)
	{
		return service.createorUpdatePayment(userId, payment);
	}
	
	@DeleteMapping("delete")
	public User deletePayment(@RequestParam Long paymentid,@RequestHeader(value="x-auth-token") String authtoken,@RequestParam(required = false) Long userId)
	{
		return service.deletePayment(userId, paymentid);
	}

}
