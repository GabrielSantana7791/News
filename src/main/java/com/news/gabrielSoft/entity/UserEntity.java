package com.news.gabrielSoft.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String password;
	//add onetomany
	// gambiarra USER_ADMIN_LEVEL
	private String userLevel;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="user_id")
	private List<CommentEntity> commentEntity;
	
	
	public List<CommentEntity> getCommentEntity() {
		return commentEntity;
	}
	public void setCommentEntity(List<CommentEntity> commentEntity) {
		this.commentEntity = commentEntity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public void setUserNameAndPasswordAndUserLevel(String userName, String password, String userLevel) {
		this.userName = userName;
		this.password = password;
		this.userLevel = userLevel;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", userLevel=" + userLevel
				+ "]";
	}
	
	
	
}
