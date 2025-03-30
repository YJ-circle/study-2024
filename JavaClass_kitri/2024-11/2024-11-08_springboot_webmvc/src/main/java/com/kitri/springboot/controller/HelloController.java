package com.kitri.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public ModelAndView hello(@RequestParam String score1, 
						@RequestParam String score2) {
		int sum = Integer.valueOf(score1) + Integer.valueOf(score2);
		System.out.println("합계점수: " + sum);
		ModelAndView mv = new ModelAndView();
		List<String> items = new ArrayList<String>();
		items.add("테스트1");
		items.add("테스트2");
		items.add("테스트3");
		mv.addObject("list", items);
		mv.addObject("sum", sum);
		mv.setViewName("list");
		return mv;
	}
	
		@RequestMapping(value = "/test1", method = RequestMethod.GET)
		public String getEmpInfo(@RequestParam String empid, @RequestParam String name) {
		System.out.println(name + "의 사번은 " + empid);
		return "index.html";
		}
		@RequestMapping(value="/test2", method = RequestMethod.GET)
		public String getOthersInfo(String subject, String grade) {
		System.out.println(subject + "의 학점은 " + grade);
		return "index.html";
		}


}
