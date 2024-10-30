package com.kitri.spring.member.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.view.RedirectView;

import com.kitri.spring.member.dto.MemberDto;
import com.kitri.spring.member.service.IMemberService;

@Controller
@SessionAttributes("login_id")
public class MemberController {
	
	@Autowired
	IMemberService memberSerivce;
	
	@RequestMapping(value = "login", method=RequestMethod.GET)
	public String loginPage(@SessionAttribute(value = "login_id", required = false) 
						    Optional<String> id) {
		if(id.isPresent()) {
			return "redirect:/board/";
		}
		
		return "login";
	}
	
	
	@RequestMapping(value = "logout", method=RequestMethod.GET)
	public String logout(SessionStatus status, Model model) {
		model.addAttribute("login_id", Optional.empty());
		return "redirect:/login";
		
	}
	
	@RequestMapping(value = "login", method=RequestMethod.POST)
	public String login(Model model,
					    @RequestParam("id") String id,
					    @RequestParam("password") String password) {
		
		boolean loginResult = false;
		Optional<MemberDto> loginUser = memberSerivce.login(id, password);
		
		if(loginUser.isPresent()) {
			model.addAttribute("login_id", loginUser.get().getId());
			loginResult = true;
		}
		model.addAttribute("result", loginResult);
		return "login";
	}
	
	
}
