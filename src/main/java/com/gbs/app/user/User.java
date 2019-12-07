package com.gbs.app.user;

import java.util.ArrayList;
import java.util.List;

public class User {
	private Long id;
	private String name;
	private String password;
	private Address address;
	private List<Payment> payment = new ArrayList<>();
	private List<Transactionhistory> history = new ArrayList<>();
	private Subscribtion subscribtion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	private List<SessionHistory> sessionHistory = new ArrayList<>();

	
}
