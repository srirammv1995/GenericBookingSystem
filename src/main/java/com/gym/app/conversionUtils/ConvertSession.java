package com.gym.app.conversionUtils;

import com.gym.app.gym.Session;
import com.gym.app.gym.entity.SessionEntity;

public class ConvertSession {

	
	public static Session convertSessionEntityToSessionDao(SessionEntity entity)
	{
		Session session = new Session();
		session.setDate(entity.getDate());
		session.setId(entity.getId());
		session.setTime(entity.getTime());
		session.setUsercount(entity.getUsercount());
		session.setUsers(entity.getUsers());
		
		return session;
	}
	
	public static SessionEntity convertSessionDaoToSessionEntity(Session session)
	{
		SessionEntity sessionentity = new SessionEntity();
		sessionentity.setDate(session.getDate());
		sessionentity.setId(session.getId());
		sessionentity.setTime(session.getTime());
		sessionentity.setUsercount(session.getUsercount());
		sessionentity.setUsers(session.getUsers());
		
		return sessionentity;
	}
}
