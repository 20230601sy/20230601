package com.board.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Paging {
	private int pageNum; // 페이지 번호
	private int amount; // 페이지당 출력할 레코드 수
	public Paging() {
		pageNum = 1;
		amount = 10;
	}
}
