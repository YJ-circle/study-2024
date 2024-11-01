package com.kitri.spring.intercept;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterCept {

	@GetMapping("/today")
	public String getToday(Model model) {
		System.out.println("컨트롤러");
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
		String now = format.format(date);
		model.addAttribute("today", now);
		
		return "intercepter";
	}
}
