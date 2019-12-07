package com.gbs.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbs.app.conversionUtils.ConvertToDao;
import com.gbs.app.conversionUtils.ConvertToEntity;
import com.gbs.app.user.Address;
import com.gbs.app.user.User;
import com.gbs.app.user.entity.UserEntity;

@Service
public class AddressService {

	@Autowired
	UserService service;
	
	
	public User createOrUpdateAddress(Long id,Address address)
	{
		User user = null;
		if(id !=null && address !=null)
		{
			Optional<UserEntity> userEntityOptional = service.viewByUserId(id);
			UserEntity userEntity = userEntityOptional.get();
			user = ConvertToDao.EntityToUser(userEntity);
			if(user.getAddress()==null)
			{
				user.setAddress(address);	
			}
			userEntity = ConvertToEntity.ConvertUserToEntity(user);
			service.ModifyTheUser(user);
		}
		return user;
	}
	
	public User deleteAddress(Long id)
	{
		User user = null;
		if(id !=null)
		{
			Optional<UserEntity> userEntityOptional = service.viewByUserId(id);
			UserEntity userEntity = userEntityOptional.get();
			user = ConvertToDao.EntityToUser(userEntity);
			if(user.getAddress()!=null)
			{
				Address address = new Address();
				user.setAddress(address);
			}
			userEntity = ConvertToEntity.ConvertUserToEntity(user);
			service.ModifyTheUser(user);
		}
		return user;
	}
}
