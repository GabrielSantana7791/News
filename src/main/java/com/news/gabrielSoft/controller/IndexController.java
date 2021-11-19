package com.news.gabrielSoft.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.news.gabrielSoft.entity.PostIndex;
import com.news.gabrielSoft.repository.PostIndexRepository;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

@Controller
public class IndexController {
	@Autowired
	public PostIndexRepository newsRep;

	@GetMapping(value="/")
	public String Index(Model model, HttpSession session) {
		model.addAttribute(MODEL_ATTRIBUTES.page.toString(), "index");
		model.addAttribute(MODEL_ATTRIBUTES.title.toString(), "Início");
		List<PostIndex> listPost = newsRep.findAll();

		model.addAttribute("section", listPost);

		return "base";
	}
}
