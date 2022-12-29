package com.news.gabrielSoft.models.session;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.classes.Session;
import com.news.gabrielSoft.entity.UserEntity;
import com.news.gabrielSoft.models.ModelImp;

@Service
public class LoginModel extends ModelImp{
	@Autowired
	Session session;

	public LoginModel() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setBaseContent(HttpSession httpSession) {
		modelAndView = new ModelAndView("base");
		String pageFileName = "login";
		String pageTitle = "Login";
		
		this.setPageFileAndPageTitle(pageFileName, pageTitle);
		
	}
	
	public void login(HttpSession httpSession, UserEntity userEntity) throws Exception {		
		session.login(httpSession, userEntity);
	}
}
