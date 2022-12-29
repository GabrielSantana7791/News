package com.news.gabrielSoft.models;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface IModel {
	ModelAndView getModelAndView() throws Exception;
	boolean testCredencials(HttpSession httpSession);
	boolean testCredencials(HttpSession httpSession, String userLevel);
	void setPageFileAndPageTitle(String pageFileName, String pageTitle);
	void addContent(String name, Object value);
	void setBaseContent(HttpSession httpSession);
	void addErrorMessage(String msg);
	void addSuccessMessage(String msg);
}
