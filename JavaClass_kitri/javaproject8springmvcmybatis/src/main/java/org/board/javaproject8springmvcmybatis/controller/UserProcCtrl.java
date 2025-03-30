package org.board.javaproject8springmvcmybatis.controller;

import javax.servlet.http.HttpSession;

import org.board.javaproject8springmvcmybatis.dto.UserInfoDto;
import org.board.javaproject8springmvcmybatis.service.ILoginProcSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserProcCtrl {
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	@Qualifier("loginsvc")
	ILoginProcSvc loginProcSvc; 
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkIdPwd(
			@ModelAttribute UserInfoDto userInfoDto,
			Model model) {
		UserInfoDto resultDto = loginProcSvc.checkIdPwd(userInfoDto);
		
		if(resultDto == null) {
			model.addAttribute("message", "ID나 PWD가 일치하지 않습니다.");
			return "login";
		}
		
		httpSession.setAttribute("loggedinid", resultDto.getId());
		return "redirect:/board";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(Model model) {
		httpSession.setAttribute("id","임시사용자");
		httpSession.invalidate();
		model.addAttribute("message", "로그아웃 되었습니다.");
		return "index";
	}
}
