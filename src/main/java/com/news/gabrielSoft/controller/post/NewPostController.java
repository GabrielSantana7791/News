package com.news.gabrielSoft.controller.post;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.entity.PostIndexEntity;
import com.news.gabrielSoft.models.post.NewPostModel;
import com.news.gabrielSoft.util.USER_ADMIN_LEVEL;

@Controller
public class NewPostController{
	@Autowired
	private NewPostModel newPostModel;
	
	@GetMapping(value= "/newpost")
	public ModelAndView newPost(Model model, HttpSession httpSession) {
		newPostModel.setBaseContent(httpSession);
		ModelAndView mav = newPostModel.getModelAndView();

		boolean isUser = newPostModel.testCredencials(httpSession, USER_ADMIN_LEVEL.admin.toString());
		
		if(isUser == false) {
			mav.clear();
			mav.setViewName("redirect:/login");
		}else {

		}
		
		return mav;
	}

	@PostMapping(value= "/newpost")
	public ModelAndView addPost(String dateStr, PostIndexEntity postIndex, HttpSession httpSession, Model model) {		
		newPostModel.setBaseContent(httpSession);
		ModelAndView mav = newPostModel.getModelAndView();

		boolean isUser = newPostModel.testCredencials(httpSession, "admin");
		
		if(isUser == false) {
			mav.clear();
			mav.setViewName("redirect:/login");
		}else {
			newPostModel.newPost(dateStr, postIndex);
			newPostModel.getModelAndView().setViewName("redirect:/");
			
		}
		
		return mav;
	}
}
