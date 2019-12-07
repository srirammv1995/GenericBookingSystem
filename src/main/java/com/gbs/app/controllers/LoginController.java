package com.gbs.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gbs.app.Response.UserResponse;
import com.gbs.app.repositories.UserRepository;

@RestController
@RequestMapping("user")
public class LoginController {
	
	@SuppressWarnings("rawtypes")
	@Autowired
	RedisTemplate redisTemplate;
	
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("login")
	public UserResponse login(@RequestParam String username,@RequestParam String password)
	{
		
		return null;
	}

}
