package com.news.gabrielSoft.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.models.userSearch.UserSearchModel;
import com.news.gabrielSoft.util.USER_ADMIN_LEVEL;

@Controller
public class UserSearchController{
	@Autowired
	UserSearchModel userSearchModel;
	
	@GetMapping(value="/userSearch")
	public ModelAndView userSearch(String userName, Model model, HttpSession httpSession) {
		userSearchModel.setBaseContent(httpSession);
		ModelAndView mav = userSearchModel.getModelAndView();
		
		boolean isUser = userSearchModel.testCredencials(httpSession, USER_ADMIN_LEVEL.admin.toString());
		
		if(isUser == false) {
			mav.clear();
			mav.setViewName("redirect:/login");
		}else {
			userSearchModel.searchUser(userName);
		}
		
		return mav;
	}
}
