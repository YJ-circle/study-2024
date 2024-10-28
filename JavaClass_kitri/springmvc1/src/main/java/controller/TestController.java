package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
		
	@RequestMapping("/test1")
	public ModelAndView test1() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello");
		modelAndView.addObject("user","길동이");
		return modelAndView;
	}
	
	@RequestMapping(name = "/test2", method = RequestMethod.GET)
	public String test2s(Model model) {
		model.addAttribute("user","길동이");
		return "hello";
	}
	
	
}
