package com.news.gabrielSoft.controller.post;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.entity.PostIndexEntity;
import com.news.gabrielSoft.models.post.EditPostModel;
import com.news.gabrielSoft.util.USER_ADMIN_LEVEL;

@Controller
public class EditPostController{
	@Autowired
	private EditPostModel editPostModel;

	@GetMapping(value= "/edit-post")
	public ModelAndView editPost(int postId, HttpSession httpSession) {
		editPostModel.setBaseContent(httpSession);
		ModelAndView mav = editPostModel.getModelAndView();
		
		boolean isUser = editPostModel.testCredencials(httpSession, USER_ADMIN_LEVEL.admin.toString());
		
		if(isUser == false) {
			mav.clear();
			mav.setViewName("redirect:/login");
		}else {
			editPostModel.addPostInContent(postId);
		}
		
		return mav;
	}

	@PostMapping(value= "/editPost/{postId}")
	public ModelAndView editPost(@PathVariable int postId, String dateStr, PostIndexEntity postIndex, HttpSession httpSession, Model model) {
		//formatar data
		Date date = formatDate(dateStr);
		postIndex.setDate(date);

		editPostModel.setBaseContent(httpSession);
		ModelAndView mav = editPostModel.getModelAndView();
		
		boolean isUser = editPostModel.testCredencials(httpSession, "admin");
		
		if(isUser == false) {
			mav.clear();
			mav.setViewName("redirect:/login");
		}else {
			
			editPostModel.editPost(postId, postIndex);
			mav.setViewName("redirect:/edit-post");
		}
		
		return mav;
	}
	
	@SuppressWarnings("deprecation")
	private Date formatDate(String dateStr) {
		Date date;
		
		try {
			dateStr = dateStr.replace('-', '/');
		
			date = new SimpleDateFormat("yyyy/MM/dd").parse(dateStr);
		} catch (ParseException e) {
			date = new Date(1999, 12, 12);
		}
		
		return date;
	}
}
