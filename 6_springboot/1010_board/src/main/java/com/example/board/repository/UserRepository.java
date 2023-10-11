package com.example.board.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.board.domain.User;

@Repository // 빈으로 등록하기 위한 어노테이션
public interface UserRepository extends JpaRepository<User, Integer>{ // 쿼리문을 가지고 있는 애를 상속 받음, 제네릭 T : 테이블 정확하게는 Entity 클래스명, ID : 기본키 컬럼의 자료형, 원시데이터형 안 들어가짐 클래스형으로 들어감 
	public Optional<User> findByUsername(String username); // JpaRepository에는 이런 메서드는 없지만 이렇게 메서드이름을 jpa에서 정해준 틀대로 잘 지정해주면 쿼리문은 자동으로 해줌
}
