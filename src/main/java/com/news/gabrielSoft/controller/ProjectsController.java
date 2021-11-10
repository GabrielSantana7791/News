package com.news.gabrielSoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectsController {
	
	@GetMapping(value= "/projetos")
	public String Projects() {
		
		return "pages/projects";
	}

}
