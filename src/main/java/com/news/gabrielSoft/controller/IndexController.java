package com.news.gabrielSoft.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.news.gabrielSoft.classes.Page;
import com.news.gabrielSoft.entity.PostIndexEntity;
import com.news.gabrielSoft.repository.PostIndexRepository;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

@Controller
public class IndexController extends Page {
	@Autowired
	public PostIndexRepository newsRep;

	@GetMapping(value="/")
	public String Index(Model model, HttpSession session) {
		try {
			pageFile = "index";
			title = "index";
			pageInitializer(model, session);
		} catch (Exception e) {
		}

		List<PostIndexEntity> listPost = newsRep.findAll();
		model.addAttribute(MODEL_ATTRIBUTES.section.toString(), listPost);
		
		return "base";
	}
}
