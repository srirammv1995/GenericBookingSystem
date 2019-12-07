package com.gbs.app.conversionUtils;

import java.util.ArrayList;
import java.util.List;

import com.gbs.app.user.Address;
import com.gbs.app.user.Payment;
import com.gbs.app.user.SessionHistory;
import com.gbs.app.user.Subscribtion;
import com.gbs.app.user.Transactionhistory;
import com.gbs.app.user.User;
import com.gbs.app.user.entity.AddressEntity;
import com.gbs.app.user.entity.PaymentEntity;
import com.gbs.app.user.entity.SessionHistoryEntity;
import com.gbs.app.user.entity.SubscribtionEntity;
import com.gbs.app.user.entity.TransactionhistoryEntity;
import com.gbs.app.user.entity.UserEntity;

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
			if(transactionhistory.getPayment().getCardnumber()!=null)
			{
				entity.getPayment().setCardnumber(transactionhistory.getPayment().getCardnumber());				
			}
			if(transactionhistory.getPayment().getCardType()!=null)
			{
				entity.getPayment().setCardType(transactionhistory.getPayment().getCardType());	
			}
			if(transactionhistory.getPayment().getExpiryDate()!=null)
			{
				entity.getPayment().setExpiryDate(transactionhistory.getPayment().getExpiryDate());
			}
			if(transactionhistory.getId()!=null)
			{
				entity.getPayment().setId(transactionhistory.getId());
			}
			
			entities.add(entity);
		}
		return entities;
	}

}
