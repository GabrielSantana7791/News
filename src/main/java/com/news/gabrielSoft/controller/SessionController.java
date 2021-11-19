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
	public String login(HttpSession session, User RequisitionUser, HttpServletRequest response) {
		try {
			//throw exception
			User user = login.userTestCredencial(RequisitionUser);
			session.setAttribute("user", user);
			session.setAttribute("userNavbar", "userNavbar/" + user.getUserLevel());
			return "redirect:/";
		} catch (Exception e) {
			response.setAttribute("errorMessage", "Usuário incorreto");
			return "pages/login";
		}

	}

	@GetMapping(value="/login")
	public String login (HttpSession session, HttpServletResponse response) {
		try {
			User user = (User) session.getAttribute("user");
			return login.validateAndRedirect(user, "redirect:/");
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
