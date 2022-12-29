package com.news.gabrielSoft.controller.post;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.models.post.DeletePostModel;
import com.news.gabrielSoft.util.USER_ADMIN_LEVEL;

@Controller
public class DeletePostController {
	@Autowired
	private DeletePostModel deletePostModel;
	
	@PostMapping(value= "/deletePost")
	public ModelAndView deletePost(int postId, HttpSession httpSession) {
		deletePostModel.setBaseContent(httpSession);
		ModelAndView mav = deletePostModel.getModelAndView();
		
		boolean isUser = deletePostModel.testCredencials(httpSession, USER_ADMIN_LEVEL.admin.toString());
		
		if(isUser == false) {
			mav.clear();
			mav.setViewName("redirect:/login");
		}else {
			deletePostModel.deletePost(postId);
			
			mav.clear();
			mav.setViewName("redirect:/");
		}
		
		return mav;
	}
}
