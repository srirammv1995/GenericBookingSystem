package com.gbs.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gbs.app.services.TransactionService;
import com.gbs.app.user.Payment;
import com.gbs.app.user.User;

@RestController
@RequestMapping("transaction")
public class TransactionController {
	
	@Autowired
	TransactionService service;
	
	@PostMapping("create")
	public User createTransaction(@RequestHeader(value="x-auth-token") String authtoken,@RequestParam(required = false) Long userId,@RequestBody Payment payment,@RequestParam Long ammount)
	{
		return service.createTransaction(userId, payment, ammount);
	}

}
