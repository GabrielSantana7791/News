package com.news.gabrielSoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.news.gabrielSoft.entity.UserEntity;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Long>{
	
	UserEntity findById(int id);
	UserEntity findByUserName(String text);
	UserEntity findByUserNameAndPassword(String userName, String password);
	boolean existsByUserName(String userName);

}
