package com.gbs.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gbs.app.jwt.JwtUtil;
import com.gbs.app.services.LoginService;
import com.gbs.app.user.UserLogin;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("user")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("login")
	public UserLogin login(@RequestParam String username,@RequestParam String password)
	{
		return loginService.login(username, password);
	}
	
	@GetMapping("validate")
	public Claims login(@RequestParam String token)
	{
		return JwtUtil.decodeJWT(token);
	}

}
