package com.news.gabrielSoft.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.news.gabrielSoft.entity.PostIndex;
import com.news.gabrielSoft.entity.User;
import com.news.gabrielSoft.repository.PostIndexRepository;
import com.news.gabrielSoft.user.Login;

@Controller
public class NewPostController {
	@Autowired
	private PostIndexRepository indexRep;

	@Autowired
	private Login login;

	@GetMapping(value= "/novo-post")
	public String newPage(HttpSession session) {
		try {
			User user = (User) session.getAttribute("user");
			return login.validateAndRedirect(user, "pages/newPost");
		} catch (Exception e) {
			return "redirect:/login";
		}
	}

	@PostMapping(value= "/addPost")
	public String addPost(PostIndex postIndex, HttpSession session) {
		try{
			User user = (User) session.getAttribute("user");
			login.userTestCredencial(user);
			indexRep.save(postIndex);
			return "pages/newPost";
		}catch(Exception e) {
			return "redirect:/login";
		}
	}
}
