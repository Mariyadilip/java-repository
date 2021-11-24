package com.beans;

import java.util.ArrayList;
import java.util.List;

public class Answer {

	private int upvote;
	private int downvote;
	private String answer;
	private User user;
	private List<Comment> comments;
	
	public Answer(String answer) {
		this.answer = answer;
		this.comments = new ArrayList<>();
	}
	
	public Answer() { this.comments = new ArrayList<>();}
	
	public void setComment(Comment comment) {
		this.comments.add(comment);
	}
	
	public List<Comment> getComments(){
		return comments;
	}
	
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
		this.downvote = this.downvote + downvote;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
