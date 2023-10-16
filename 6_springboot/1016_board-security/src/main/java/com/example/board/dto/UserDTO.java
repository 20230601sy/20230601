package com.example.board.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserDTO {
	
	@NotNull(message = "username이 비어있음")
	@NotBlank(message = "username은 필수 입력임") // NotEmpty 같은 거도 있음 이거는 문자열, 배열, 컬렉션의 크기가 0보다 커야 할 때 씀.
	@Size(min = 1, max = 20, message = "username 1~20글자만 입력")
	private String username;
	
	@Size(max = 100, message = "password는 100글자 이하만 입력")
	private String password;
	
	@NotNull(message = "email이 입력되지 않음")
	@NotBlank(message = "email은 필수 입력")
	@Email(message = "email 형식이 아님") // 정규식으로 검사하려면 @Pattern(정규식) 써야 함
	private String email;
}
