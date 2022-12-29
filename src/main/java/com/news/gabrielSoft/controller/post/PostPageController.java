package com.news.gabrielSoft.controller.post;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.models.post.PostPageModel;

@Controller
public class PostPageController{	
	@Autowired
	private PostPageModel postPageModel;

	@GetMapping(value="/postCode/{postCode}")
	public ModelAndView postPage(@PathVariable int postCode, HttpSession httpSession) {
		postPageModel.setBaseContent(httpSession);
		postPageModel.searchPost(postCode);
		
		ModelAndView mav = postPageModel.getModelAndView();
		
		return mav;
	}
}
