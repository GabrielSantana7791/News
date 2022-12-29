package com.news.gabrielSoft.models;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.news.gabrielSoft.entity.UserEntity;
import com.news.gabrielSoft.repository.UserRepository;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

@Component
public abstract class ModelImp implements IModel{
	protected ModelAndView modelAndView;
	
	@Autowired
	private UserRepository userRep;
	
	@Override
	public ModelAndView getModelAndView(){
		return modelAndView;
	}

	@Override
	public void setPageFileAndPageTitle(String pageFileName, String pageTitle) {	
		modelAndView.addObject("page", pageFileName);
		modelAndView.addObject("title", pageTitle);
	}
	
	@Override
	public void addContent(String name, Object value) {
		modelAndView.addObject(name, value);
	}	
	
	@Override
	public boolean testCredencials(HttpSession httpSession ) {
		UserEntity user = (UserEntity) httpSession.getAttribute("user");
		try {
			user = userRep.findByUserNameAndPassword(user.getUserName(), user.getPassword());
			
			if(user.equals(null)) {
				return false;
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean testCredencials(HttpSession httpSession, String userLevel) {
		UserEntity user = (UserEntity) httpSession.getAttribute("user");
		try {
			user = userRep.findByUserNameAndPassword(user.getUserName(), user.getPassword());
			
			if(user.equals(null) || !user.getUserLevel().equals(userLevel)) {
				httpSession.invalidate();
				
				return false;
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void addErrorMessage(String msg) {
		modelAndView.addObject(MODEL_ATTRIBUTES.errorMessage.toString(), msg);
		
	}

	@Override
	public void addSuccessMessage(String msg) {
		modelAndView.addObject(MODEL_ATTRIBUTES.message.toString(), msg);
		
	}

	
}
