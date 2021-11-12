package com.news.gabrielSoft.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.gabrielSoft.entity.User;
import com.news.gabrielSoft.repository.UserRepository;

@Service
public class Login {
	@Autowired
	UserRepository userRep;

	public void testCredencial(User user) throws Exception{
		if(userRep.findByUserNameAndPassword(user.getUserName(), user.getPassword()) == null) {
			throw new Exception("Usuário não existe");
		}
	}

	public String redirectUrl(User user, String url) throws Exception{
		testCredencial(user);
		return url;
	}
}
