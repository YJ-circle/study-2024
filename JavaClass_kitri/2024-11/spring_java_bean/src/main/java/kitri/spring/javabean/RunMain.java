package kitri.spring.javabean;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kitri.spring.javabean.config.SpringConfig;
import kitri.spring.javabean.dto.OrderDto;
import kitri.spring.javabean.dto.UserDto;
import kitri.spring.javabean.service.OrderSvc;
import kitri.spring.javabean.service.UserSvc;

public class RunMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext actx = new AnnotationConfigApplicationContext(SpringConfig.class);
		UserSvc userSvc = (UserSvc) actx.getBean("userSvc");
		List<UserDto> user = userSvc.getUser();
		System.out.println(user);
		OrderSvc orderSvc = (OrderSvc) actx.getBean("orderSvc");
		List<OrderDto> ordeList = orderSvc.getOrdeList();
		System.out.println(ordeList);
		
	}

}
