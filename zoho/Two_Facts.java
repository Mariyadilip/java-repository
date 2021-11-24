package task.zoho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Two_Facts {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter fact 1 : ");
		String fact1 = sc.nextLine();
		System.out.print("\nEnter fact 2 : ");
		String fact2 = sc.nextLine();
		System.out.print("\nEnter conclusion : ");
		String conclusion = sc.nextLine();
		
		Map<String, List<String>> facts = new HashMap<>();
		processFact(facts, fact1);
		processFact(facts, fact2);
		
		
		conclusion = conclusion.toLowerCase();
		
		if(conclusion.contains("grandfather"))
			System.out.println(isGrandFather(conclusion, facts);
		sc.close();
	}
	
	private static void processFact(Map<String, List<String>> facts, String fact){
		
		List<String> list = new ArrayList<>();
		
		fact = fact.toLowerCase();
		list.add(fact.charAt(fact.length()-1)+"");
		
		if(fact.contains("father")) {
		list.add("father");
		facts.put(fact.charAt(0)+"", list);
		}
		
	}
	
	private static boolean isGrandFather(String conclusion, Map<String, List<String>> facts) {
		
		String first = conclusion.charAt(0)+"";
		String last = conclusion.charAt(conclusion.length()-1)+"";
		
		if(facts.get(first) == null || facts.get(last) == null)
			return false;
		else if(facts.get(first).get(1).equals("father") && facts.get(facts.get(first).get(0)) ) {
			
		}
	}
}
