package com.gym.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gym.app.services.TransactionService;
import com.gym.app.user.Payment;
import com.gym.app.user.User;

@RestController
@RequestMapping("transaction")
public class TransactionController {
	
	@Autowired
	TransactionService service;
	
	@PostMapping("create")
	public User createTransaction(@RequestParam Long id,@RequestBody Payment payment,@RequestParam Long ammount)
	{
		return service.createTransaction(id, payment, ammount);
	}

}
