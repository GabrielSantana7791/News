package com.news.gabrielSoft.models.post;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.classes.Post;
import com.news.gabrielSoft.entity.PostIndexEntity;
import com.news.gabrielSoft.models.ModelImp;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

@Service
public class NewPostModel extends ModelImp{	
	@Autowired
	private Post post;
	
	public NewPostModel() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setBaseContent(HttpSession httpSession) {
		modelAndView = new ModelAndView("base");
		String pageFileName = "new-post";
		String pageTitle = "Write new post";
		
		this.setPageFileAndPageTitle(pageFileName, pageTitle);
	}
		
	public void newPost(String dateStr, PostIndexEntity postIndex) {		
		try {
			modelAndView.clear();
			
			dateStr = dateStr.replace('-', '/');
			Date date;
			date = new SimpleDateFormat("yyyy/MM/dd").parse(dateStr);
			
			postIndex.setDate(date);
			
			post.addPost(postIndex);
			
			addContent(MODEL_ATTRIBUTES.message.toString(), "Written successfully");
			addContent(MODEL_ATTRIBUTES.redirect.toString(), "postCode/" + postIndex.getId());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
