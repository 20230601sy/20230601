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
	
	@Transactional // 하나의 작업단위를 묶어주는...지금은 별 문제는 없지만...
	public void insertPost(Post post) {
		post.setCnt(0);
		postRepository.save(post);
	}
	
	public Page<Post> getPostList(Pageable pageable) {
//	public List<Post> getPostList() {
		return postRepository.findAll(pageable);
	}
	
	public Post getPost(int id) {
		return postRepository.findById(id).orElse(null);
	}
	
	@Transactional
	public Boolean updatePost(Post post) {
		Post findPost = postRepository.findById(post.getId()).orElse(null);
		if(findPost == null)
			return false;
		findPost.setTitle(post.getTitle());
		findPost.setContent(post.getContent());
		// postRepository.save(findPost); // @Transactional 롤백 커밋하기 때문에 save 없어도 수정된다는 ㄷㄷㄷ 그래서 update문이 없는 배경이...(?) 된다심
		return true;
	}
	
	public void deletePost(int id) {
		postRepository.deleteById(id);
	}
}