package com.news.gabrielSoft.models.session;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.classes.Session;
import com.news.gabrielSoft.models.ModelImp;

@Service
public class LogoutModel extends ModelImp{
	@Autowired
	Session session;

	public LogoutModel() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setBaseContent(HttpSession httpSession) {
		modelAndView = new ModelAndView();
		
		session.deslogar(httpSession);
		modelAndView.clear();
		modelAndView = new ModelAndView("redirect:/");		
	}
}
