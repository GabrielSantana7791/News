package com.news.gabrielSoft.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.news.gabrielSoft.entity.PostIndex;
import com.news.gabrielSoft.entity.User;
import com.news.gabrielSoft.repository.PostIndexRepository;
import com.news.gabrielSoft.user.Login;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

@Controller
public class NewPostController {
	@Autowired
	private PostIndexRepository indexRep;

	@Autowired
	private Login login;

	@GetMapping(value= "/novo-post")
	public String newPage(Model model, HttpSession session) {
		try {
			model.addAttribute(MODEL_ATTRIBUTES.page.toString(), "newPost");
			model.addAttribute(MODEL_ATTRIBUTES.title.toString(), "Adicionar novo post");
			User user = (User) session.getAttribute("user");
			return login.validateAndRedirect(user, "base");
		} catch (Exception e) {
			return "redirect:/login";
		}
	}

	@PostMapping(value= "/addPost")
	public String addPost(PostIndex postIndex, HttpSession session, Model model) {
		try{
			User user = (User) session.getAttribute("user");
			login.userTestCredencial(user);
			indexRep.save(postIndex);
			model.addAttribute(MODEL_ATTRIBUTES.page.toString(), "newPost");
			model.addAttribute(MODEL_ATTRIBUTES.message.toString(), "true");
			return "base";
		}catch(Exception e) {
			return "redirect:/login";
		}
	}

	@GetMapping(value= "/addPost")
	public String addPost() {
		return "redirect:/";
	}
}
