package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.board.domain.Post;
import com.example.board.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Transactional
	public void insertPost(Post post) {
		post.setCnt(0);
		
		postRepository.save(post);
	}
	
	public Page<Post> getPostList(Pageable pageable) {
		return postRepository.findAll(pageable);
	}
	
	public Post getPost(int id) {
		Post post = postRepository.findById(id).get();
		
		return post;
	}
	
	public void updatePost(Post post) {
		Post oriPost = postRepository.findById(post.getId()).get();
		
		oriPost.setTitle(post.getTitle());
		oriPost.setContent(post.getContent());
		
		postRepository.save(oriPost);
		
	}
	
	public void deletePost(int id) {
		
		postRepository.deleteById(id);
		
	}

}
