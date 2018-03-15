package com.spring.java.based.service.impl;

import org.springframework.stereotype.Service;

import com.spring.java.based.model.User;
import com.spring.java.based.service.UserService;

@Service
public class UserServiceImpl implements UserService 
{
	@Override
	public User getUserData() 
	{
		User u = new User();
		u.setName("Ocean");
		return u;
	}
}
