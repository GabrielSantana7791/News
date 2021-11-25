package com.news.gabrielSoft.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.news.gabrielSoft.classes.Page;
import com.news.gabrielSoft.entity.UserEntity;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;
import com.news.gabrielSoft.util.User;

@Controller
public class UserSearchController extends Page{
	@Autowired
	User user;
	
	@GetMapping(value="/userSearch")
	public String postControllerr(String userName, Model model, HttpSession session) {
		try {
			pageFile = "userSearch";
			title = "user Search";
			pageInitializer(model, session);
		} catch (Exception e) {
			session.invalidate();
			return "redirect:/";
		}
		
		UserEntity user = this.user.searchUser(userName);
		
		model.addAttribute(MODEL_ATTRIBUTES.user.toString(), user);
		
		return "base";
	}
}
