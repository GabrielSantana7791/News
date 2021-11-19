package com.news.gabrielSoft.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.news.gabrielSoft.entity.PostIndex;
import com.news.gabrielSoft.repository.PostIndexRepository;

@Controller
public class IndexController {
	@Autowired
	public PostIndexRepository newsRep;

	@GetMapping(value="/")
	public String Index(Model model, HttpSession session) {
		List<PostIndex> listPost = newsRep.findAll();

		model.addAttribute("section", listPost);

		return "base";
	}

}
