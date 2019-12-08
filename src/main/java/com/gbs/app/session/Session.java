package com.gbs.app.session;

import java.util.Date;
import java.util.List;

import com.gbs.app.user.User;
import com.gbs.app.user.entity.UserEntity;


public class Session {
	private String date;
	private Long id;
	private String time;
	private String usercount;
	private List<UserEntity> users;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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
