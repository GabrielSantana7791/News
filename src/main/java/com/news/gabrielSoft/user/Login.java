package com.news.gabrielSoft.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.gabrielSoft.entity.User;
import com.news.gabrielSoft.repository.UserRepository;

@Service
public class Login {
	@Autowired
	UserRepository userRep;

	public User userTestCredencial(User user) throws Exception{
		user = userRep.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		
		return user;
	}
	
	public User userTestCredencial(User user, String userLevel) throws Exception{
		user = userRep.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		
		if(userLevel.equals(user.getUserLevel())) {
			System.out.println(user.getUserLevel());
			return user;
		}
		
		throw new Exception("Usuário nsão existe");
	}
	
}
