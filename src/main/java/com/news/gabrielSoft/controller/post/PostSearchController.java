package com.news.gabrielSoft.controller.post;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.models.post.PostSearchModel;

@Controller
public class PostSearchController{
	@Autowired
	private PostSearchModel postSearchModel;

	@GetMapping(value="/find")
	public ModelAndView postSearch(String text, HttpSession httpSession) {
		postSearchModel.setBaseContent(httpSession);
		postSearchModel.searchPost(text);		
		
		ModelAndView mav = postSearchModel.getModelAndView();
		
		return mav;		
	}
}
