package com.gbs.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gbs.app.services.UserService;
import com.gbs.app.user.User;
import com.gbs.app.user.entity.UserEntity;

import springfox.documentation.service.Header;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public UserEntity createUser(@RequestBody User user) {
		
		return userService.createUser(user);
	}
	
	@GetMapping("/viewByName")
	public User viewByUserName(@RequestParam String name,@RequestHeader(value="x-auth-token") String authtoken,@RequestParam(required = false) Long userId)
	{
	
		return userService.viewByUserName(name);
	}
	
	@GetMapping("/viewById")
	public UserEntity viewByUserId(@RequestHeader(value="x-auth-token") String authtoken,@RequestParam(required = false) Long userId)
	{
	
		return userService.viewByUserId(userId).get();
	}
	
	@PutMapping("modify")
	public UserEntity ModifyTheUser(@RequestBody User user,@RequestHeader(value="x-auth-token") String authtoken,@RequestParam(required = false) Long userId)
	{
		
		return userService.ModifyTheUser(user);
	}
	
	@DeleteMapping("delete")
	public UserEntity Deleteuser(@RequestParam String name,@RequestHeader(value="x-auth-token") String authtoken,@RequestParam(required = false) Long userId)
	{
		
		return userService.Deleteuser(name);
		
	}
	
	@GetMapping("all")
	public List<UserEntity> findall() {
		return userService.findall();
	}

}
