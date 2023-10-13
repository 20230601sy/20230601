package com.example.board.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 200)
	private String content;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "postid")
	private Post post;
	// 그냥 댓글(나)를 기준으로 내가 여러개 있을 수 있으면 앞에가 Many
	// 나를 기준으로 움, 그러니까 내가 정해지면 user나 post는 고정되므로 One
	// 거의 ManyToOne일 거라는 소리가 이해됨... 
	// 앞으로도 헷갈릴 예정
	// http://www.amathsdictionaryforkids.com/qr/m/manyToOne.html x(A)가 나임
	// 기본적으로 엄밀한 함수 관계여야 하니까
}
