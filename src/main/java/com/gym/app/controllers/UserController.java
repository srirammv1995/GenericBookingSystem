package com.gym.app.controllers;

import org.hibernate.boot.model.convert.spi.ConverterDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gym.app.conversionUtils.ConvertToDao;
import com.gym.app.conversionUtils.ConvertToEntity;
import com.gym.app.repositories.UserRepository;
import com.gym.app.user.User;
import com.gym.app.user.entity.UserEntity;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/create")
	public UserEntity createUser(@RequestBody User user) {
		UserEntity userEntity = null;
		if(user != null)
		{
			userEntity = ConvertToEntity.ConvertUserToEntity(user);
			userRepo.save(userEntity);
		}
		return userEntity;
	}
	
	@GetMapping("/view")
	public User viewByUserName(@RequestParam String name)
	{
		UserEntity userEntity = null;
		if(name !=null && !name.isEmpty())
		{
			userEntity =userRepo.findByName(name);
		}
		return ConvertToDao.EntityToUser(userEntity);
	}
	
	@PutMapping("modify")
	public UserEntity ModifyTheUser(@RequestBody User user)
	{
		UserEntity userEntity = null;
		if(user !=null)
		{
			userEntity = ConvertToEntity.ConvertUserToEntity(user);
			userEntity = userRepo.save(userEntity);
		}
		return userEntity;
	}
	
	@DeleteMapping("delete")
	public UserEntity Deleteuser(@RequestParam String name)
	{
		UserEntity userEntity = null;
		if(name!=null & !name.isEmpty())
		{
			userRepo.deleteByName(name);
		}
		return null;
		
	}

}
