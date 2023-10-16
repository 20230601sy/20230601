package com.example.board.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PostDTO {
	@NotNull(message = "title이 없음")
	@NotBlank(message = "title은 필수 입력")
	private String title;

	@NotNull(message = "content가 없음")
	@NotBlank(message = "content는 필수 입력")
	private String content;
}
