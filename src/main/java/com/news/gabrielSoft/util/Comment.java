package com.news.gabrielSoft.util;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.gabrielSoft.entity.CommentEntity;
import com.news.gabrielSoft.entity.PostIndexEntity;
import com.news.gabrielSoft.entity.UserEntity;
import com.news.gabrielSoft.repository.CommentRepository;
import com.news.gabrielSoft.repository.PostIndexRepository;
import com.news.gabrielSoft.user.Session;

@Service
public class Comment {
	@Autowired
	Session login;

	@Autowired
	CommentRepository commentRep;

	@Autowired
	PostIndexRepository postRep;

	public void newComment(HttpSession httpSession, int postId, CommentEntity comment) throws Exception {
		PostIndexEntity postIndex = postRep.findById(postId);
		UserEntity user = (UserEntity) httpSession.getAttribute("user");
		user = login.userTestCredencial(user);
		
		comment.setUser(user);
		comment.setPostIndex(postIndex);
		commentRep.saveAndFlush(comment);
		
		postIndex.AddNewComment(comment);

		postRep.saveAndFlush(postIndex);
	
	}
}
