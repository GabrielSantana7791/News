package com.news.gabrielSoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutMeController {
	
	@GetMapping(value= "/sobre-mim")
	public String AboutMe() {
		
		return "pages/aboutMe";
	}

}
