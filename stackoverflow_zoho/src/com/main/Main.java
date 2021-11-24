package com.main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.beans.Question;
import com.beans.User;

public class Main {

	static HashMap<String, User>  users = new HashMap<>();
	static List<Question> questions = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
    static Service service = new Service();
    
	public static void main(String[] args) {
		
		
		while(true) {
			System.out.println("\n-------------Stack Overflow------------");
			System.out.println("1. Admin ");
			System.out.println("2. User ");
			System.out.println("3. Exit");
			
			System.out.print("\n\nEnter your choice : ");
			String ch = sc.nextLine ();
			
			switch(ch) {
			case "1" : break;
			case "2" : user(); break;
			case "3" : System.exit(2);
			default : 
				System.out.println("\nInvalid choice !! \n");
			}
		}
	}
	
	public static void user() {
		System.out.println("1.) Login ");
		System.out.println("2.) signup ");
		
		System.out.print("\nEnter your choice : ");
		String ch = sc.nextLine();
		
		if(ch.equals("1")) {
			
			System.out.print("\nEnter your mail id : ");
			String email = sc.nextLine();
			System.out.print("\nEnter your password : ");
			String password = sc.nextLine();
			
			if(users.get(email) == null || !users.get(email).getPassword().equals(password)) {
				System.out.println("\nInvalid username or password");
				return;
			}		
			
			service.homepage(questions, users.get(email));
		}
		else if(ch.equals("2")) {
			System.out.print("\n\n------signup-------\n\n");
			System.out.print("\nEnter username : ");
			String username = sc.nextLine().toLowerCase();
			System.out.print("\nEnter email : ");
			String email = sc.nextLine().toLowerCase();
			System.out.print("\nEnter password ");
			String password = sc.nextLine();
			
			if(users.get(email) != null) {
				System.out.println("\nEmail exists already !!\n\n");
				return;
			}
			
			User newuser = new User(username, email, password, LocalDateTime.now());
			users.put(email, newuser);
			service.homepage(questions, newuser);
		}
		else
			System.out.println("\nInvalid choice !! \n");
			
	}
}
