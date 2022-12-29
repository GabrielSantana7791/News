package com.news.gabrielSoft.models.post;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.classes.Comment;
import com.news.gabrielSoft.entity.CommentEntity;
import com.news.gabrielSoft.models.ModelImp;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

@Service
public class CommentModel extends ModelImp{	
	@Autowired
	private Comment comment;
	
	public CommentModel() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setBaseContent(HttpSession httpSession) {
		modelAndView = new ModelAndView("base");
	}

	public void newComment(int postId, HttpSession httpSession, CommentEntity commentEntity) {		
		comment.newComment(Integer.valueOf(postId), httpSession, commentEntity);
		
		modelAndView.clear();
		addContent(MODEL_ATTRIBUTES.message.toString(), "Success");
	}	
}
