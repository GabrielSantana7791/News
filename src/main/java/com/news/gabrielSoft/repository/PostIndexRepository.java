package com.news.gabrielSoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.news.gabrielSoft.entity.PostIndex;
import com.news.gabrielSoft.entity.PostProjects;

@Repository
public interface PostIndexRepository  extends JpaRepository<PostIndex, Long>{
	
	PostProjects findByText(String text);
	PostProjects findByTitle(String title);

}
