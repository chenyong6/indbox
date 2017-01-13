package com.cy;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cy.core.common.junit.SpringJunitTest;
import com.cy.core.domain.TestTb;
import com.cy.core.service.TestTbService;
import com.cy.core.test.IHelloService;

/**
 * 测试
 */

public class TestTestTb extends SpringJunitTest{

	@Resource(name="xxx")
	private IHelloService helloService;
	@Test
	public void selectTestTb() throws Exception {
		helloService.say();
	}
}
