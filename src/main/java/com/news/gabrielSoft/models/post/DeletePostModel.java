package com.news.gabrielSoft.models.post;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.classes.Post;
import com.news.gabrielSoft.models.ModelImp;

@Service
public class DeletePostModel extends ModelImp{	
	@Autowired
	private Post post;
	
	public DeletePostModel() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setBaseContent(HttpSession httpSession) {
		modelAndView = new ModelAndView();
	}
		
	public void deletePost(int postId) {
		post.deletePost(postId);
		
		modelAndView.clear();
		addSuccessMessage("Success");
	}
}
