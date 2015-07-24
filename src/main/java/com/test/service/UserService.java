package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.test.dao.RepositoyAdaptor;
import com.test.entity.user.UserDTO;

@Component("userService")
public class UserService extends ServiceAdaptor {
	
	
	@Autowired
	@Qualifier("userDAO")
	RepositoyAdaptor userDAO;
	
	@Override
	public void insert(UserDTO dto) {
	
		userDAO.insert(dto);
	}
	
	 
	
}
