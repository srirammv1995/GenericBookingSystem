package com.gym.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gym.app.services.AddressService;
import com.gym.app.user.Address;
import com.gym.app.user.User;

@RestController
@RequestMapping("address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@PostMapping("create")
	public User createAddress(@RequestParam Long id,@RequestBody Address address)
	{
		return addressService.createOrUpdateAddress(id, address);
	}
	
	@PutMapping("update")
	public User updateAddress(@RequestParam Long id,@RequestBody Address address)
	{
		return addressService.createOrUpdateAddress(id, address);
	}
	
	@DeleteMapping
	public User deleteAddress(@RequestParam Long id)
	{
		return addressService.deleteAddress(id);
	}

}
