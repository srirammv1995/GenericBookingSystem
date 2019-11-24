package com.gym.app.user;

public class Subscribtion {
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private boolean isActive = false;
	private String paidOn;
	private int numberOfDays;
	private String expirydate;
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getPaidOn() {
		return paidOn;
	}
	public void setPaidOn(String paidOn) {
		this.paidOn = paidOn;
	}
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public String getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}
}
