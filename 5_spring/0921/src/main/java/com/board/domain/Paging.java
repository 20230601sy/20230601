package com.board.domain;

//import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class Paging {
	private int pageNum; // 페이지 번호
	private int amount; // 페이지당 출력할 레코드 수
	
	private String type; // 필드 T: 제목, C: 내용, W: 작성자, TC: 제목과 내용...
	private String keyword;
	
	public Paging() {
		pageNum = 1;
		amount = 10;
	}
	
	public Paging(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		return type == null? new String[] {} : type.split("");
	}
}
