package com.news.gabrielSoft.controller.post;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.news.gabrielSoft.classes.Page;
import com.news.gabrielSoft.classes.Post;
import com.news.gabrielSoft.entity.CommentEntity;
import com.news.gabrielSoft.entity.PostIndexEntity;
import com.news.gabrielSoft.repository.CommentRepository;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

@Controller
public class PostPageController extends Page{	
	@Autowired
	public CommentRepository commentRep;
	
	@Autowired
	public Post post;

	@GetMapping(value="/postCode/{postCode}")
	public String postController(@PathVariable int postCode, Model model, HttpSession httpSession) {
		try {
			title = "Post";
			pageFile = "postPage";
			pageInitializer(model, httpSession);
		} catch (Exception e) {
			//ignore
		}
		
		PostIndexEntity post = this.post.postIndex(postCode);
		List<CommentEntity> comments = post.getComments();
		
		model.addAttribute("comments", comments);
		model.addAttribute(MODEL_ATTRIBUTES.section.toString(), post);
		
		return "base";
	}
}
