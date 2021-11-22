package com.news.gabrielSoft.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.news.gabrielSoft.entity.PostIndex;
import com.news.gabrielSoft.repository.PostIndexRepository;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

@Controller
public class findPostController {
	@Autowired
	private PostIndexRepository postRep;
	
	@GetMapping(value="/find")
	public String index2(String text, Model model, HttpSession session) {
		model.addAttribute(MODEL_ATTRIBUTES.page.toString(), "index");
		model.addAttribute(MODEL_ATTRIBUTES.title.toString(), "Início");
		
		if(text != null) {
			PostIndex[] post = postRep.findByTextContaining(text);
			
			model.addAttribute("section", post);
		}
		
		return "base";
	}

}
