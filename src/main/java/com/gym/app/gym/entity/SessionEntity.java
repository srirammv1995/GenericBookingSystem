package com.gym.app.gym.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.gym.app.user.User;
import com.gym.app.user.entity.UserEntity;

@Entity
public class SessionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String time;
	private String date;
	private String usercount;
	private List<Long> users;
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
	public List<Long> getUsers() {
		return users;
	}
	public void setUsers(List<Long> users) {
		this.users = users;
	}
}
