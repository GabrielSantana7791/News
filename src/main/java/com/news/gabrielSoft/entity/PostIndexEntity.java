package com.news.gabrielSoft.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class PostIndexEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="comment_id")
	private List<CommentEntity> commentsEntity;
	
	@Column(length = 3000)
	private String text;
	private String title;
	private Date date; //alterar	
	
	public String dateString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		return sdf.format(date);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {		
	this.date = date;
	}

	public List<CommentEntity> getComments() {
		return commentsEntity;
	}

	public void AddNewComment(CommentEntity comment) {
		commentsEntity.add(comment);	}

	public void setComments(List<CommentEntity> comments) {
		this.commentsEntity = comments;
	}

	@Override
	public String toString() {
		return "PostIndexEntity [id=" + id + ", comments=" + commentsEntity + ", text=" + text + ", title=" + title
				+ ", date=" + date + "]";
	}
	
	public void deleteComment() {
		commentsEntity = null;
	}

}
