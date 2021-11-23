package com.news.gabrielSoft.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.news.gabrielSoft.entity.User;
import com.news.gabrielSoft.repository.UserRepository;
import com.news.gabrielSoft.user.Login;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

@Controller
public class SessionController {	
	@Autowired
	public UserRepository userRep;

	@Autowired
	public Login login;

	@PostMapping(value="/login")
	public String login(HttpSession session, User RequisitionUser,Model model) {
		try {
			//throw exception
			User user = login.userTestCredencial(RequisitionUser);
			session.setAttribute("user", user);
			session.setAttribute("userNavbar", "userNavbar/" + user.getUserLevel());
			session.setAttribute("adminLevel", user.getUserLevel());
			return "redirect:/";
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute(MODEL_ATTRIBUTES.page.toString(), "login");
			model.addAttribute(MODEL_ATTRIBUTES.errorMessage.toString(), "Usuário incorreto");

			return "base";

		}
	}

	@GetMapping(value="/login")
	public String login (Model model, HttpSession session) {
		try {
			model.addAttribute(MODEL_ATTRIBUTES.page.toString(), "login");
			model.addAttribute(MODEL_ATTRIBUTES.title.toString(), "Login");
			
			User user = (User) session.getAttribute("user");
			login.userTestCredencial(user);
			return "redirect:/";
		} catch (Exception e) {
			return "base";
		}
	}

	@GetMapping(value="/deslogar")
	public String deslogar (HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
