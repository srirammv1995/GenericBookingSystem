package com.gbs.app.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbs.app.services.SessionService;
import com.gbs.app.session.entity.SessionEntity;

@RestController
@RequestMapping("session")
public class SessionController {
	
	@Autowired
	SessionService sessionService;
	
	@PostMapping("create")
	public SessionEntity createSession(Date date,String time,Long userId)
	{
		return sessionService.createSession(date, time, userId);
	}
	
	@GetMapping("create")
	public SessionEntity ViewSession(Date date,String time)
	{
		return sessionService.viewSession(date, time);
	}
	
	@DeleteMapping("create")
	public SessionEntity deleteSession(Date date,String time,Long userId)
	{
		return sessionService.deleteSession(date, time, userId);
	}

}
