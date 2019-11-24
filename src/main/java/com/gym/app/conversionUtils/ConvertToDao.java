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

public class ConvertToDao {
	public static User ConvertUserToEntity(UserEntity userEntity) {
		User user = new User();
		if(userEntity != null) {
			user.setId(userEntity.getId());
			user.setName(userEntity.getName());
			user.setPassword(userEntity.getPassword());
			user.setPayment(converEntityToPayment(userEntity.getPayment()));
			user.setSessionHistory(convertEntityToSessionHistory(userEntity.getSessionHistory()));
			user.setSubscribtion(convertEntityToSubscribtion(userEntity.getSubscribtion()));
			user.setAddress(convertEntityToAddress(userEntity.getAddress()));
			user.setHistory(convertEntityToTransactionHistory(userEntity.getHistory()));
		}
		return user;
	}
	
	public static List<Payment> converEntityToPayment(List<PaymentEntity> payments)
	{
		List<Payment> paymentObjs = new ArrayList<Payment>(); 
		for(PaymentEntity paymentEntity : payments)
		{
			Payment payment = new Payment();
			payment.setCardnumber(paymentEntity.getCardnumber());
			payment.setCardType(paymentEntity.getCardType());
			payment.setExpiryDate(paymentEntity.getExpiryDate());
			payment.setId(paymentEntity.getId());
			paymentObjs.add(payment);
		}
		
		return paymentObjs;
	}
	
	public static List<SessionHistory> convertEntityToSessionHistory(List<SessionHistoryEntity> sessions)
	{
		List<SessionHistory> sessionHistories = new ArrayList<>();
		for(SessionHistoryEntity history : sessions)
		{
			SessionHistory sessionHistory = new SessionHistory();
			sessionHistory.setDate(history.getDate());
			sessionHistory.setId(history.getId());
			sessionHistory.setTime(history.getTime());
			sessionHistories.add(sessionHistory);
		}
		return sessionHistories;
	}
	
	public static Address convertEntityToAddress(AddressEntity addressEntity)
	{
		Address address = new Address();
		address.setAddress1(addressEntity.getAddress1());
		address.setAddress2(addressEntity.getAddress2());
		address.setCity(addressEntity.getCity());
		address.setCountry(addressEntity.getCountry());
		address.setId(addressEntity.getId());
		address.setPincode(addressEntity.getPincode());
		address.setState(addressEntity.getState());
		return address;
	}
	
	public static Subscribtion convertEntityToSubscribtion(SubscribtionEntity entity)
	{
		Subscribtion sub = new Subscribtion();
		sub.setActive(entity.isActive());
		sub.setExpirydate(entity.getExpirydate());
		sub.setId(entity.getId());
		sub.setNumberOfDays(entity.getNumberOfDays());
		sub.setPaidOn(entity.getPaidOn());
		return sub;
	}
	
	public static List<Transactionhistory> convertEntityToTransactionHistory(List<TransactionhistoryEntity> transactionhistories)
	{
		List<Transactionhistory> histories = new ArrayList<Transactionhistory>();
		for(TransactionhistoryEntity transactionhistoryEntity : transactionhistories)
		{
			Transactionhistory history = new Transactionhistory();
			history.setAmmount(transactionhistoryEntity.getAmmount());
			history.setId(transactionhistoryEntity.getId());
			history.getPayment().setCardnumber(transactionhistoryEntity.getPayment().getCardnumber());
			history.getPayment().setCardType(transactionhistoryEntity.getPayment().getCardType());
			history.getPayment().setExpiryDate(transactionhistoryEntity.getPayment().getExpiryDate());
			history.getPayment().setId(transactionhistoryEntity.getId());
			histories.add(history);
		}
		return histories;
	}
}