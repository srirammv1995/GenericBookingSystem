package com.gym.app.user;

public class User {
private Long id;
private String name;
private String password;
private Address address;
private Payment payment;
private Transactionhistory history;
private Subscribtion subscribtion;
private SessionHistory sessionHistory;
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
public Payment getPayment() {
	return payment;
}
public void setPayment(Payment payment) {
	this.payment = payment;
}
public Transactionhistory getHistory() {
	return history;
}
public void setHistory(Transactionhistory history) {
	this.history = history;
}
public Subscribtion getSubscribtion() {
	return subscribtion;
}
public void setSubscribtion(Subscribtion subscribtion) {
	this.subscribtion = subscribtion;
}
public SessionHistory getSessionHistory() {
	return sessionHistory;
}
public void setSessionHistory(SessionHistory sessionHistory) {
	this.sessionHistory = sessionHistory;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}


}
