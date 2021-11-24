package com.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {

	private String username;
	private String email;
	private String password;
	private LocalDateTime createdOn;
	private List<Question> myQuestions;
	
	public User(String username, String email, String password, LocalDateTime createdOn) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.createdOn = createdOn;
		this.myQuestions = new ArrayList<>();
	}
	
	public void setQuestion(Question question) {
		this.myQuestions.add(question);
	}
	
	public List<Question> getQuestions(){
		return myQuestions;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
}
