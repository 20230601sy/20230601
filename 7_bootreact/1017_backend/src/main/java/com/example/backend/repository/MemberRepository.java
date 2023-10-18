package com.example.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>{
	Optional<Member> findByUsername(String username);
}
