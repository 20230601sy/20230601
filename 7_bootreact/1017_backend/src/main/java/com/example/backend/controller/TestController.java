package com.example.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.domain.TestVO;

@RestController
public class TestController {
	@GetMapping("/test")
	public String test() {
		return "Hello Spring Boot & React!";
	}
	@GetMapping("/test2")
	public TestVO test2() {
		return new TestVO("id", "pwd", 20);
	}

	@PostMapping("/test/{no}")
	public void test3(@RequestBody TestVO vo, String msg, @PathVariable int no) {
		System.out.println("vo:" + vo);
		System.out.println("msg:" + msg);
		System.out.println("no:" + no);
	}
}
