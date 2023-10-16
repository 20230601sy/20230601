package com.example.board.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;

	@Lob // 대용량을 넣을 수 있는 타입을 잡아주는 거...
	@Column(nullable = false)
	private String content;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	private int cnt;
	
	@ManyToOne(fetch = FetchType.EAGER) // post 입장에서 관계 설정 1:1 vs 1:다 vs 다:1 vs 다:다, 식별할 수 있는 값만 들어가 있는데,,, () 옵션 설정해서 모든 정보 값을 가져오도록 해둠 / cascade라는 외래키 기본키 간 삭제시 데이터를 어떻게 할 것인가에 관한 옵션도 있음...
	@JoinColumn(name = "userid")
	private User user;
	
	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) // cascade 명시하지 않으면 아무작업도 안함... All이나 REMOVE...
	@OrderBy("id desc")
	private List<Reply> replyList;
}
