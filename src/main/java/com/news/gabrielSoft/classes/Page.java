package com.news.gabrielSoft.classes;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.news.gabrielSoft.entity.UserEntity;
import com.news.gabrielSoft.user.Session;
import com.news.gabrielSoft.util.MODEL_ATTRIBUTES;

public abstract class Page {
	@Autowired
	Session session;

	protected String pageFile, title;

	protected void pageInitializer(Model model, HttpSession httpSession) throws Exception {
		if(pageFile == null || title == null) {
			throw new Exception("Nome da página ou título não podem estar vazios");
		}
		
		model.addAttribute(MODEL_ATTRIBUTES.page.toString(), pageFile);
		model.addAttribute(MODEL_ATTRIBUTES.title.toString(), title);

		UserEntity user = (UserEntity) httpSession.getAttribute("user");

		if(!user.equals(null)) {
			session.userTestCredencial(user);

		}
	}
}
