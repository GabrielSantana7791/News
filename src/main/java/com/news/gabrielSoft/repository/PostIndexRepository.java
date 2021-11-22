package com.news.gabrielSoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.news.gabrielSoft.entity.PostIndex;

@Repository
public interface PostIndexRepository  extends JpaRepository<PostIndex, Long>{
	
	PostIndex findByText(String text);
	PostIndex findByTitle(String title);
	PostIndex findById(int id);
	PostIndex[] findByTextContaining(String text);
}
