package com.board.RESTController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.domain.SampleVO;

import lombok.extern.log4j.Log4j;

@RestController // RestController = Controller + ResponseBody
// RestController 쓰면 jsp 형태로 리턴타입 안됨. 따로 관리하려면 @Controller 클래스  public @ResponseBody 메서드타입 메서드명(){} 요런 식...
@RequestMapping("/sample/*")
@Log4j
public class RESTSampleController {
//	@GetMapping("/text")
	@GetMapping(value="/text", produces ="text/plain; charset=utf-8") 
	public String text() {
		return "가나다abc"; // 한글 깨지는 이유는 http 프로토콜 인코딩 방식이 utf-8이 아니어서임. 애초에 텍스트를 내보낼 일은 없긴 한데... 맵핑 헤더에 설정해줄 수 있음... 
	}
	
	@GetMapping("/vo") // 스프링 버전이 낮아서 기본 세팅이 XML... 부트로 넘어가면 기본 세팅이 JSON이 된다심...
	public SampleVO vo() {
		return new SampleVO(11, "고길동", "aaa");
	}
//	<SampleVO>
//	<no>11</no>
//	<name>고길동</name>
//	<id>aaa</id>
//	</SampleVO>
//	로 출력됨 json 형태로 보고 싶으면 http://localhost:8181/sample/vo.json로 요청하거나...
	
	@GetMapping(value="/vo2", produces = "application/json; charset=utf-8")
	public SampleVO vo2() {
		return new SampleVO(20, "홍길동", "bbb");
	}

	@GetMapping(value="/list", produces = "application/json; charset=utf-8")
	public List<SampleVO> list() {
		List<SampleVO> list = new ArrayList<>();
		for(int i=0; i<10; i++)
			list.add(new SampleVO(i+1, "이름"+(i+1), "id"+(i+1)));
		return list;
	}
	
	@GetMapping(value="/map", produces = "application/json; charset=utf-8")
	public Map<String, SampleVO> map() {
		Map<String, SampleVO> map = new HashMap<>();
		map.put("첫번째", new SampleVO(1, "이름1", "aa"));
		map.put("두번째", new SampleVO(2, "이름2", "bb"));
		map.put("세번째", new SampleVO(3, "이름3", "cc"));
		return map;
	}
	// 20230925151912
	// http://localhost:8181/sample/map

//	{
//	  "세번째": {
//	    "no": 3,
//	    "name": "이름3",
//	    "id": "cc"
//	  },
//	  "첫번째": {
//	    "no": 1,
//	    "name": "이름1",
//	    "id": "aa"
//	  },
//	  "두번째": {
//	    "no": 2,
//	    "name": "이름2",
//	    "id": "bb"
//	  }
//	}
	
	// 상태코드도 보내줄 수 있음
	@GetMapping("/check")
	public ResponseEntity<SampleVO> check(String name, String id) {
		SampleVO vo = new SampleVO(1, name, id);
		ResponseEntity<SampleVO> result = null;
		if(name.equals("abc"))
			result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vo);
		else
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		return result;
	}
	// HttpStatus 열거타입 아래 여러 타입이 있음 만들 필요 없이 만들어진 것 중 골라서 보내주면 됨~~
	// 개발자도구 network 탭 아래 Headers에서 Status Code 확인 가능
	// http://localhost:8181/sample/check?name=aaa&id=aaa
	// http://localhost:8181/sample/check?name=abc&id=aaa
	
	// 리액트할 때 detail:xx 로 값만 받아왔던 것처럼 하는 것도 구현 가능
	@GetMapping("/pro/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") int pid) {
		return new String[] {"cat : " + cat, "pid : " + pid}; 
	}
//	http://localhost:8181/sample/pro/nabi/1234
//	<Strings>
//		<item>cat : nabi</item>
//		<item>pid : 1234</item>
//	</Strings>
//	요즘은 셋팅 정보를 url에 담아 해당 정보로 셋팅을 공유할 수 있는 것도 있다는... eg. 주식 보기 설정
	
	@GetMapping("/body")
	public SampleVO body(@RequestBody SampleVO vo) {
		return vo;
	}
// 	postman에서 주소 http://localhost:8181/sample/body / body 선택 - raw 클릭 후 - 맨끝에 JSON으로 바꾼 후
//	{
//	   "no" : "1234",
//	   "name" : "고길동",
//	   "id" : "qwer"
//	}
//	입력한다음 요청해서 그대로 응답이 오는지 확인~
	
//	요청은 get, post 외에 있는 거는 대체로... 
//	put은 수정할 때, delete는 삭제할 때 사용한다심 (get은 조회, post는 등록할 때) 요청 메서드만 보고도 대략적으로 어떤 걸 하려는지 알게 됨
//	이렇게 하면 장점은 요청 주소가 모두 동일해짐~
}
