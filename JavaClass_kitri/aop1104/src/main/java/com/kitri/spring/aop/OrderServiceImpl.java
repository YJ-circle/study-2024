package com.kitri.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl {

	@Autowired
	@Qualifier("svc2")
	private ExternalService externalService;
	
	public void placeOrder() {
		System.out.println("[OrderServiceImpl] placeOrder()");
		externalService.createTransaction();
		
	}
	
	public void shipOrder() {
		System.out.println("[OrderServiceImpl] shipOrder()");
		externalService.sendEmail();
		externalService.log();
	}
}
