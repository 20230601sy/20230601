package com.example.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // builder 나중에 객체를 만들어줄 때 생성자 호출해서 만드는... 객체 생성을 좀더 직관적으로 할 수 있게 도와주는 거라심... 코드는 좀더 길어진다심. 쓰기 싫으면 안 써도 된다심
public class User {
	private int id;
	private String username;
	private String password;
	private String email;
}
