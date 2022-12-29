package com.news.gabrielSoft.models.post;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.classes.Post;
import com.news.gabrielSoft.entity.PostIndexEntity;
import com.news.gabrielSoft.models.ModelImp;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

@Service
public class EditPostModel extends ModelImp{	
	@Autowired
	private Post post;
	
	public EditPostModel() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setBaseContent(HttpSession httpSession) {
		modelAndView = new ModelAndView("base");
		
		String pageFileName = "edit-post";
		String pageTitle = "Edit post";
		
		this.setPageFileAndPageTitle(pageFileName, pageTitle);
	}
	
	public void addPostInContent(int postId) {
		PostIndexEntity postIndex = post.postIndex(postId);
		
		addContent(MODEL_ATTRIBUTES.postContent.toString(), postIndex);
	}
		
	public void editPost(int postId, PostIndexEntity postIndexEntity) {
		post.editPost(postId, postIndexEntity);
		
		modelAndView.clear();
		addContent(MODEL_ATTRIBUTES.postId.toString(), postId);
		addContent(MODEL_ATTRIBUTES.message.toString(), "Success");
	}
}
