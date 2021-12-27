package com.news.gabrielSoft.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.news.gabrielSoft.classes.Page;
import com.news.gabrielSoft.classes.Session;
import com.news.gabrielSoft.classes.User;
import com.news.gabrielSoft.entity.UserEntity;
import com.news.gabrielSoft.repository.CommentRepository;
import com.news.gabrielSoft.repository.UserRepository;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

@Controller
public class UserPageController extends Page{
	@Autowired
	public UserRepository userRep;
	
	@Autowired
	public CommentRepository commentRep;
	
	@Autowired
	public Session session;
	
	@Autowired
	public User user;

	@GetMapping(value="/user/{userName}")
	public String postController(@PathVariable String userName, Model model, HttpSession httpSession) {
		try {
			pageFile = "userPage";
			title = "userPage";
			pageInitializer(model, httpSession);
		} catch (Exception e) {
			session.deslogar(httpSession);
		
			return "redirect:/login";
		}
		
		UserEntity user = this.user.searchUser(userName);
		model.addAttribute("user", user);//
		
		return "base";
	}
	
	
	@PostMapping(value="/editUser/{userId}")
	public String editUser(Model model, HttpSession httpSession, @PathVariable int userId, UserEntity userEntity) {
		try {
			pageFile = "userPage";
			title = "userPage";
			pageInitializer(model, httpSession);
		} catch (Exception e) {
			session.deslogar(httpSession);
			
			return "redirect:/login";
		}

		UserEntity user = this.user.editUser(userId, userEntity);
			
		model.addAttribute(MODEL_ATTRIBUTES.message.toString(), "Success");
		model.addAttribute(MODEL_ATTRIBUTES.user.toString(), user);
		
		return "base";
	}
	
	@GetMapping(value="/editUser/{userId}")
	public String teaste(@PathVariable int userId) {
		
		return "redirect:/userSearch";
	}
	
	@PostMapping(value="/deleteUser")
	public String deleteUser (int userId, Model model, HttpSession httpSession) {
		try {
			pageFile = "userSearch";
			title = "User Search";
			
			session.userTestCredencial(httpSession);
		} catch (Exception e) {
			return "redirect:/login";
		}
				
		try {
			user.deleteUser(userId);
			model.addAttribute(MODEL_ATTRIBUTES.message.toString(), "Success");
			
			pageInitializer(model, httpSession);
			
			return "base";
		} catch (Exception e) {	
			return "redirect:/";
		}
	}
}
