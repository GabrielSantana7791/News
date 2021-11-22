package com.news.gabrielSoft.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.news.gabrielSoft.entity.PostIndex;
import com.news.gabrielSoft.repository.PostIndexRepository;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

@Controller
public class PostPageController {
	@Autowired
	public PostIndexRepository newsRep;

	@GetMapping(value="/postCode/{postCode}")
	public String postController(@PathVariable int postCode, Model model, HttpSession session) {
		model.addAttribute(MODEL_ATTRIBUTES.page.toString(), "index");
		model.addAttribute(MODEL_ATTRIBUTES.title.toString(), "Início");
		System.out.println(postCode);
		PostIndex post = newsRep.findById(postCode);
		
		model.addAttribute(MODEL_ATTRIBUTES.section.toString(), post);
		return "base";
	}
}
