package com.news.gabrielSoft.models;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.entity.PostIndexEntity;
import com.news.gabrielSoft.repository.PostIndexRepository;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

@Service
public class IndexModel extends ModelImp{
	@Autowired
	private PostIndexRepository newsRep;

	@Override
	public void setBaseContent(HttpSession httpSession) {	
		modelAndView = new ModelAndView("base");
		List<PostIndexEntity> listPosts = newsRep.findAll();
		PostIndexEntity[]top3Posts = newsRep.findTop3ByOrderByViewNumberDesc();
		
		String pageFileName = "index";
		String pageTitle = "Index";
		
		this.setPageFileAndPageTitle(pageFileName, pageTitle);
		this.addContent(MODEL_ATTRIBUTES.top3.toString(),top3Posts);
		this.addContent(MODEL_ATTRIBUTES.section.toString(), listPosts);	
	}
}
