package com.cy.core.service.aop;

import org.springframework.stereotype.Service;

@Service("楼主")
public class 楼主 implements 楼主able {

	@Override
	public void play(String str) {
		System.err.println("楼主正在吹牛逼." );
	}

}
