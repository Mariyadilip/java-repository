package com.main;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.beans.Question;
import com.beans.User;

public class Service {

	static int count;
	static Scanner sc = new Scanner(System.in);
	
	public void homepage(List<Question> questions, User user) {
		System.out.println("\n\n-----------------Homepage------------------");
		
		while(true) {
		System.out.print("\n1. All Questions ");
		System.out.print("\n2. MY Questions ");
		System.out.print("\n3. tags display ");
		System.out.print("\n4. my profile ");
		System.out.print("\n5. Post a Question ");
		System.out.print("\n6. Exit \n");
		
		System.out.print("\nEnter your choice : ");
		String ch = sc.nextLine();
		
		if(ch.equals("1")) 
			displayQuestions(questions);
		else if(ch.equals("5"))
			postQuestion(questions, user);
		else if(ch.equals("6"))
			break;
		}
	}
	
	public void postQuestion(List<Question> questions, User user) {
		System.out.println("\n-------------------post a question-------------------\n");
		System.out.print("\nEnter the title : ");
		String title = sc.nextLine();
		System.out.print("\nEnter description : ");
		String desc = sc.nextLine();
		System.out.print("\nEnter question : ");
		String question = sc.nextLine();
		System.out.print("\nEnter tags separated by space : ");
		String tag = sc.nextLine();
		String[] tags = tag.split(" ");
		
		Question q = new Question();
		q.setAuthor(user.getUsername());
		q.setTitle(title);
		q.setDescription(desc);
		q.setPostedOn(LocalDateTime.now());
		q.setTags(tags);
		q.setQuestion(question);
		q.setQuestionNumber(++count);
		
		questions.add(q);
		System.out.println("\nQuestion posted successfully :-) \n");
	}
	
	public void displayQuestions(List<Question> questions) {
		
		if(questions.isEmpty()) {
			System.out.println("\nNo Questions !!");
			return;
		}
		
		System.out.println("\n------------------Questions ? ------------------\n");
		for(Question q : questions) {
			System.out.println();
			System.out.println(" "+q.getQuestionNumber());
			System.out.println("Author : '"+q.getAuthor()+"'");
			System.out.println("Title : '"+q.getTitle()+"'");
			System.out.println("Posted ON : "+q.getPostedOn());
			System.out.println("Description : '"+q.getDescription()+"'");
			System.out.println("Question : "+q.getQuestion());
			System.out.println("Tags : "+q.getTags());
			System.out.println("Upvote : "+q.getUpvotes());
			System.out.println("downvote : "+q.getDownvotes());
			System.out.println("Answers : ");
			
			System.out.print("comments : ");
			if(q.getComments().isEmpty())
				System.out.print(" No Comments !");
			else {
				for(Map.Entry<String, User> comment : q.getComments().entrySet()) {
					System.out.println("user - "+comment.getValue().getUsername());
					System.out.println("       comment : "+comment.getKey().substring(1)+"\n");
				}
			}
		}
		
		System.out.println("1.) pick the question");
		System.out.println("2.) go back ");
		System.out.print("\n3.) Enter your choice : ");
		String ch = sc.nextLine();
		if(ch.equals("1")) {
			System.out.print("\n\nEnter question number : ");
			ch = sc.nextLine();
			Question q = pickQuestion(questions, ch);
			if(q == null) 
				System.out.println("\nInvalid ");
			else {
				System.out.println("\nQuestion title : "+q.getTitle());
				System.out.println("1. Post answer ");
				System.out.println("2. post comment ");
				System.out.println("3. upvote");
				System.out.println("4. downvote");
				System.out.print("\nEnter your choice : ");
				ch = sc.nextLine();
			}
		}
	}
	
	public Question pickQuestion(List<Question> questions, String number) {
		if(questions.isEmpty())
			return null;
		for(Question q : questions)
			if(q.getQuestionNumber().toString().equals(number))
				return q;
		return null;
	}
}
