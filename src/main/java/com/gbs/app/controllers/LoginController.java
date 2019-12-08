package com.gbs.app.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@RequestMapping("auth")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("login")
	public UserLogin login(@RequestParam String username,@RequestParam String password)
	{
		return loginService.login(username, password);
	}
	
	@GetMapping("validate")
	public Claims validate(@RequestParam String token)
	{
		return JwtUtil.decodeJWT(token);
	}

}
