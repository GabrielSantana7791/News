package com.news.gabrielSoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.news.gabrielSoft.entity.PostIndexEntity;

@Repository
public interface PostIndexRepository  extends JpaRepository<PostIndexEntity, Long>{
	
	PostIndexEntity findByText(String text);
	PostIndexEntity findByTitle(String title);
	PostIndexEntity findById(int id);
	PostIndexEntity[] findByTextContaining(String text);
	PostIndexEntity[] findByTitleContaining(String title);
	PostIndexEntity[] findTop3ByOrderByViewNumberDesc();
	
}
