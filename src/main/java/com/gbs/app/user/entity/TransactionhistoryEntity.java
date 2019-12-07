package com.gbs.app.user.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class TransactionhistoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@OneToOne
	private PaymentEntity payment;
	private Long ammount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public PaymentEntity getPayment() {
		if(payment!=null)
		return payment;
		else
			return new PaymentEntity();
	}
	public void setPayment(PaymentEntity payment) {
		this.payment = payment;
	}
	public Long getAmmount() {
		return ammount;
	}
	public void setAmmount(Long ammount) {
		this.ammount = ammount;
	}

}
