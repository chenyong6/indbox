package com.cy.core.test;

import org.springframework.stereotype.Service;

@Service("xxx")
public class HelloServiceImpl implements IHelloService {

	public void say() {
		System.err.println("hello world");
	}

}
