package com.spring.springorm.ham;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PassengerTest {
	private static ClassPathXmlApplicationContext ctx;
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("classpath:/config/config.xml");
		PassengerDao dao = (PassengerDao) ctx.getBean("passengerDao");
		
//		System.out.println("전체 상품 조회");
//		System.out.println(dao.findAll());
//		System.out.println("상품 조회");
//		System.out.println(dao.find(2));
		dao.delete(new Passenger().setId(2));
		ctx.close();
	}
}
