package com.gbs.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.gbs.app.constants.Constants;
import com.gbs.app.jwt.JwtUtil;
import com.gbs.app.repositories.UserRepository;
import com.gbs.app.user.UserLogin;
import com.gbs.app.user.entity.UserEntity;

@Service
public class LoginService {

	@Autowired
	UserRepository userRepository;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	RedisTemplate redisTemplate;
	
	@SuppressWarnings("unchecked")
	public UserLogin login(String username,String password)
	{
		UserLogin user = new UserLogin();
		UserEntity userEntity = userRepository.findByNameAndPassword(username, password);
		if(userEntity !=null)
		{
			String Token = JwtUtil.createJWT(String.valueOf(userEntity.getId()),userEntity.getName() ,userEntity.getName(), Long.valueOf(900000));
			user.setId(userEntity.getId());
			user.setUsername(username);
			user.setAuthToken(Token);
			user.setStatus(Constants.LOGIN_SUCCESS);
			redisTemplate.opsForHash().put(user.getId(), Constants.AUTH_KEY,user.getAuthToken());
		}
		else
		{
			user.setStatus(Constants.LOGIN_FAIL);
		}
		return user;
	}
}
