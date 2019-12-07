package com.gbs.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbs.app.conversionUtils.ConvertToDao;
import com.gbs.app.conversionUtils.ConvertToEntity;
import com.gbs.app.user.Payment;
import com.gbs.app.user.User;
import com.gbs.app.user.entity.UserEntity;

@Service
public class PaymentService {
	
	@Autowired
	UserService service;
	
	public User createorUpdatePayment(Long id,Payment payment)
	{
		User user = null;
		if(id !=null && payment !=null)
		{
			Optional<UserEntity> userEntityOptional = service.viewByUserId(id);
			UserEntity userEntity = userEntityOptional.get();
			user = ConvertToDao.EntityToUser(userEntity);
			if(user.getPayment()==null)
			{
				List<Payment> payments = new ArrayList<Payment>();
				payments.add(payment);
				user.setPayment(payments);
			}
			else
			{
				user.getPayment().add(payment);
			}
			userEntity = ConvertToEntity.ConvertUserToEntity(user);
			service.ModifyTheUser(user);
		}
		return user;
	}
	
	public User deletePayment(Long id,Long paymentid)
	{
		User user = null;
		if(id !=null && paymentid !=null)
		{
			Optional<UserEntity> userEntityOptional = service.viewByUserId(id);
			UserEntity userEntity = userEntityOptional.get();
			user = ConvertToDao.EntityToUser(userEntity);
			if(user.getPayment()==null)
			{
				System.out.print("payment is null");
			}
			else
			{
				List<Payment> toRet = new ArrayList<Payment>();
				//need to check if changes in each obj in for each reflects in list
				for(Payment pay: user.getPayment()) {
					if(pay.getId()!=paymentid)
					{
						toRet.add(pay);
					}
				}
				user.setPayment(toRet);
			}
			userEntity = ConvertToEntity.ConvertUserToEntity(user);
			service.ModifyTheUser(user);
		}
		return user;
	}

}
