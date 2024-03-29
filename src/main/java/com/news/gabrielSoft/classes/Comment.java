package com.news.gabrielSoft.classes;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.gabrielSoft.entity.CommentEntity;
import com.news.gabrielSoft.entity.PostIndexEntity;
import com.news.gabrielSoft.entity.UserEntity;
import com.news.gabrielSoft.repository.CommentRepository;
import com.news.gabrielSoft.repository.PostIndexRepository;

@Service
public class Comment {	
	@Autowired
	private CommentRepository commentRep;

	@Autowired
	private PostIndexRepository postRep;

	public void newComment(int postId, HttpSession httpSession, CommentEntity comment){
		if(comment.getText().length() != 0) {
			PostIndexEntity postIndex = postRep.findById(postId);
			
			UserEntity user = (UserEntity) httpSession.getAttribute("user");
			
			comment.setUser(user);
			comment.setPostIndex(postIndex);
			commentRep.saveAndFlush(comment);
			
			postIndex.AddNewComment(comment);

			postRep.saveAndFlush(postIndex);
		}
	}
}
