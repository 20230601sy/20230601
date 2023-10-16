package com.example.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.board.domain.Post;
import com.example.board.domain.Reply;
import com.example.board.domain.User;
import com.example.board.repository.PostRepository;
import com.example.board.repository.ReplyRepository;

@Service
public class ReplyService {
	
	@Autowired
	private ReplyRepository replyRepository;

	@Autowired
	private PostRepository postRepository;
	
	@Transactional
	public void insertReply(Reply reply, int postId, User user) {
		Post post = postRepository.findById(postId).get();
//		post.getReplyList().add(reply);
//		postRepository.save(post); // 오오 이거 안 해도 되넹 ㅋㅋㅋ
		reply.setPost(post);
		reply.setUser(user);
		replyRepository.save(reply);
	}
	
	@Transactional
	public void deleteReply(int replyId, User user) {	
		if(user.getId() == replyRepository.findById(replyId).orElse(new Reply()).getUser().getId())
			replyRepository.deleteById(replyId);
	}

	@Transactional
	public void updateReply(Reply reply, User user) {
		Reply findReply = replyRepository.findById(reply.getId()).orElse(null);
		if(findReply == null)
			return;
		if(findReply.getUser().getId() != user.getId())
			return;
		findReply.setContent(reply.getContent());
		replyRepository.save(findReply); // 이거 딱히 안 해도 될 듯...
	}
}
