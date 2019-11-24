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
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String password;
	@OneToOne
	private AddressEntity address;
	@OneToMany
	private List<PaymentEntity> payment = new ArrayList<>();
	@OneToMany
	private List<TransactionhistoryEntity> history = new ArrayList<>();
	private SubscribtionEntity subscribtion;
	@OneToMany
	private List<SessionHistoryEntity> sessionHistory = new ArrayList<>();

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

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public List<PaymentEntity> getPayment() {
		return payment;
	}

	public void setPayment(List<PaymentEntity> payment) {
		this.payment = payment;
	}

	public List<TransactionhistoryEntity> getHistory() {
		return history;
	}

	public void setHistory(List<TransactionhistoryEntity> history) {
		this.history = history;
	}

	public SubscribtionEntity getSubscribtion() {
		return subscribtion;
	}

	public void setSubscribtion(SubscribtionEntity subscribtion) {
		this.subscribtion = subscribtion;
	}

	public List<SessionHistoryEntity> getSessionHistory() {
		return sessionHistory;
	}

	public void setSessionHistory(List<SessionHistoryEntity> sessionHistory) {
		this.sessionHistory = sessionHistory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
