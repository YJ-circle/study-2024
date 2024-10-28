package controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestGetAttr {
		
	@RequestMapping("/test4")
	public ModelAndView test1() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello2");
		modelAndView.addObject("id","1234");
		modelAndView.addObject("pwd","password");
		modelAndView.addObject("userName","홍길동");
		return modelAndView;
	}
	
	@RequestMapping("/jstl")
	public ModelAndView test5() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jstl");
		modelAndView.addObject("user", new User(1234,"홍길동", "길동이"));
		return modelAndView;
	}
	
	@RequestMapping("/list1")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list");
		List<User> userList = new ArrayList<>();
		userList.add(new User(1234,"홍길동", "길동이"));
		userList.add(new User(1235,"박길동", "박길이"));
		modelAndView.addObject("userList", userList);
		return modelAndView;
	}
	
	@RequestMapping("/list2")
	public ModelAndView list2() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list");
		List<User> userList = new ArrayList<>();
		userList.add(new User(1234,"홍길동", "길동이"));
		userList.add(new User(1235,"박길동", "박길이"));
		modelAndView.addObject("userList", userList);
		return modelAndView;
	}
	
	public static class User{
		int id;
		String name;
		String alias;
		private User(int id, String name, String alias) {
			this.id = id;
			this.name = name;
			this.alias = alias;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAlias() {
			return alias;
		}
		public void setAlias(String alias) {
			this.alias = alias;
		}
		
		
	}
	
	
}
