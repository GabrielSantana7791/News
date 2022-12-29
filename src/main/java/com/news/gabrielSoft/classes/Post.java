package com.news.gabrielSoft.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.gabrielSoft.entity.PostIndexEntity;
import com.news.gabrielSoft.repository.CommentRepository;
import com.news.gabrielSoft.repository.PostIndexRepository;

@Service
public class Post {
	
	@Autowired
	Session session;
	
	@Autowired
	PostIndexRepository postRep;
	
	@Autowired
	CommentRepository commentRep;

	public void deletePost(int postId){	
		PostIndexEntity post = postRep.findById(postId);
		
		postRep.delete(post);		
	}
	
	public PostIndexEntity editPost(int postId, PostIndexEntity postIndex){		
		PostIndexEntity postDB = postRep.findById(postId);

		postDB.setText(postIndex.getText());
		postDB.setDate(postIndex.getDate());
		postDB.setTitle(postIndex.getTitle());
		postDB.setSummary(postIndex.getSummary());
		postDB.setImgURL(postIndex.getImgURL());
		postRep.flush();
		
		return postDB;
	}
	
	public void addPost(PostIndexEntity postIndex) {
		postRep.save(postIndex);
		
	}
	
	public PostIndexEntity postIndex (int postId) {
		PostIndexEntity postIndex = postRep.findById(postId);	
		return postIndex;
	}
	
	
	public PostIndexEntity[] findByTextContaining (String text){
		return postRep.findByTextContaining(text);
	}
	
	public void addViewNumber(int postId) {
		PostIndexEntity postIndex = postRep.findById(postId);
		postIndex.setViewNumber(postIndex.getViewNumber() + 1);
		
		postRep.flush();
		
	}	
}
