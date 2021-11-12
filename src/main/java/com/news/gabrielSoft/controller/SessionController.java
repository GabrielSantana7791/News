package com.news.gabrielSoft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.news.gabrielSoft.entity.User;
import com.news.gabrielSoft.repository.UserRepository;
import com.news.gabrielSoft.user.Login;

@Controller
public class SessionController {	
	@Autowired
	public UserRepository userRep;

	@Autowired
	public Login login;

	@PostMapping(value="/login")
	public String login(HttpSession session, User user, HttpServletRequest response) {
		session.setAttribute("user", user);
		response.setAttribute("errorMessage", "Usuário incorreto");

		try {
			login.testCredencial(user);
			return "redirect:/";
		} catch (Exception e) {
			return "pages/login";
		}
		
	}

	@GetMapping(value="/login")
	public String login (HttpSession session, HttpServletResponse response) {
		User user = (User) session.getAttribute("user");
		try {
			return login.redirectUrl(user, "redirect:/");
		} catch (Exception e) {
			return "/pages/login";
		}
	}

	@GetMapping(value="/deslogar")
	public String login (HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
