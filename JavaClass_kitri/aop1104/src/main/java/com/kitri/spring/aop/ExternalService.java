package com.kitri.spring.aop;

import org.springframework.stereotype.Component;

@Component("svc2")
public class ExternalService {

	public void createTransaction() {
		System.out.println("[ExternalService] createTransaction()");
	}

	public void sendEmail() {
		System.out.println("[ExternalService] sendEmail()");
	}

	public void log() {
		System.out.println("[ExternalService] log()");
	}

}
