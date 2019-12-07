package com.gbs.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbs.app.conversionUtils.ConvertToDao;
import com.gbs.app.conversionUtils.ConvertToEntity;
import com.gbs.app.user.Address;
import com.gbs.app.user.Subscribtion;
import com.gbs.app.user.User;
import com.gbs.app.user.entity.UserEntity;

@Service
public class SubscriptionService {

	@Autowired
	UserService service;
	
	
	public User createOrUpdateSubscription(Long id,Subscribtion subscription)
	{
		User user = null;
		if(id !=null && subscription !=null)
		{
			Optional<UserEntity> userEntityOptional = service.viewByUserId(id);
			UserEntity userEntity = userEntityOptional.get();
			user = ConvertToDao.EntityToUser(userEntity);
			user.setSubscribtion(subscription);	
			userEntity = ConvertToEntity.ConvertUserToEntity(user);
			service.ModifyTheUser(user);
		}
		return user;
	}
	
	public User deleteSubscription(Long id)
	{
		User user = null;
		if(id !=null)
		{
			Optional<UserEntity> userEntityOptional = service.viewByUserId(id);
			UserEntity userEntity = userEntityOptional.get();
			user = ConvertToDao.EntityToUser(userEntity);
			if(user.getSubscribtion()!=null)
			{
				Subscribtion subscribtion = new Subscribtion();
				user.setSubscribtion(subscribtion);
			}
			userEntity = ConvertToEntity.ConvertUserToEntity(user);
			service.ModifyTheUser(user);
		}
		return user;
	}
	
	public User toggleSubscription(Long id)
	{
		User user = null;
		if(id !=null)
		{
			Optional<UserEntity> userEntityOptional = service.viewByUserId(id);
			UserEntity userEntity = userEntityOptional.get();
			user = ConvertToDao.EntityToUser(userEntity);
			if(user.getSubscribtion()!=null)
			{
				user.getSubscribtion().setActive(!user.getSubscribtion().isActive());
			}
			userEntity = ConvertToEntity.ConvertUserToEntity(user);
			service.ModifyTheUser(user);
		}
		return user;
	}
}
