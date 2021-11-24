package com.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question {

	private Integer questionNumber;
	private String title;
	private String description;	
	private String question;
	private String author;
	private List<HashMap<User, Answer>> answers;
	private List<HashMap<User, Comment>> comments;
	private List<String> tags;
	private int upvotes;
	private int downvotes;
	private LocalDateTime postedOn;
	
	//hello+1
	//hello+2
	
	public Question(){
		answers = new ArrayList<>();
		comments = new ArrayList<>();
		tags = new ArrayList<>();
	}
	
	
	public List<HashMap<User, Comment>> getComments() {
		return comments;
	}
	
	public void setAnswers(User user, Answer answer) {
		
		if(answers.isEmpty())
			answers.get(0) = new HashMap<>();
		
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public  List<HashMap<User, Answer>> getAnswers() {
		return answers;
	}

	public List<String> getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		for(String tag : tags)
		this.tags.add(tag);
	}
	public int getUpvotes() {
		return upvotes;
	}
	public void setUpvotes(int upvote) {
		this.upvotes = this.upvotes + upvote;
	}
	public int getDownvotes() {
		return downvotes;
	}
	public void setDownvotes(int downvote) {
		this.downvotes = this.downvotes + downvote;
	}
	public LocalDateTime getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(LocalDateTime postedOn) {
		this.postedOn = postedOn;
	}	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}
}
