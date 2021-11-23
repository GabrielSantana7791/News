package com.news.gabrielSoft.controller.post;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.news.gabrielSoft.entity.PostIndex;
import com.news.gabrielSoft.entity.User;
import com.news.gabrielSoft.repository.PostIndexRepository;
import com.news.gabrielSoft.user.Login;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;
import com.news.gabrielSoft.util.USER_ADMIN_LEVEL;

@Controller
public class DeletePostController {
	@Autowired
	private PostIndexRepository indexRep;

	@Autowired
	private Login login;
	
	@GetMapping(value= "/deletePost")
	public String deletePost() {
		return "redirect:/";
	}

	@PostMapping(value= "/deletePost")
	public String deletePost(int postId, HttpSession session, Model model) {
		System.out.println(postId);
		try{
			User user = (User) session.getAttribute("user");
			login.userTestCredencial(user, USER_ADMIN_LEVEL.admin.toString());

			PostIndex pi = indexRep.findById(postId);		
			indexRep.delete(pi);

			model.addAttribute(MODEL_ATTRIBUTES.page.toString(), "editPost");
			model.addAttribute(MODEL_ATTRIBUTES.message.toString(), "Deletado com sucesso");
			return "base";
		}catch(Exception e) {
			return "redirect:/login";
		}
	}
}
