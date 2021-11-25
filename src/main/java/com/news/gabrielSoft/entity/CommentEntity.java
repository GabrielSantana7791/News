package com.news.gabrielSoft.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class CommentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	UserEntity user;
	
	@ManyToOne
	@JoinColumn(name="postIndex_id")
	PostIndexEntity postIndex;
	
	String text;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public PostIndexEntity getPostIndex() {
		return postIndex;
	}

	public void setPostIndex(PostIndexEntity postIndex) {
		this.postIndex = postIndex;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "CommentEntity [id=" + id + ", user=" + user + ", postIndex=" + postIndex + ", text=" + text + "]";
	}
	
	
	
}
