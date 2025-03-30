package com.kitri.spring.javawebbean.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.kitri.spring.javawebbean.dto.OrderDto;
import com.kitri.spring.javawebbean.dto.UserDto;
import com.kitri.spring.javawebbean.service.OrderSvc;
import com.kitri.spring.javawebbean.service.UserSvc;

@Controller
public class TestController {
	@Autowired
	UserSvc user;
	
	@Autowired
	OrderSvc order;
	
	@GetMapping("/get_member")
	public String test(ModelMap model) {
		List<UserDto> user2 = user.getUser();
		model.addAttribute("user", user2);
		return "member";
	}
	
	@GetMapping("/get_order")
	public String test2(ModelMap model) {
		List<OrderDto> orderList = order.getOrderList();
		model.addAttribute("ord", orderList);
		System.out.println(orderList);
		return "order";
	}
}
