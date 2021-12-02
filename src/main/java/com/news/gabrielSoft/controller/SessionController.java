package com.news.gabrielSoft.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.news.gabrielSoft.classes.Page;
import com.news.gabrielSoft.classes.Session;
import com.news.gabrielSoft.entity.UserEntity;
import com.news.gabrielSoft.repository.UserRepository;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

@Controller
public class SessionController extends Page{	
	@Autowired
	public UserRepository userRep;

	@Autowired
	public Session session;
	
	@GetMapping(value="/deslogar")
	public String deslogar (HttpSession httpSession) {
		session.deslogar(httpSession);
		return "redirect:/";
	}
	
	@GetMapping(value="/login")
	public String login (Model model, HttpSession httpSession) {
		try {
			pageFile = "login";
			title = "Login";
			pageInitializer(model, httpSession);
			return "redirect:/";
		} catch (Exception e) {
			return "base";
		}
	}

	@PostMapping(value="/login")
	public String login(HttpSession httpSession, UserEntity RequisitionUser,Model model) {
		try {
			session.login(httpSession, RequisitionUser);
			return "redirect:/";
		} catch (Exception e) {
			model.addAttribute(MODEL_ATTRIBUTES.page.toString(), "login");
			model.addAttribute(MODEL_ATTRIBUTES.errorMessage.toString(), "Usuário incorreto");
			return "base";
		}
	}
}
