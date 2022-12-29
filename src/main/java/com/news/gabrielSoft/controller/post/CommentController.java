package com.news.gabrielSoft.controller.post;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.entity.CommentEntity;
import com.news.gabrielSoft.models.post.CommentModel;
import com.news.gabrielSoft.util.USER_ADMIN_LEVEL;

@Controller
public class CommentController {	
	@Autowired
	private CommentModel commentModel;
	
	@PostMapping(value= "/newComment/{postId}")
	public ModelAndView newComment(Model model, HttpSession httpSession, @PathVariable("postId") int postId, CommentEntity commentEntity) {
		commentModel.setBaseContent(httpSession);
		ModelAndView mav = commentModel.getModelAndView();
		
		boolean isUser = commentModel.testCredencials(httpSession, USER_ADMIN_LEVEL.user.toString());
		
		if(isUser == false) {
			mav.clear();
			mav.setViewName("redirect:/login");
		}else {
			commentModel.newComment(postId, httpSession, commentEntity);
			
			mav.clear();
			mav.setViewName("redirect:/postCode/" + postId);
		}
		
		return mav;
	}
}
