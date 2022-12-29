package com.news.gabrielSoft.models.userSearch;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.classes.User;
import com.news.gabrielSoft.entity.UserEntity;
import com.news.gabrielSoft.models.ModelImp;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

@Service
public class DeleteAndEditUserModel extends ModelImp{	
	@Autowired
	private User user;
	
	public DeleteAndEditUserModel() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setBaseContent(HttpSession httpSession) {
		modelAndView = new ModelAndView("base");
	}
		
	public void editUser(int userId, UserEntity userEntity) {
		user.editUser(userId, userEntity);
		
		modelAndView.clear();
		addContent(MODEL_ATTRIBUTES.message.toString(), "Success");
	}

	public void deleteUser(int userId) {
		user.deleteUser(userId);
		
		modelAndView.clear();
		addContent(MODEL_ATTRIBUTES.message.toString(), "Success");
	}
}
