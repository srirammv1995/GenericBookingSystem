package com.gbs.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbs.app.conversionUtils.ConvertToDao;
import com.gbs.app.conversionUtils.ConvertToEntity;
import com.gbs.app.user.Payment;
import com.gbs.app.user.Transactionhistory;
import com.gbs.app.user.User;
import com.gbs.app.user.entity.UserEntity;

@Service
public class TransactionService {
	@Autowired
	UserService service;
	
	public User createTransaction(Long id,Payment payment,Long ammount)
	{
		User user = null;
		if(id !=null && payment !=null && ammount !=null)
		{
			Optional<UserEntity> userEntityOptional = service.viewByUserId(id);
			UserEntity userEntity = userEntityOptional.get();
			user = ConvertToDao.EntityToUser(userEntity);
			if(user.getHistory()==null)
			{
				List<Transactionhistory> history = new ArrayList<Transactionhistory>();
				Transactionhistory transactionhistory = new Transactionhistory();
				transactionhistory.setAmmount(ammount);
				transactionhistory.setId(id);
				transactionhistory.setPayment(payment);
				history.add(transactionhistory);
				user.setHistory(history);;
			}
			else
			{
				Transactionhistory transactionhistory = new Transactionhistory();
				transactionhistory.setAmmount(ammount);
				transactionhistory.setId(id);
				transactionhistory.setPayment(payment);
				user.getHistory().add(transactionhistory);
			}
			userEntity = ConvertToEntity.ConvertUserToEntity(user);
			service.ModifyTheUser(user);
		}
		return user;
	}
}
