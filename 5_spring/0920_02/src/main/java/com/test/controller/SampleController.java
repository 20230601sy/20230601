package com.test.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.test.vo.BoardVO;
import com.test.vo.SampleVO;

@Controller
//@RequestMapping("/sample/*") // 매개변수: 요청 url, 일단 sample이라고 하자심. 이렇게 적으면 http://localhost:8181/sample/.... 들어오면 여기서 처리하겠다는 의미
public class SampleController {
	@RequestMapping("/test") // http://localhost:8181/sample/test 로 요청 날리면 페이지는 없으니 404 뜨지만... 콘솔에 test 출력됨
	public void test() {
		System.out.println("test");
	}
	
	@RequestMapping(value="/test2", method = {RequestMethod.POST}) // 이게 귀찮은 게 메서드 지정 안하면 무조건 get요청으로 생김
	public void test2() {
		System.out.println("test2");
	}
	
	@GetMapping("/test3")
	public void test3() {
		System.out.println("test3");
	}
	
	@PostMapping("/test4")
	public void test4() {
		System.out.println("test4");
	}

	@PutMapping("/test5") // 요청 종류 별로 어노테이션 다 있음....이건 나중에 RestAPI 할 때 다시 한다심...
	public void test5() {
		System.out.println("test5");
	}
	
	// 이제 파라미터 오브젝트 형태로 받아오는 거...
	@GetMapping("/vo") // get 요청 http://localhost:8181/sample/vo?name=abc&age=20
	public void vo(SampleVO vo) {
		System.out.println(vo); // 걍 출력됨 ㄷㄷ SampleVO(name=abc, age=20) // 자동으로 세터가 실행되기 때문에(롬복 @Data) 멤버변수와 이름이 동일하면 알아서 값이 들어가짐...
	}
	
	@GetMapping("/vo2") // get 요청 http://localhost:8181/sample/vo2?name=abc&age=20
	public void vo2(String name, int age) {
		System.out.println(name + " : " + age); // abc : 20
	}
	
	@GetMapping("/vo3") // get 요청 http://localhost:8181/sample/vo3?n=abc&a=20
	public void vo3(@RequestParam("n") String name,@RequestParam("a") int age) { // 보내는 거랑 저장하고 싶은 이름이 다를 경우.. 보통은 맞춰서 쓰기 때문에 이럴 일은 없다심
		System.out.println(name + " : " + age); // abc : 20
	}
	
	@GetMapping("/list") // get 요청 http://localhost:8181/sample/list?nums=1&nums=2&nums=3
	public void list(@RequestParam("nums") ArrayList<Integer> nums) { // nums=1&nums=2&nums=3 문자열을 자동으로 형변환해준거임... 
		for(Integer n : nums)
			System.out.print(n + " "); // 1 2 3 
	}
	
	// 날짜 같은 건 자동형변환이 안되니깐....이닛바인더 생성
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, false));
//	}
	@GetMapping("/board") // get 요청 http://localhost:8181/sample/board?title=abc&date=2023-09-20
	public void board(BoardVO vo) {
		System.out.println(vo); // BoardVO(title=abc, date=Wed Sep 20 00:00:00 KST 2023)
	}
	
	// 이제는 보내는 거 request 객체에 담아서 보내던 거를 model 객체를 사용해서 거기에 담아서 보냄
	@GetMapping("model") // / 안 써도 되나봄 확인은 Run on Server 후에 주소에 http://localhost:8181/sample/model?name=abc 입력 (postman에서 확인하는 거 아님, 확인은 되긴 함...)
	public String model(Model model, String name) {
		model.addAttribute("name", name);
		return "model"; // views 폴더에 model.jsp 파일 생성
	}
	
	@GetMapping("model2") // http://localhost:8181/sample/model2?name=abc&title=kkk&date=2023-09-20 입력
	public String model2(Model model, String name, BoardVO vo) {
//		model.addAttribute("name", name);
		return "model2"; // name은 출력 안되지만 객체는 출력됨 ㄷㄷ 빈에 담겨있어서... BoardVO(title=kkk, date=Wed Sep 20 00:00:00 KST 2023)
	}
	
//	@GetMapping("/model") // class앞에 @RequestMapping 잠시 주석... http://localhost:8181/model2?name=abc&title=kkk&date=2023-09-20 입력
//	public void model2(Model model, String name) {
//		model.addAttribute("name", name);
//		// jsp 파일명과 주소가 동일하면 return 안하고 void로 해도 페이지 이동됨 ㄷㄷ 근데 그냥 명시해서 쓰라심...
//	}
	
	@GetMapping("/object") // get 요청 http://localhost:8181/object
	@ResponseBody // 객체 직렬화해서 보내던 거 어느정도 대신해줄 수 있는 어노테이션 
	public SampleVO object() {
		SampleVO vo = new SampleVO();
		vo.setName("kkk");
		vo.setAge(20);
		return vo;
	}
	// jackson https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.15.2
//	<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
//	<dependency>
//	    <groupId>com.fasterxml.jackson.core</groupId>
//	    <artifactId>jackson-databind</artifactId>
//	    <version>2.9.10.8</version>
//	</dependency>
	
	@GetMapping("/header")
	public ResponseEntity<String> header(){
		String body = "{\"name\" : \"고길동\"}"; // "{\"키\" : \"값\"}"
		HttpHeaders header = new HttpHeaders(); // spring으로 import!
		header.add("Content-Type", "application/json;charset=utf-8");
		return new ResponseEntity<String>(body, header, HttpStatus.OK); // 내용물, 헤더, 응답 결과
	}
	
	@GetMapping("/upload")
	public String upload() {
		return "upload";
	}
	@PostMapping("/upload")
	public void uploadTest(ArrayList<MultipartFile> files) {
		for(MultipartFile f : files) {
			System.out.println(f.getOriginalFilename() + " : " + f.getSize());
		}
		// 아직 upload 폴더에 파일이 저장되지는 않음 파일 객체 만들어서 함... 나중에 게시판 만들 때 다시 할 거라심
	}
	
	// 에러페이지 확인
	@GetMapping("model3") // http://localhost:8181/model3?name=abc&title=kkk&date=aaa 입력
	public String model3(BoardVO vo) {
		return "model2"; // name은 출력 안되지만 객체는 출력됨 ㄷㄷ 빈에 담겨있어서... BoardVO(title=kkk, date=Wed Sep 20 00:00:00 KST 2023)
	}
}
