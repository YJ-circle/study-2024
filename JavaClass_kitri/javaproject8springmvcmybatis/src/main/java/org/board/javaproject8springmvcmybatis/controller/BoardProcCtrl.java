package org.board.javaproject8springmvcmybatis.controller;

import javax.servlet.http.HttpSession;

import org.board.javaproject8springmvcmybatis.service.IBoardProcSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardProcCtrl {
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	@Qualifier("boardsvc")
	IBoardProcSvc boardProcSvc;
	
	@GetMapping("/board")
	public String getPostList(@RequestParam(value =  "id") String id, Model model) {
		System.out.println("Received ID: " + id); // 로그 출력
		if(id.equals("임시사용자")) {
			httpSession.setAttribute("id", id);
		}
		
		model.addAttribute("postList", boardProcSvc.getPostList());
		return "board";
	}
	
	@RequestMapping(value = "/postDetail", method = RequestMethod.POST)
	public String getPostDetail(
			@RequestParam(value = "seq") String seq, Model model) {
		model.addAttribute("postDetail", boardProcSvc.getPostDetail(seq));
		return "postDetail";
	}
	
	@GetMapping("test")
	public void getTest() {
		System.out.println("test");
	}
}
