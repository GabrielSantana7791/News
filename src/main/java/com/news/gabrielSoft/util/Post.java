package com.news.gabrielSoft.util;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.gabrielSoft.entity.CommentEntity;
import com.news.gabrielSoft.entity.PostIndexEntity;
import com.news.gabrielSoft.repository.CommentRepository;
import com.news.gabrielSoft.repository.PostIndexRepository;
import com.news.gabrielSoft.user.Session;

@Service
public class Post {
	
	@Autowired
	Session session;
	
	@Autowired
	PostIndexRepository postRep;
	
	@Autowired
	CommentRepository commentRep;

	public void deletePost(HttpSession httpSession, int postId) throws Exception {	
		session.userTestCredencial(httpSession, USER_ADMIN_LEVEL.admin);
		
		PostIndexEntity post = postRep.findById(postId);
		
		postRep.delete(post);
				
	}
	
	public PostIndexEntity editPost(HttpSession httpSession, int postId, PostIndexEntity postIndex) throws Exception {
		session.userTestCredencial(httpSession);
		
		PostIndexEntity postDB = postRep.findById(postId);

		postDB.setText(postIndex.getText());
		postDB.setDate(postIndex.getDate());
		postDB.setTitle(postIndex.getTitle());
		
		postRep.flush();
		
		return postDB;
	}
	
	public void addPost(PostIndexEntity postIndex) {
		postRep.save(postIndex);
		
	}
	
	public PostIndexEntity postIndex (int postId) {
		PostIndexEntity postIndex = postRep.findById(postId);	
		return postIndex;
	}
	
}
