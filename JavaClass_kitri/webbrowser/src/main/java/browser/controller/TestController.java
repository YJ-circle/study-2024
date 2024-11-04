package browser.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
		
	@GetMapping("testform")
	public String openTestPage() {
		return "getpostform";
	}
	
	@GetMapping("gettest")
	public String getTest(@RequestParam("id") String id,
			              @RequestParam("pwd") String pwd,
			              Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		return "getresult";
	}
	
	@PostMapping("posttest")
	public String postTest(@RequestParam("id") String id,
            			   @RequestParam("pwd") String pwd,
 			              Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		return "postresult";
	}
}
