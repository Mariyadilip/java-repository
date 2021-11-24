package zoho_saturday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ques4 {

	static boolean isRelation = false;
	static List<String> names = new ArrayList<>();
    
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter person 1 name : ");
		String person1 = sc.nextLine().toLowerCase();
		System.out.print("\nEnter person 2 name : ");
		String person2 = sc.nextLine().toLowerCase();
		
		Map<String, Person> persons = new HashMap<>();
		
		Person arun = new Person("arun");
		Person varun = new Person("varun");
		Person suresh = new Person("suresh");
		Person vijay  = new Person("vijay");
	    Person hari = new Person("hari");
	    Person surya = new Person("surya");
	    Person siva = new Person("siva");
	    Person bala = new Person("bala");
	    Person barath = new Person("barath");
	    Person ajay = new Person("ajay");
	    Person vignesh = new Person("vignesh");
	    Person sai = new Person("sai");
	    Person sharan = new Person("sharan");
      	   
	   persons.put("arun", arun);
	   persons.put("varun", varun);
	   persons.put("suresh", suresh);
	   persons.put("vijay", vijay);
	   persons.put("hari", hari);
	   persons.put("surya", surya);
	   persons.put("siva", siva);
	   persons.put("bala", barath);
	   persons.put("barath", barath);
	   persons.put("ajay", ajay);
	   persons.put("vignesh", vignesh);
	   persons.put("sai", sai);
	   persons.put("sharan", sharan);
	   
	   
	   arun.friend(varun);
	   arun.friend(suresh);
	   arun.friend(vijay);
	  
	   varun.friend(hari);
	   varun.friend(surya);
	   
	   hari.friend(siva);
	   
	   suresh.friend(bala);
	   suresh.friend(barath);
	   
	   vijay.friend(sai);
	   vijay.friend(vignesh);
	   vijay.friend(ajay);
	   
	   ajay.friend(sharan);
		   
	   if(!persons.containsKey(person1) || !persons.containsKey(person2)) {
			System.out.println("\nNo relation between '"+person1+"' and '"+person2+"'");
		sc.close();
		return;
	   }
   ;
	   Person p1 = persons.get(person1);
	   Person p2 = persons.get(person2);
	   
	   System.out.println(p1.getPersons());
//	   names.add(p1.getName());
//	   findRelation(p1, p2.getName(), names, 0);  
//	   
//	   if(!isRelation)
//		System.out.println("\nNo relation between '"+p1.getName()+"' and '"+p2.getName()+"'");
	   
	   sc.close();
	}
	
	
	public static void findRelation(Person person, String name, List<String> names, int size) {
		
		for(Person p : person.getPersons()) {
			if(p.getName().equals(name)) {
				isRelation = true;
				names.add(p.getName());
			   System.out.println("\n\nRelation -> "+names);
				return ;
			}			 
			 names.add(p.getName());
			 findRelation(p, name, names, size+1);
		}	
				
		if(!isRelation)
		  names.remove(person.getName());

	}

}

class Person{
	
	private String name;
    private LinkedList<Person> persons;
    
    Person(String name){
    	this.name = name;
    	persons = new LinkedList<Person>();
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<Person> getPersons() {
		return persons;
	}

	public void setPersons(Person person) {
		this.persons.add(person);
	}

	public void friend(Person person) {
		persons.add(person);
	}
	
	public String toString() {
		return name;
	}
}
