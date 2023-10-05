package com.study.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class SampleController {
	
	@GetMapping("/all")
	public void doAll() {
		log.info("모든 사용자 접근 가능");
	}
	
	@GetMapping("/member")
	public void doMember() {
		log.info("로그인한 사용자만 접근 가능");
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("관리자만 접근 가능");
	}
	
	@GetMapping("/accessError")
	public void accessError(Authentication auth, Model model) {
		model.addAttribute("msg", auth.getName() + " 접근 권한 없음");
		// auth에서 빼올 수 있는 건 2개인가 밖에 없어서 필요할 경우 나중에 custom하게 만들어야 한다
	}
	@GetMapping("/customLogin")
	public void loginPage() {
	}
}
