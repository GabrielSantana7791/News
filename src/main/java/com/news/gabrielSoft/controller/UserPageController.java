package com.news.gabrielSoft.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.models.userSearch.UserPageModel;
import com.news.gabrielSoft.util.USER_ADMIN_LEVEL;

@Controller
public class UserPageController{
	@Autowired
	public UserPageModel userPageModel;

	@GetMapping(value="/user/{userName}")
	public ModelAndView userPage(@PathVariable String userName, HttpSession httpSession) {		
		userPageModel.setBaseContent(httpSession);
		ModelAndView mav = userPageModel.getModelAndView();
		
		boolean isUser = userPageModel.testCredencials(httpSession, USER_ADMIN_LEVEL.admin.toString());
		
		if(isUser == false) {
			mav.clear();
			mav.setViewName("redirect:/login");
		}
		else {
			userPageModel.searchUser(userName);
		}
			
		return mav;
	}
}
