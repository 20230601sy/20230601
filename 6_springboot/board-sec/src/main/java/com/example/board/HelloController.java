package com.example.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/html")
	public String html() {
		System.out.println("html요청받음");
		
		return "redirect:hello.html";
	}
	
	@GetMapping("/jsp")
	public String jsp(Model model) {
		model.addAttribute("name", "고길동");
		
		return "hello";
	}

}
