package com.gym.app.user;

import java.util.List;

public class Transactionhistory {
	private Long id;
	private List<Payment> payment;
	private Long ammount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Payment> getPayment() {
		return payment;
	}
	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}
	public Long getAmmount() {
		return ammount;
	}
	public void setAmmount(Long ammount) {
		this.ammount = ammount;
	}

}
