package com.test.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.test.entity.user.UserDTO;

@Component("userDAO")
public class UserDAO extends RepositoyAdaptor{
	
	@Autowired
	@Qualifier("sessionTemplete")
	SqlSessionTemplate template;

	@Override
	public void insert(UserDTO dto) {
		
		template.insert("user.insert", dto);
	}

	
}
