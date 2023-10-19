package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer>{
	public List<Board> findAllByOrderByIdDesc();
}
