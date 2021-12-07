package com.news.gabrielSoft.controller.post;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.news.gabrielSoft.classes.Post;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

@Controller
public class DeletePostController {
	@Autowired
	private Post post;
	
	@GetMapping(value= "/deletePost")
	public String deletePost() {
		return "redirect:/";
	}

	@PostMapping(value= "/deletePost")
	public String deletePost(int postId, HttpSession session, Model model) {
		try{
			post.deletePost(session, postId);
			model.addAttribute(MODEL_ATTRIBUTES.page.toString(), "newPost");
			model.addAttribute(MODEL_ATTRIBUTES.title.toString(), "Delete post");
			model.addAttribute(MODEL_ATTRIBUTES.message.toString(), "Post deletado com sucesso");
			return "base";
			
		}catch(Exception e) {
			return "redirect:/login";
		}
	}
}
