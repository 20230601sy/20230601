package com.example.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/html")
	public String html() {
		System.out.println("html 요청받음");
//		return "hello"; // 이렇게 하면 views 폴더 안에 hello.jsp 요청으로 가기 때문에 하면 안됨 
		return "redirect:hello.html";
	}
	
//	@GetMapping("/jsp")
//	public String jsp() {
//		return "hello";
//	}
	
	@GetMapping("/jsp")
	public String jsp(Model model) {
		model.addAttribute("name", "고길동");
		return "hello";
	}
	
}
