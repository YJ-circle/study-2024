package org.board.javaproject8springmvcmybatis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {
	
	@GetMapping("test2")
	public void test() {
		System.out.println("test");
	}

}
