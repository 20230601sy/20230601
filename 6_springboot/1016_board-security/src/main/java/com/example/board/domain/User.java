package com.example.board.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // builder 나중에 객체를 만들어줄 때 생성자 호출해서 만드는... 객체 생성을 좀더 직관적으로 할 수 있게 도와주는 거라심... 코드는 좀더 길어진다심. 쓰기 싫으면 안 써도 된다심
public class User {
	
	@Id // 기본키 컬럼으로 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 일련번호 매겨주는 거. DB마다 달라서 GenerationType.AUTO로 하면 자동으로 잡아주는데, H2는 GenerationType.IDENTITY, oracle은 GenerationType.SEQUENCE
	private int id;
	
	@Column(nullable = false, length = 50, unique = true) // null 불가, 길이 설정, 중복 불가
	private String username;

	@Column(length = 100)
	private String password;
	
	@Column(length = 100, nullable = false)
	private String email;
	
	@Enumerated(EnumType.STRING)// 열거형 관계 매핑...
	private RoleType role;
	
	@CreationTimestamp // sysdate 같은 거라고 보면 된다심
	private Timestamp createDate;
}
