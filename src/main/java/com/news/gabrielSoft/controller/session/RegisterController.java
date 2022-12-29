package com.news.gabrielSoft.controller.session;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.entity.UserEntity;
import com.news.gabrielSoft.models.session.RegisterModel;

@Controller
public class RegisterController{
	@Autowired
	private RegisterModel registerModel;

	@GetMapping(value="/register")
	public ModelAndView Register(HttpSession session) {		
		ModelAndView mav;
		
		//ALTERAR AUTENTICAÇÃO / COMO USUARIO É ARMAZENADO NO CLIENT
		boolean isUserLogged = registerModel.testCredencials(session);
	
		if(isUserLogged == true) {
			mav = new ModelAndView("redirect:/");
			
		}else {
			registerModel.setBaseContent(session);
			mav = registerModel.getModelAndView();
		}
				
		return mav;
	}

	@PostMapping(value= "/register")
	public ModelAndView Registerr(UserEntity newUser)  {
		registerModel.register(newUser);
		
		ModelAndView mav = registerModel.getModelAndView();
	
		return mav;
	}
}
