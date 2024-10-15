package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") // /hello로 들어오면 이렇게 해줌
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!");
        return "hello"; // hello.html로 넘김
        //스프링 부트 기본 설정이
        // 뷰 리졸버(viewResolver)가 templeates의 hello를 먼저 찾게 된다.

    }
}
