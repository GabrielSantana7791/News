package com.news.gabrielSoft.models.userSearch;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.classes.User;
import com.news.gabrielSoft.entity.UserEntity;
import com.news.gabrielSoft.models.ModelImp;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

@Service
public class UserPageModel extends ModelImp{
	@Autowired
	private User user;
	
	public UserPageModel() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setBaseContent(HttpSession httpSession) {
		modelAndView = new ModelAndView("base");
		String pageFileName = "user-page";
		String pageTitle = "User ...";
		
		this.setPageFileAndPageTitle(pageFileName, pageTitle);
	}
	
	public void searchUser(String userName) {
		UserEntity userEntity = user.searchUser(userName);
		
		addContent(MODEL_ATTRIBUTES.user.toString(), userEntity);
	}
}
