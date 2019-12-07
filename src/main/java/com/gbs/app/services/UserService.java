package com.gbs.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.gbs.app.conversionUtils.ConvertToDao;
import com.gbs.app.conversionUtils.ConvertToEntity;
import com.gbs.app.repositories.UserRepository;
import com.gbs.app.user.User;
import com.gbs.app.user.entity.UserEntity;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public UserEntity createUser(@RequestBody User user) {
		UserEntity userEntity = null;
		if(user != null)
		{
			userEntity = ConvertToEntity.ConvertUserToEntity(user);
		}
		return userRepo.save(userEntity);
	}
	
	public User viewByUserName(@RequestParam String name)
	{
		UserEntity userEntity = null;
		if(name !=null && !name.isEmpty())
		{
			userEntity =userRepo.findByName(name);
		}
		return ConvertToDao.EntityToUser(userEntity);
	}
	
	public Optional<UserEntity> viewByUserId(@RequestParam Long id)
	{
		Optional<UserEntity> userEntity = null;
		if(id !=null)
		{
			userEntity =userRepo.findById(id);
		}
		return userEntity;
	}
	
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
	
	public UserEntity Deleteuser(@RequestParam String name)
	{
		if(name!=null & !name.isEmpty())
		{
			userRepo.deleteByName(name);
		}
		return null;
		
	}

	public List<UserEntity> findall() {
		return userRepo.findAll();
	}

}
