package com.gym.app.conversionUtils;

import java.util.ArrayList;
import java.util.List;

import com.gym.app.user.Address;
import com.gym.app.user.Payment;
import com.gym.app.user.SessionHistory;
import com.gym.app.user.Subscribtion;
import com.gym.app.user.Transactionhistory;
import com.gym.app.user.User;
import com.gym.app.user.entity.AddressEntity;
import com.gym.app.user.entity.PaymentEntity;
import com.gym.app.user.entity.SessionHistoryEntity;
import com.gym.app.user.entity.SubscribtionEntity;
import com.gym.app.user.entity.TransactionhistoryEntity;
import com.gym.app.user.entity.UserEntity;

public class ConvertToEntity {
	
	public static UserEntity ConvertUserToEntity(User user) {
		UserEntity userEntity = new UserEntity();
		if(user != null) {
			userEntity.setId(user.getId());
			userEntity.setName(user.getName());
			userEntity.setPassword(user.getPassword());
			userEntity.setPayment(converPaymentToEntity(user.getPayment()));
			userEntity.setSessionHistory(convertSessionHistoryToEntity(user.getSessionHistory()));
			userEntity.setSubscribtion(convertSubscribtionToEntity(user.getSubscribtion()));
			userEntity.setAddress(convertAddressToEntity(user.getAddress()));
			userEntity.setHistory(convertTransactionHistoryTOEntity(user.getHistory()));
		}
		return userEntity;
	}
	
	public static List<PaymentEntity> converPaymentToEntity(List<Payment> payments)
	{
		List<PaymentEntity> entities = new ArrayList<PaymentEntity>(); 
		for(Payment payment : payments)
		{
			PaymentEntity entity = new PaymentEntity();
			entity.setCardnumber(payment.getCardnumber());
			entity.setCardType(payment.getCardType());
			entity.setExpiryDate(payment.getExpiryDate());
			entity.setId(payment.getId());
			entities.add(entity);
		}
		
		return entities;
	}
	
	public static List<SessionHistoryEntity> convertSessionHistoryToEntity(List<SessionHistory> sessions)
	{
		List<SessionHistoryEntity> entities = new ArrayList<>();
		for(SessionHistory history : sessions)
		{
			SessionHistoryEntity entity = new SessionHistoryEntity();
			entity.setDate(history.getDate());
			entity.setId(history.getId());
			entity.setTime(history.getTime());
			entities.add(entity);
		}
		return entities;
	}
	
	public static AddressEntity convertAddressToEntity(Address address)
	{
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setAddress1(address.getAddress1());
		addressEntity.setAddress2(address.getAddress2());
		addressEntity.setCity(address.getCity());
		addressEntity.setCountry(address.getCountry());
		addressEntity.setId(address.getId());
		addressEntity.setPincode(address.getPincode());
		addressEntity.setState(address.getState());
		return addressEntity;
	}
	
	public static SubscribtionEntity convertSubscribtionToEntity(Subscribtion sub)
	{
		SubscribtionEntity entity = new SubscribtionEntity();
		entity.setActive(sub.isActive());
		entity.setExpirydate(sub.getExpirydate());
		entity.setId(sub.getId());
		entity.setNumberOfDays(sub.getNumberOfDays());
		entity.setPaidOn(sub.getPaidOn());
		return entity;
	}
	
	public static List<TransactionhistoryEntity> convertTransactionHistoryTOEntity(List<Transactionhistory> transactionhistories)
	{
		List<TransactionhistoryEntity> entities = new ArrayList<TransactionhistoryEntity>();
		for(Transactionhistory transactionhistory : transactionhistories)
		{
			TransactionhistoryEntity entity = new TransactionhistoryEntity();
			entity.setAmmount(transactionhistory.getAmmount());
			entity.setId(transactionhistory.getId());
			entity.getPayment().setCardnumber(transactionhistory.getPayment().getCardnumber());
			entity.getPayment().setCardType(transactionhistory.getPayment().getCardType());
			entity.getPayment().setExpiryDate(transactionhistory.getPayment().getExpiryDate());
			entity.getPayment().setId(transactionhistory.getId());
			entities.add(entity);
		}
		return entities;
	}

}
