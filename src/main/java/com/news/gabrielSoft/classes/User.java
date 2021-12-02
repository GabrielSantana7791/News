package com.news.gabrielSoft.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.gabrielSoft.entity.UserEntity;
import com.news.gabrielSoft.repository.CommentRepository;
import com.news.gabrielSoft.repository.UserRepository;

@Service
public class User {
	@Autowired
	CommentRepository commentRep;

	@Autowired
	UserRepository userRep;

	public void deleteUser(int userId) {
		UserEntity user = userRep.findById(userId);
//		commentRep.deleteAll();
		commentRep.deleteAllInBatch();

		userRep.delete(user);

		userRep.flush();
	}
	
	public UserEntity editUser(int userId, UserEntity userEntity) {
		UserEntity user =  userRep.findById(userId);
		user.setUserNameAndPasswordAndUserLevel(userEntity.getUserName(), userEntity.getPassword(), userEntity.getUserLevel());
		
		userRep.flush();
		
		return user;
	}
	
	public UserEntity searchUser(String userName) {
		return userRep.findByUserName(userName);
	}
	
	public void register(UserEntity user) throws Exception {
		if(userRep.existsByUserName(user.getUserName()) == false) {
			user.setUserLevel("user");
			userRep.save(user);
		}else {
			throw new Exception("Usuário já existe");
		}	
	}
}
