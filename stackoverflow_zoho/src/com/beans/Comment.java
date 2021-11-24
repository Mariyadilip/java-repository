package com.beans;

import java.util.ArrayList;
import java.util.List;

public class Comment {

	private int upvote;
	private int downvote;
	private String comment;
	private User user;
	private List<Comment> comments;
	
	public Comment() { this.comments = new ArrayList<>();}
	public Comment(String comment) { this.setComment(comment); this.comments = new ArrayList<>();}
	
	public int getUpvote() {
		return upvote;
	}
	public void setUpvote(int upvote) {
		this.upvote = this.upvote + upvote;
	}
	public int getDownvote() {
		return downvote;
	}
	public void setDownvote(int downvote) {
		this.downvote =  this.downvote + downvote;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(Comment comment) {
		this.comments.add(comment);
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
