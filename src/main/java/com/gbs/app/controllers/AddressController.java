package com.gbs.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gbs.app.services.AddressService;
import com.gbs.app.user.Address;
import com.gbs.app.user.User;

@RestController
@RequestMapping("address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@PostMapping("create")
	public User createAddress(@RequestHeader(value="x-auth-token") String authtoken,@RequestParam(required = false) Long userId,@RequestBody Address address)
	{
		return addressService.createOrUpdateAddress(userId, address);
	}
	
	@PutMapping("update")
	public User updateAddress(@RequestBody Address address,@RequestHeader(value="x-auth-token") String authtoken,@RequestParam(required = false) Long userId)
	{
		return addressService.createOrUpdateAddress(userId, address);
	}
	
	@DeleteMapping
	public User deleteAddress(@RequestHeader(value="x-auth-token") String authtoken,@RequestParam(required = false) Long userId)
	{
		return addressService.deleteAddress(userId);
	}

}
