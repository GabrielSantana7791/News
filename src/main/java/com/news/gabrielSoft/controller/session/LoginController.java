package com.news.gabrielSoft.controller.session;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.entity.UserEntity;
import com.news.gabrielSoft.models.session.LoginModel;

@Controller
public class LoginController{	
	@Autowired
	private LoginModel loginModel;
	
	@GetMapping(value="/login")
	public ModelAndView login (Model model, HttpSession httpSession) {
		loginModel.setBaseContent(httpSession);
		ModelAndView mav = loginModel.getModelAndView();
		
		boolean isUserLogged = loginModel.testCredencials(httpSession);
		
		if(isUserLogged == false) {
			mav = loginModel.getModelAndView();
			
		}else {
			mav.clear();
			mav.setViewName("redirect:/");
		}
		
		return mav;
	}

	@PostMapping(value="/login")
	public ModelAndView login(HttpSession httpSession, UserEntity requisitionUser) {
		loginModel.setBaseContent(httpSession);
		ModelAndView mav = new ModelAndView();
		
		try {
			loginModel.login(httpSession, requisitionUser);
			mav.setViewName("redirect:/");
			
		} catch (Exception e) {
			mav.clear();
			mav.setViewName("redirect:/");
		
			loginModel.addContent("errorMessage", "Usuário ou senha errada");
		}
		
		return mav;
	}
}
