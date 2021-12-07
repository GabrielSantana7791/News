package com.news.gabrielSoft.classes;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.gabrielSoft.entity.UserEntity;
import com.news.gabrielSoft.repository.UserRepository;
import com.news.gabrielSoft.util.USER_ADMIN_LEVEL;

@Service
public class Session {
	@Autowired
	UserRepository userRep;

	public UserEntity userTestCredencial(UserEntity user) throws Exception {
		user = userRep.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		
		if(user.equals(null)) {
			throw new Exception("Usuário não encontrado");
		}
		
		return user;
	}
	
	public UserEntity userTestCredencial(HttpSession httpSession) throws Exception {
		UserEntity user = (UserEntity) httpSession.getAttribute("user");
		UserEntity userDB = userRep.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		
		if(!user.equals(null) && !userDB.equals(null)) {
			return userDB;
		}else {
			throw new Exception("Usuário não encontrado");
		}
	}
	
	public UserEntity userTestCredencial(HttpSession httpSession, USER_ADMIN_LEVEL userLevel) throws Exception{
		UserEntity user = (UserEntity) httpSession.getAttribute("user");
		
		if(userLevel.toString().equals(user.getUserLevel())) {
			return user;
		}
		
		throw new Exception("Usuário nsão existe");
	}
	
	public void login(HttpSession session, UserEntity userEntity) throws Exception {
		UserEntity user = userTestCredencial(userEntity);
		
		if(userEntity.getUserName().equals(user.getUserName()) && userEntity.getPassword().equals(user.getPassword())) {
			session.setAttribute("user", user);
			session.setAttribute("userNavbar", "userNavbar/" + user.getUserLevel());
			session.setAttribute("adminLevel", user.getUserLevel());
		}else {
			throw new Exception("User not found");
		}
	}
	
	public void deslogar(HttpSession httpSession) {
		httpSession.invalidate();
	}
	
	
	
}
