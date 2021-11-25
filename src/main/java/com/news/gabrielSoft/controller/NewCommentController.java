package com.news.gabrielSoft.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.news.gabrielSoft.entity.CommentEntity;
import com.news.gabrielSoft.repository.PostIndexRepository;
import com.news.gabrielSoft.util.Comment;

@Controller
public class NewCommentController {
	//CRIAR CLASS
	@Autowired
	PostIndexRepository postRep;
	
	@Autowired
	Comment comment;
	
	@PostMapping(value= "/newComment/{postId}")
	public String AboutMe(Model model, HttpSession httpSession, @PathVariable("postId") String postId, CommentEntity commentEntity) {
		try {
			comment.newComment(httpSession, Integer.valueOf(postId), commentEntity);
		} catch (Exception e) {
			System.out.println(e);
			return "redirect:/deslogar";
		}
		
		return "redirect:/postCode/" + postId ;
	}

}
