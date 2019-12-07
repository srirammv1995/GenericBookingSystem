package com.gym.app.user;

public class Transactionhistory {
	private Long id;
	private Payment payment;
	private Long ammount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Payment getPayment() {
		if (payment == null) {
			return new Payment();
		} else
			return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Long getAmmount() {
		return ammount;
	}

	public void setAmmount(Long ammount) {
		this.ammount = ammount;
	}

}
