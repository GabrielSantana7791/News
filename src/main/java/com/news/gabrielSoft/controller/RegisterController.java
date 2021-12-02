package com.news.gabrielSoft.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.news.gabrielSoft.classes.Page;
import com.news.gabrielSoft.classes.User;
import com.news.gabrielSoft.entity.UserEntity;
import com.news.gabrielSoft.repository.UserRepository;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

@Controller
public class RegisterController extends Page{
	@Autowired
	public UserRepository userRep;
	
	@Autowired
	public User user;

	@GetMapping(value="/register")
	public String Register(UserEntity user, Model model, HttpSession session) {
		try {
			pageFile = "Register";
			title = "Register";
			pageInitializer(model, session);//
		} catch (Exception e) {
			return "base";
		}
		return "redirect:/login";
	}

	@PostMapping(value= "/register")
	public String Registerr(UserEntity user, Model model, HttpSession httpSession)  {
		model.addAttribute(MODEL_ATTRIBUTES.page.toString(), "register");
		
		try {
			this.user.register(user);
			model.addAttribute(MODEL_ATTRIBUTES.message.toString(), "Registrado com sucesso");
			
		} catch (Exception e) {
			model.addAttribute(MODEL_ATTRIBUTES.errorMessage.toString(), "Usuário já existe");
			
		}
	
		return "base";
	}
}
