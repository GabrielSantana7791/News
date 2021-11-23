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
public class EditPostController {
	@Autowired
	private PostIndexRepository indexRep;

	@Autowired
	private Login login;

	@GetMapping(value= "/edit-post")
	public String editPost(String postId, Model model, HttpSession session) {
		try {
			model.addAttribute(MODEL_ATTRIBUTES.page.toString(), "editPost");
			model.addAttribute(MODEL_ATTRIBUTES.title.toString(), "Editar post");
			User user = (User) session.getAttribute("user");
			
			PostIndex postIndex = indexRep.findById(Integer.parseInt(postId));
			
			model.addAttribute("postContent", postIndex);
			
			

			login.userTestCredencial(user, "admin");
			return "base";
		} catch (Exception e) {
			System.out.println(e);
			return "redirect:/login";
		}
	}

	@PostMapping(value= "/editPost")
	public String editPost(PostIndex postIndex, HttpSession session, Model model) {
		try{
			User user = (User) session.getAttribute("user");
			login.userTestCredencial(user, USER_ADMIN_LEVEL.admin.toString());
			
			PostIndex postDB = indexRep.findByText(postIndex.getText());
			postDB.setText(postIndex.getText());
			postDB.setDate(postIndex.getDate());
			postDB.setTitle(postIndex.getTitle());
			
			indexRep.flush();
			
			model.addAttribute(MODEL_ATTRIBUTES.page.toString(), "editPost");
			model.addAttribute(MODEL_ATTRIBUTES.message.toString(), "Editado com sucesso");
			model.addAttribute("postContent", postDB);
			return "base";
		}catch(Exception e) {
			return "redirect:/login";
		}
	}

	@GetMapping(value= "/editPost")
	public String editPost() {
		return "redirect:/";
	}
}
