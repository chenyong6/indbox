package com.cy.core.service;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service("testTbService")
public class TestTbServiceImpl implements TestTbService,BeanNameAware,InitializingBean,BeanFactoryAware,DisposableBean{
	
	public int selectTestTb() {
		//int a = testTbDao.selectTestTb();
		return 1;
	}
	private String name ;

	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
		System.err.println("bean name : "+name);
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.err.println("beanFactory : "+beanFactory.getBean(name));
	}
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.err.println("bean初始化之后-----");
	}

	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}


}
