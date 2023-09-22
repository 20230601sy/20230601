package com.board.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // controller test할 때 필요한 거 서블릿 테스트 할 때 써줘야 함...
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class BoardControllerTest {
	
	@Autowired
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	// 임시로 url 이나 parameter를 만들어서 테스트 ㄷㄷㄷ
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
//	@Test
//	public void testList() throws Exception{
//		log.info(
//			mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
//				.andReturn()
//				.getModelAndView()
//				.getModelMap()
//		);
//	}

//	@Test
//	public void testAdd() throws Exception{
//		log.info(
//		mockMvc.perform(MockMvcRequestBuilders.post("/board/add")
//					.param("title", "컨트롤러 제목")
//					.param("content", "컨트롤러 내용")
//					.param("writer", "컨트롤러")
//				)
//			.andReturn()
//			.getModelAndView()
//			.getModelMap()
//		);
//	}
	
//	@Test
//	public void testAdd() throws Exception{
//		log.info(
//		mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
//					.param("bno", "21")
//				)
//			.andReturn()
//			.getModelAndView()
//			.getModelMap()
//		);
//	}
	
//	@Test
//	public void testModify() throws Exception{
//		log.info(
//		mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
//					.param("bno", "3")
//					.param("title", "컨트롤러 수정 제목")
//					.param("content", "컨트롤러 수정 내용")
//					.param("writer", "컨트롤러 수정")
//				)
//			.andReturn()
//			.getModelAndView()
//			.getModelMap()
//		);
//	}
	
//	@Test
//	public void testRemove() throws Exception{
//		log.info(
//		mockMvc.perform(MockMvcRequestBuilders.get("/board/remove")
//					.param("bno", "2")
//				)
//			.andReturn()
//			.getModelAndView()
//			.getModelMap()
//		);
//	}
	
	@Test
	public void testList() throws Exception{
		log.info(
			mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
						.param("pageNum", "3")
						.param("amount", "20")
					)
				.andReturn()
				.getModelAndView()
				.getModelMap()
		);
	}
}
