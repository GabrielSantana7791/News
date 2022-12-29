package com.news.gabrielSoft.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.models.IndexModel;

@Controller
public class IndexController{
	@Autowired
	private IndexModel indexModel;

	@GetMapping(value="/")
	public ModelAndView Index(HttpSession session, String redirect) throws Exception {
		//gambiarra para redirecionar... colocar no Model;
		if(redirect != null) {
			ModelAndView m = new ModelAndView("base");
			m.setViewName(("redirect:/" + redirect));

			return m;
		}

		indexModel.setBaseContent(session);

		ModelAndView mav = indexModel.getModelAndView();

		return mav;
	}
}
