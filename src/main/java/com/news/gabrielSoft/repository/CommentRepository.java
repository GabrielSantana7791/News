package com.news.gabrielSoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.news.gabrielSoft.entity.CommentEntity;

@Repository
public interface CommentRepository  extends JpaRepository<CommentEntity, Long>{
	
	List<CommentEntity> findByPostIndexIdOrderByIdDesc(int postIndexId);
}
