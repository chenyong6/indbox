package com.cy.core.service.jpa.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.core.dao.jta.db_1.UserDAO;
import com.cy.core.dao.jta.db_2.DormDAO;
import com.cy.core.domain.jpa.Dorm;
import com.cy.core.domain.jpa.User;
import com.cy.core.service.jpa.JpaTest;
@Service("jpaTest")
public class JpaTestImpl implements JpaTest {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private DormDAO dormDAO;

	@Override
	public void insert() {
		//User user = new User();
		//user.setName("cy");
		
		Dorm dorm = new Dorm();
		dorm.setName("dorm");
		System.err.println(dormDAO.insertDorm());
	}

}
