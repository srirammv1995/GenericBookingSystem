package com.gym.app.user.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String password;
	@OneToOne
	private Address address;
	@OneToMany
	private List<Payment> payment = new ArrayList<>();
	@OneToMany
	private List<Transactionhistory> history = new ArrayList<>();
	private Subscribtion subscribtion;
	@OneToMany
	private List<SessionHistory> sessionHistory = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	public List<Transactionhistory> getHistory() {
		return history;
	}

	public void setHistory(List<Transactionhistory> history) {
		this.history = history;
	}

	public Subscribtion getSubscribtion() {
		return subscribtion;
	}

	public void setSubscribtion(Subscribtion subscribtion) {
		this.subscribtion = subscribtion;
	}

	public List<SessionHistory> getSessionHistory() {
		return sessionHistory;
	}

	public void setSessionHistory(List<SessionHistory> sessionHistory) {
		this.sessionHistory = sessionHistory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
