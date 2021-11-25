package com.news.gabrielSoft.controller.post;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.news.gabrielSoft.classes.Page;
import com.news.gabrielSoft.entity.PostIndexEntity;
import com.news.gabrielSoft.repository.PostIndexRepository;

@Controller
public class findPostController extends Page{
	@Autowired
	private PostIndexRepository postRep;

	@GetMapping(value="/find")
	public String index2(String text, Model model, HttpSession session) {
		try {
			title = "Find post";
			pageFile = "index";
			pageInitializer(model, session);
			
		} catch (Exception e) {
			//ignore
		}
		
		PostIndexEntity[] post = postRep.findByTextContaining(text);
		model.addAttribute("section", post);
		
		return "base";
	}
}
