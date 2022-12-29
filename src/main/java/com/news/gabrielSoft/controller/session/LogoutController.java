package com.news.gabrielSoft.controller.session;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.models.session.LogoutModel;

@Controller
public class LogoutController{	
	@Autowired
	private LogoutModel logoutModel;
	
	@GetMapping(value="/logout")
	public ModelAndView logout (HttpSession httpSession) {
		logoutModel.setBaseContent(httpSession);
		
		ModelAndView mav = logoutModel.getModelAndView();
		
		return mav;
	}
}
