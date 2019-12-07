package com.gym.app.gym;

import java.util.Date;
import java.util.List;

import com.gym.app.user.User;
import com.gym.app.user.entity.UserEntity;


public class Session {
	private Date date;
	private Long id;
	private String time;
	private String usercount;
	private List<UserEntity> users;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUsercount() {
		return usercount;
	}
	public void setUsercount(String usercount) {
		this.usercount = usercount;
	}
	public List<UserEntity> getUsers() {
		return users;
	}
	public void setUsers(List<UserEntity> list) {
		this.users = list;
	}
}
