package com.news.gabrielSoft.models.session;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.classes.User;
import com.news.gabrielSoft.entity.UserEntity;
import com.news.gabrielSoft.models.ModelImp;

@Service
public class RegisterModel extends ModelImp{
	
	@Autowired
	private User user;

	@Override
	public void setBaseContent(HttpSession httpSession) {
		modelAndView = new ModelAndView("base");
		
		String pageFileName = "register";
		String pageTitle = "Register";
		
		setPageFileAndPageTitle(pageFileName, pageTitle);		
	}
	
	public void register(UserEntity newUser) {
		modelAndView = new ModelAndView("redirect:/register");
		try {
			user.register(newUser);
					
			addSuccessMessage("Registered successfully");
			
		} catch (Exception e) {
			addErrorMessage("Username already exists");
		}
	}
}
