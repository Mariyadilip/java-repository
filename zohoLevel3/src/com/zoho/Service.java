package com.zoho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Service {

	static Scanner sc = new Scanner(System.in);
	public void showAllRecords(List<Employee> employees) {
		
		System.out.println("\n\n-------------------------ALL Records-----------------------------\n");
		System.out.println("ID  |        Name        |   Age   |      Department    |      Designation     |     Reporting To      |");
		System.out.println("--------------------------------------------------------------------------------------------------------");
		for(Employee emp : employees) {
			System.out.print("  "+emp.getId()+"  ");
			System.out.print("     "+emp.getName()+"");
            String name = emp.getName();
			if(emp.getName().length() <= 8)
		    for(int i=1 ; i<= 10 ; i++)
		    	System.out.print(" ");
			
			else if(name.length() > 8 && name.length() <= 10)
				for(int i=1 ; i<= 6 ; i++)
					System.out.print(" ");
			
			else if(name.length() > 10 && name.length() <= 15)
				for(int i=1 ; i<= 3 ; i++)
					System.out.print(" ");
			
		    System.out.print("    "+emp.getAge()+"      ");		 
				
		    
		    String department = emp.getDepartment();
		    System.out.print(department+"");
		    if(department.length() <= 7)
			    for(int i=1 ; i<= 26 ; i++)
			    	System.out.print(" ");
		
				
				else if(department.length() > 7 )
					for(int i=1 ; i<= 15 ; i++)
						System.out.print(" ");
		     

		    String designation = emp.getDesignation();
		    System.out.print(designation+"");
		    if(designation.length() <= 7)
			    for(int i=1 ; i<= 26 ; i++)
			    	System.out.print(" ");
		
				
				else if(designation.length() > 7 )
					for(int i=1 ; i<= 15 ; i++)
						System.out.print(" ");
		     
		    System.out.print("  "+emp.getReportingTo());
		    System.out.println();
		}
	}
	
	public void searchRecords(List<Employee> employees) {
		
		System.out.println("\n\n------------------------------SEARCH RECORDS-------------------------------");
		
		while(true) {
			
			int choice = searchOptions();
			if(choice == 1 || choice == 3)
				employees = searchInteger(choice, employees);
			else
				employees = searchString(choice, employees);
			
			System.out.println("\n1.) AND ");
			System.out.println("\n2.) Search ");
			
			System.out.print("\n Enter choice : ");
			choice = sc.nextInt();
			
			
			while(choice != 1 && choice != 2) {
				System.out.print("\nEnter valid choice : ");
				choice = sc.nextInt();
			}
			
			if(choice == 2)
				break;
		}
		
		if(employees.isEmpty())
			System.out.println("\n \n No records Found !");
		else
			showAllRecords(employees);
	}
	
	public List<Employee> searchInteger(int choice, List<Employee> employees){
		
		List<Employee> emps = new ArrayList<Employee>();
		
		System.out.println("\n\n1. >\n2. <\n3. = \n4. != \n5. range (> <)");
		System.out.print("\n Enter criteria to search : ");
		int c = sc.nextInt();
		while(c < 1 && c > 5)
		{
			System.out.print("\nEnter valid choice : ");
			c = sc.nextInt();
		}
		
		int element = 0, min=0, max=0;
		if(c != 5) {
		System.out.print("\nEnter value : ");
		 element = sc.nextInt();
		}
		else
		{
			System.out.print("\nEnter min range : ");
			min = sc.nextInt();
			System.out.print("\nEnter max range : ");
			max = sc.nextInt();
		}
		 //       >
		if(c == 1 && choice == 1)
			for(Employee emp : employees) {
				if(emp.getId() > element)
				  emps.add(emp); }
		else if(c == 1 && choice == 3)
			for(Employee emp : employees) {
				if(emp.getAge() > element)
				  emps.add(emp); }
		
		//       <
		else if(c == 2 && choice == 1)
			for(Employee emp : employees) {
				if(emp.getId() < element)
				  emps.add(emp); }
		else if(c == 2 && choice == 3)
			for(Employee emp : employees) {
				if(emp.getAge() < element)
				  emps.add(emp); }
				
 //      =
		else if(c == 3 && choice == 1)
			for(Employee emp : employees) {
				if(emp.getId() == element)
				  emps.add(emp); }
		else if(c == 3 && choice == 3)
			for(Employee emp : employees) {
				if(emp.getAge() == element)
				  emps.add(emp); }
		
//      !=
		else if(c == 4 && choice == 1)
			for(Employee emp : employees) {
				if(emp.getId() != element)
				  emps.add(emp); }
		else if(c == 4 && choice == 3)
			for(Employee emp : employees) {
				if(emp.getAge() != element)
				  emps.add(emp); }
		
		
	// range (> <)
		else if(c == 5 && choice == 1)
			for(Employee emp : employees) {
				if(emp.getId() >= min && emp.getId() <= max)
				  emps.add(emp); }
		else if(c == 5 && choice == 3)
			for(Employee emp : employees) {
				if(emp.getAge() >= min && emp.getAge() <= max)
				  emps.add(emp); }
		
		return emps;
	}
	
	public List<Employee> searchString(int choice, List<Employee> employees){
		
		List<Employee> emps = new ArrayList<Employee>();
		System.out.println("\n\n1. Equals\n2. Not Equals\n3. Starts with\n4. Ends with\n5. Contains\n6. Not contains ");
		System.out.print("\n Enter criteria to search : ");
		int c = sc.nextInt();
		while(c < 1 && c > 5)
		{
			System.out.print("\nEnter valid choice : ");
			c = sc.nextInt();
		}
		
		sc.nextLine();
		System.out.print("\nEnter value : ");
		String element = sc.nextLine();
		
		 //       equals 2.Name 4.department 5.designation 6.reporting to 
		if(c == 1 && choice == 2)
			for(Employee emp : employees) {
				if(emp.getName().equalsIgnoreCase(element))
				  emps.add(emp); }
		else if(c == 1 && choice == 4)
			for(Employee emp : employees) {
				if(emp.getDepartment().equalsIgnoreCase(element))
				  emps.add(emp); }
		else if(c == 1 && choice == 5)
			for(Employee emp : employees) {
				if(emp.getDesignation().equalsIgnoreCase(element))
					emps.add(emp); }
		else if(c == 1 && choice == 6)
			for(Employee emp : employees) {
				if(emp.getReportingTo().equalsIgnoreCase(element))
					emps.add(emp); }
		
	  //Not Equals
		else if(c == 2 && choice == 2)
			for(Employee emp : employees) {
				if(!emp.getName().equalsIgnoreCase(element))
				  emps.add(emp); }
		else if(c == 2 && choice == 4)
			for(Employee emp : employees) {
				if(!emp.getDepartment().equalsIgnoreCase(element))
				  emps.add(emp); }
		else if(c == 2 && choice == 5)
			for(Employee emp : employees) {
				if(!emp.getDesignation().equalsIgnoreCase(element))
					emps.add(emp); }
		else if(c == 2 && choice == 6)
			for(Employee emp : employees) {
				if(!emp.getReportingTo().equalsIgnoreCase(element))
					emps.add(emp); }
		
		
		//starts with 
		else if(c == 3 && choice == 2)
			for(Employee emp : employees) {
				if(emp.getName().startsWith(element))
				  emps.add(emp); }
		else if(c == 3 && choice == 4)
			for(Employee emp : employees) {
				if(emp.getDepartment().startsWith(element))
				  emps.add(emp); }
		else if(c == 3 && choice == 5)
			for(Employee emp : employees) {
				if(emp.getDesignation().startsWith(element))
					emps.add(emp); }
		else if(c == 3 && choice == 6)
			for(Employee emp : employees) {
				if(emp.getReportingTo().startsWith(element))
					emps.add(emp); }
		
		//ends with
		else if(c == 4 && choice == 2)
			for(Employee emp : employees) {
				if(emp.getName().endsWith(element))
				  emps.add(emp); }
		else if(c == 4 && choice == 4)
			for(Employee emp : employees) {
				if(emp.getDepartment().endsWith(element))
				  emps.add(emp); }
		else if(c == 4 && choice == 5)
			for(Employee emp : employees) {
				if(emp.getDesignation().endsWith(element))
					emps.add(emp); }
		else if(c == 4 && choice == 6)
			for(Employee emp : employees) {
				if(emp.getReportingTo().endsWith(element))
					emps.add(emp); }
		
		
		//contains
		else if(c == 5 && choice == 2)
			for(Employee emp : employees) {
				if(emp.getName().contains(element))
				  emps.add(emp); }
		else if(c == 5 && choice == 4)
			for(Employee emp : employees) {
				if(emp.getDepartment().contains(element))
				  emps.add(emp); }
		else if(c == 5 && choice == 5)
			for(Employee emp : employees) {
				if(emp.getDesignation().contains(element))
					emps.add(emp); }
		else if(c == 5 && choice == 6)
			for(Employee emp : employees) {
				if(emp.getReportingTo().contains(element))
					emps.add(emp); }
		
		
		//Not contains
				else if(c == 6 && choice == 2)
					for(Employee emp : employees) {
						if(!emp.getName().contains(element))
						  emps.add(emp); }
				else if(c == 6 && choice == 4)
					for(Employee emp : employees) {
						if(!emp.getDepartment().contains(element))
						  emps.add(emp); }
				else if(c == 6 && choice == 5)
					for(Employee emp : employees) {
						if(!emp.getDesignation().contains(element))
							emps.add(emp); }
				else if(c == 6 && choice == 6)
					for(Employee emp : employees) {
						if(!emp.getReportingTo().contains(element))
							emps.add(emp); }
		
		
		return emps;
	}
	
	public int searchOptions() {
		
		System.out.println("\n\n1.)Id ");
		System.out.println("2.)Name ");
		System.out.println("3.)Age ");
		System.out.println("4.)Department ");
		System.out.println("5.)Designation ");
		System.out.println("6.)Reporting to ");
		
		System.out.print("\n Enter field no to search  : ");
		int choice = sc.nextInt();
		while(choice < 1 && choice > 6)
		{
			System.out.print("\nEnter valid choice : ");
			choice = sc.nextInt();
		}
		
		return choice;
	}
	
	public void listEmployeeUnderManager(List<Employee> employees) {
		
		List<Employee> emps = new ArrayList<Employee>();
		
		System.out.println("\n-----------------------------Employees under Manager-------------------------------");
		System.out.print("\nEnter manager name : ");
		String manager = sc.nextLine();
		
		for(Employee employee : employees)
			if(employee.getReportingTo() != null && employee.getReportingTo().equalsIgnoreCase(manager))
				emps.add(employee);
		
		if(emps.isEmpty())
			System.out.println("\nNo employee's under "+manager);
		else
			showAllRecords(emps);
		
	}
	
	public void reportingTree(List<Employee> employees) {
		
		System.out.println("\n-----------------------------Reporting Tree---------------------------\n");
		System.out.print("\nEnter name : ");
		String name = sc.nextLine();
		String res = name;
		
		for(Employee e : employees) 
			if(e.getName().equalsIgnoreCase(name)) 
				res = tree(employees,  e.getReportingTo(), res);
		
		System.out.println("\n\n"+res+"\n\n");
	}
	
	public String tree(List<Employee> employees,  String name, String res) {
		
		for(Employee e : employees) 
			if(e.getName().equalsIgnoreCase(name)) 
				return tree(employees,  e.getReportingTo(), res + " -> " + e.getName());
		return res;
	}
	
	public void summaryReports(List<Employee> employees) {
		
		
		System.out.println("\n------------------------------------Summary---------------------------------------");
		System.out.println("1. Show all departments summary");
		System.out.println("2. Show all Designation Summary");
		System.out.println("3. Show all Managers Summary");
		
		System.out.print("\n\n  Enter choice : ");
		int ch = sc.nextInt();
		
		while(ch < 1 && ch > 3) {
			System.out.print("\nEnter valid choice : ");
			ch = sc.nextInt();
		}
		
		if(ch == 1) {
			HashMap<String, Integer> department = new HashMap<>();
			for(Employee e : employees)
				if(department.get(e.getDepartment()) != null)
				department.put(e.getDepartment(), department.get(e.getDepartment()) + 1);
				else
				department.put(e.getDepartment(), 1);
			
			System.out.println("\nDepartment               |        count");
			System.out.println("----------------------------------------------\n");
			for(Map.Entry<String, Integer> map : department.entrySet()) {
				String key = map.getKey();
				System.out.print(" "+key);
				
				if(key.length() < 5) {
					for(int i=1 ; i<= 30 ; i++)
						System.out.print(" ");
					System.out.print(" "+map.getValue());
				}
				else if(key.length() >= 12) {
					for(int i=1  ; i<= 14 ; i++)
						System.out.print(" ");
					System.out.print(" "+map.getValue());
				}
				else
				{
					for(int i=1 ; i<=22  ;i++)
						System.out.print(" ");
					System.out.print(" "+map.getValue());
				}
				System.out.println();
			}
				
				
		}
		else if(ch == 2) {
			HashMap<String, Integer> designation = new HashMap<>();
			for(Employee e : employees)
				if(designation.get(e.getDesignation()) != null)
					designation.put(e.getDesignation(), designation.get(e.getDesignation()) + 1);
				else
					designation.put(e.getDesignation(), 1);
			
			System.out.println("\nDesignation     |              count");
			System.out.println("------------------------------------\n");
			for(Map.Entry<String, Integer> map : designation.entrySet()) {
				String key = map.getKey();
			System.out.print(" "+key);
			
			if(key.length() < 5) {
				for(int i=1 ; i<= 30 ; i++)
					System.out.print(" ");
				System.out.print(" "+map.getValue());
			}
			else if(key.length() >= 12) {
				for(int i=1  ; i<= 14 ; i++)
					System.out.print(" ");
				System.out.print(" "+map.getValue());
			}
			else
			{
				for(int i=1 ; i<=22  ;i++)
					System.out.print(" ");
				System.out.print(" "+map.getValue());
			}
			System.out.println();
			}
		}
		
		else if(ch == 3) {
			HashMap<String, Integer> manager = new HashMap<>();
			
			for(Employee e : employees) 
				if(manager.get(e.getReportingTo()) != null)
					manager.put(e.getReportingTo(), manager.get(e.getReportingTo()) + 1);
				else
					manager.put(e.getReportingTo(), 1);
			
			System.out.println("\nManager     |     count");
			System.out.println("----------------------------\n");
			for(Map.Entry<String, Integer> map : manager.entrySet()) {
				String key = map.getKey();
				
			if(key != null) {
			System.out.print(" "+key);
			
			if(key.length() < 5) {
				for(int i=1 ; i<= 15 ; i++)
					System.out.print(" ");
				System.out.print(" "+map.getValue());
			}
			else if(key.length() >= 12) {
				for(int i=1  ; i<= 8 ; i++)
					System.out.print(" ");
				System.out.print(" "+map.getValue());
			}
			else
			{
				for(int i=1 ; i<=10  ;i++)
					System.out.print(" ");
				System.out.print(" "+map.getValue());
			}
			System.out.println();
			}
		}}
	}
}
