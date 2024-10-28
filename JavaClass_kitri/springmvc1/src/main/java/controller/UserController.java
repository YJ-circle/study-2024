package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
		
	@RequestMapping("/registrationpage")
	public ModelAndView registrationPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("regi");
		return modelAndView;
	}
	
	@RequestMapping("/registration")
	public ModelAndView addUser(
			@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("password") String pwd,
			@RequestParam("email") String email) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("regi3");
		modelAndView.addObject("user", new User(id, pwd, name, email));
		return modelAndView;
	}
	
}
