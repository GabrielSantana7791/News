package com.news.gabrielSoft.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.entity.UserEntity;
import com.news.gabrielSoft.models.userSearch.DeleteAndEditUserModel;
import com.news.gabrielSoft.util.USER_ADMIN_LEVEL;

@Controller
public class DeleteAndEditUserController {
	@Autowired
	private DeleteAndEditUserModel deleteAndEditUserModel;

	@PostMapping(value="/editUser/{userId}")
	public ModelAndView editUser(HttpSession httpSession, @PathVariable int userId, UserEntity userEntity) {
		deleteAndEditUserModel.setBaseContent(httpSession);
		ModelAndView mav = deleteAndEditUserModel.getModelAndView();

		boolean isUser = deleteAndEditUserModel.testCredencials(httpSession, USER_ADMIN_LEVEL.admin.toString());
		
		if(isUser == false) {
			mav.clear();
			mav.setViewName("redirect:/login");
		}else {
			deleteAndEditUserModel.editUser(userId, userEntity);
			
			mav = deleteAndEditUserModel.getModelAndView();
			mav.setViewName("redirect:/user/" + userEntity.getUserName());
		}
		
		return mav;
	}

	@PostMapping(value="/deleteUser")
	public ModelAndView deleteUser (int userId, Model model, HttpSession httpSession) {	
		deleteAndEditUserModel.setBaseContent(httpSession);
		ModelAndView mav = deleteAndEditUserModel.getModelAndView();

		boolean isUser = deleteAndEditUserModel.testCredencials(httpSession, "admin");
		
		if(isUser == false) {
			mav.clear();
			mav.setViewName("redirect:/login");
		}else {
			deleteAndEditUserModel.deleteUser(userId);
			
			mav = deleteAndEditUserModel.getModelAndView();
			mav.setViewName("redirect:/");
		}
		
		return mav;
	}
}
