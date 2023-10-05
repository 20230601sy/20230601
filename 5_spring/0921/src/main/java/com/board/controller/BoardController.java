package com.board.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.domain.BoardAttachVO;
import com.board.domain.BoardVO;
import com.board.domain.PageDTO;
import com.board.domain.Paging;
import com.board.service.BoardService;

import lombok.extern.log4j.Log4j;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public void list(Model model, Paging paging) {
//		log.info("전체 레코드 조회");
		model.addAttribute("list", boardService.getList(paging));
		model.addAttribute("pageInfo", new PageDTO(paging, boardService.getTotal(paging)));
	}
	
//	레코드 추가(게시글 작성)
//	서버는 클라이언트가 입력한 게시글 정보를 받아옴
//	받아온 데이터를 이용해 DB에 저장(insert)
//	등록된 게시글 번호를 가져와서
//	목록 페이지로 이동
//	(추가적인 기능) xx 번 게시글 작성 완료...
	@PostMapping("/add")
	public String add(BoardVO board, RedirectAttributes attr) {
		boardService.add(board);
		attr.addFlashAttribute("result", board.getBno());
//		return "list"; // 단순 list.jsp 파일 이동은 안됨... list.do servlet 같은 거 통과해야 했던 거랑 같은 개념...
		return "redirect:/board/list"; // 여기서도 센드리다이렉트와 포워드 가 있는데.. 포워드는 return list(.jsp)와 model 사용, 센드리다이렉트는 redirect: 요런 식. 근데 여기서 리다이렉트는 정보를 담아서 보낼 수 있는데 attr에 담아야 함... 
	}
	@GetMapping("/add")
	public void addPage() {}
	
//	게시물 목록에서 제목을 클릭하면 해당 게시물 상세페이지로 이동
//	클라이언트한테 게시물 번호를 받아와야 함
//	DB에서 해당 게시물 번호의 레코드를 가져옴
//	가져온 레코드를 상세페이지로 보냄
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno")Long bno, Model model, @ModelAttribute("paging") Paging paging) { // @RequestParam("bno") 생략 가능... 이름이 같으니까~ // "paging"이라는 key로 매개변수로 받은 paging을 model에 담음...
		model.addAttribute("board", boardService.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes attr, Paging paging) {
		if(boardService.modify(board))
			attr.addFlashAttribute("result", "수정 완료");
		else
			attr.addFlashAttribute("result", "수정 실패");
		attr.addFlashAttribute("paging", paging);
		return "redirect:/board/list"; 
	}
	
	public void deleteFile(List<BoardAttachVO> attachList) {
		if(attachList == null || attachList.size() == 0)
			return;
		attachList.forEach(attach -> {
			try {
				Path file = Paths.get("D:\\Y\\20230601ezen\\5_spring\\upload\\" + attach.getUploadPath() + "\\" + attach.getUuid() + "_" + attach.getFileName());
				Files.delete(file); // 예외처리를 강요하는 메서드 아니면 Files.deleteIfExists(file) 사용하면 됨.
				if(Files.probeContentType(file).startsWith("image")) {
					file = Paths.get("D:\\Y\\20230601ezen\\5_spring\\upload\\" + attach.getUploadPath() + "\\s_" + attach.getUuid() + "_" + attach.getFileName());
					Files.delete(file);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	@GetMapping("/remove")
	public String remove(Long bno, RedirectAttributes attr, Paging paging) {
		List<BoardAttachVO> list = boardService.getAttachList(bno); // DB에서 삭제하기 전에 가져오기
		if(boardService.remove(bno)) {
			deleteFile(list);
			attr.addFlashAttribute("result", "삭제 완료");
		}
		else
			attr.addFlashAttribute("result", "삭제 실패");
		attr.addFlashAttribute("paging", paging);
		return "redirect:/board/list"; 
	}
	
	@GetMapping(value = "/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>> getAttachList(Long bno){
		return new ResponseEntity<>(boardService.getAttachList(bno), HttpStatus.OK);
	}
}
