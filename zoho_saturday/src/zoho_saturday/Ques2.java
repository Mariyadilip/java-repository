package zoho_saturday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Ques2 {

static 	boolean relation = false;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		 
		HashMap<String, List<String>> relations = new HashMap<String, List<String>>();
		int facts = 0;
		
		while(true) {
			
		      System.out.println(" Fact "+(++facts));
		      System.out.print("Father name  : ");
		      String father = sc.next().toLowerCase();
		      System.out.print("\nson name   : ");
		      String son = sc.next().toLowerCase();		      
              
		      if(relations.get(father) == null) 
		    	  relations.put(father, new ArrayList<String>());
		      
		      relations.get(father).add(son);
		      
		      System.out.print("Do you want to continue (y/n) ? : ");
		      String choice = sc.next();
		      
		      if(!choice.equalsIgnoreCase("y"))
		    	  break;
		}
		
		System.out.print("\n\nconclusion\n\n");
		System.out.print("Enter person 1 name : ");
		String p1 = sc.next().toLowerCase();
		System.out.print("\nEnter person 2 name : ");
		String p2 = sc.next().toLowerCase();		    
  
		findRelation(relations, p1, p2);
		
		if(relation)
			System.out.println("True ");
		else
			System.out.println("False ");
	}
	
	
	public static void findRelation(HashMap<String, List<String>> relations, String p1, String p2) {
		
		List<String> sons = null;
		
		if(relations.get(p1) != null)
		 sons = relations.get(p1);
		
		if( (relations.get(p1) != null) && (!sons.isEmpty()) )
		for(String son : sons) {
			
			if(son.equals(p2)) {
				relation = true;
				return;
			}
			
			findRelation(relations, son, p2);
		}
	}
}

//c   d 

//c   e

//a   b

//b   c

//con  - a d
