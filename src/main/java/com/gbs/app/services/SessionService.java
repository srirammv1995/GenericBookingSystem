package com.gbs.app.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbs.app.conversionUtils.ConvertToDao;
import com.gbs.app.repositories.SessionRepository;
import com.gbs.app.repositories.UserRepository;
import com.gbs.app.session.Session;
import com.gbs.app.session.entity.SessionEntity;
import com.gbs.app.user.entity.UserEntity;

@Service
public class SessionService {

	@Autowired
	SessionRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	
	public SessionEntity createSession(String date,String time,Long userId)
	{
		SessionEntity sessionEntity = null;
		if(date!=null && userId!=null && time!=null)
		{
			sessionEntity = repository.findByDateAndTime(date, time);
			if(sessionEntity!=null)
			{
				sessionEntity = new SessionEntity();
			}
			Optional<UserEntity> userEntity = userRepository.findById(userId);
			if(userEntity!=null)
			{
				sessionEntity.getUsers().add(userEntity.get());
				sessionEntity.setUsercount(String.valueOf(Integer.valueOf(sessionEntity.getUsercount())+1));
			}
			sessionEntity.setDate(date);
			sessionEntity.setTime(time);
			repository.save(sessionEntity);
		}
		return sessionEntity;
	}


	public SessionEntity viewSession(String date, String time) {
		SessionEntity sessionEntity = null;
		if(date!=null  && time!=null)
		{
			sessionEntity = repository.findByDateAndTime(date, time);
			if(sessionEntity!=null)
			{
				sessionEntity = new SessionEntity();
			}
		}
		return sessionEntity;
	}


	public SessionEntity deleteSession(String date, String time, Long userId) {
		SessionEntity sessionEntity = null;
		if(date!=null && userId!=null && time!=null)
		{
			sessionEntity = repository.findByDateAndTime(date, time);
			for (UserEntity user : sessionEntity.getUsers())
			{
				if(user.getId()==userId)
				{
					sessionEntity.getUsers().remove(user);
					sessionEntity.setUsercount(String.valueOf(Integer.valueOf(sessionEntity.getUsercount())-1));
				}
			}
			repository.save(sessionEntity);
		}
		return sessionEntity;
	}
	
}
