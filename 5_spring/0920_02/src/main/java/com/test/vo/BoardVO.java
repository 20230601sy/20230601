package com.test.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private String title;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") // initBinder 왠지 좀 귀찮잖어 이거 한 줄이면 돼~
	private Date date;
}
