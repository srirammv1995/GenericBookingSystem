package com.gbs.app.session.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.gbs.app.user.User;
import com.gbs.app.user.entity.UserEntity;

@Entity
public class SessionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String time;
	private String date;
	private String usercount;
	@ManyToMany
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
		if(usercount!=null)
		return usercount;
		else
		return String.valueOf(0);
	}
	public void setUsercount(String usercount) {
		this.usercount = usercount;
	}
	public List<UserEntity> getUsers() {
		if(users!=null)
		return users;
		else
			return new ArrayList<UserEntity>();
	}
	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
}
