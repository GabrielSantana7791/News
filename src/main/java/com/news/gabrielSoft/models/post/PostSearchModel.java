package com.news.gabrielSoft.models.post;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.classes.Post;
import com.news.gabrielSoft.entity.PostIndexEntity;
import com.news.gabrielSoft.models.ModelImp;

@Service
public class PostSearchModel extends ModelImp{
	@Autowired
	private Post post;

	@Override
	public void setBaseContent(HttpSession httpSession) {	
		modelAndView = new ModelAndView("base");
		
		String pageFileName = "index2";
		String pageTitle = "Search...";
		
		this.setPageFileAndPageTitle(pageFileName, pageTitle);
	}
	
	public void searchPost(String text) {
		PostIndexEntity[] post = this.post.findByTextContaining(text);
		
		modelAndView.addObject("section", post);
	}
}
