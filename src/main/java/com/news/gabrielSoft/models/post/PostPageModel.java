package com.news.gabrielSoft.models.post;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.classes.Post;
import com.news.gabrielSoft.entity.CommentEntity;
import com.news.gabrielSoft.entity.PostIndexEntity;
import com.news.gabrielSoft.models.ModelImp;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

@Service
public class PostPageModel extends ModelImp{
	@Autowired
	private Post post;

	@Override
	public void setBaseContent(HttpSession httpSession) {	
		modelAndView = new ModelAndView("base");
		
		String pageFileName = "post-page";
		String pageTitle = "Article...";
		
		this.setPageFileAndPageTitle(pageFileName, pageTitle);
	}
	
	public void searchPost(int postCode) {
		PostIndexEntity postEntity = post.postIndex(postCode);
		post.addViewNumber(postCode);
		List<CommentEntity> comments = postEntity.getComments();
		
		modelAndView.addObject(MODEL_ATTRIBUTES.comments.toString(), comments);
		modelAndView.addObject(MODEL_ATTRIBUTES.section.toString(), postEntity);
	}
}
