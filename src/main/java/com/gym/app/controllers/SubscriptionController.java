package com.gym.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gym.app.services.SubscriptionService;
import com.gym.app.user.Subscribtion;
import com.gym.app.user.User;

@RestController
@RequestMapping("subscription")
public class SubscriptionController {
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@PostMapping("create")
	public User createSubscription(@RequestParam Long id,@RequestBody Subscribtion subscribtion)
	{
		return subscriptionService.createOrUpdateSubscription(id, subscribtion);
	}

	@PutMapping("update")
	public User updateSubscription(@RequestParam Long id,@RequestBody Subscribtion subscribtion)
	{
		return subscriptionService.createOrUpdateSubscription(id, subscribtion);
	}
	
	@DeleteMapping("delete")
	public User deleteSubscription(@RequestParam Long id)
	{
		return subscriptionService.deleteSubscription(id);
	}
	
	@PutMapping("toggle")
	public User toggleSubscription(@RequestParam Long id)
	{
		return subscriptionService.toggleSubscription(id);
	}
	
	
}
