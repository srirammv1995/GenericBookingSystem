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

import com.gbs.app.services.SubscriptionService;
import com.gbs.app.user.Subscribtion;
import com.gbs.app.user.User;

@RestController
@RequestMapping("subscription")
public class SubscriptionController {
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@PostMapping("create")
	public User createSubscription(@RequestBody Subscribtion subscribtion,@RequestHeader(value="x-auth-token") String authtoken,@RequestParam(required = false) Long userId)
	{
		return subscriptionService.createOrUpdateSubscription(userId, subscribtion);
	}

	@PutMapping("update")
	public User updateSubscription(@RequestBody Subscribtion subscribtion,@RequestHeader(value="x-auth-token") String authtoken,@RequestParam(required = false) Long userId)
	{
		return subscriptionService.createOrUpdateSubscription(userId, subscribtion);
	}
	
	@DeleteMapping("delete")
	public User deleteSubscription(@RequestHeader(value="x-auth-token") String authtoken,@RequestParam(required = false) Long userId)
	{
		return subscriptionService.deleteSubscription(userId);
	}
	
	@PutMapping("toggle")
	public User toggleSubscription(@RequestHeader(value="x-auth-token") String authtoken,@RequestParam(required = false) Long userId)
	{
		return subscriptionService.toggleSubscription(userId);
	}
	
	
}
