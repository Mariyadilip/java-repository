package com.zoho;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
   
	public static void main(String[] args) {

	    Service service = new Service();
	    
		Employee sriram = new Employee(1, "sriram", 45, "management", "ceo", null);
		Employee mukund = new Employee(2, "mukund", 43, "hr", "hr manager", "sriram");
		Employee sebastian = new Employee(3, "sebastian", 38, "finance", "finance manager", "sriram");
		Employee aashritha = new Employee(4, "aashritha", 32, "product management", "dev manager", "sriram");
		Employee mohammadRafi = new Employee(5, "mohammad rafi", 35, "hr", "hr lead", "mukund");
		Employee anjaliKumar = new Employee(6, "anjali kumar", 29, "hr", "hr associate", "mohammad rafi");
		Employee joseph = new Employee(7, "joseph", 40, "finance", "finance associate", "sebastian");
		Employee ramachandran = new Employee(8, "ramachandran", 27, "product development", "tech lead", "aashritha");
		Employee abhinayaShankar = new Employee(9, "abhinaya shankar", 23, "product development", "system developer", "ramachandran");
		Employee imranKhan = new Employee(10, "imran khan", 28, "product testing", "qa lead", "ramachandran");
		Employee dilip = new Employee(11, "imran khan", 28, "product testing", "qa lead", "ramachandran");
		Employee kumar = new Employee(12, "imran khan", 28, "product testing", "qa lead", "ramachandran");
		Employee ram = new Employee(13, "imran khan", 28, "product testing", "hr lead", "ramachandran");
		
		List<Employee> employees = new ArrayList<>();
		
		employees.add(sriram);
		employees.add(mukund);
		employees.add(sebastian);
		employees.add(aashritha);
		employees.add(mohammadRafi);
		employees.add(anjaliKumar);
		employees.add(joseph);
		employees.add(ramachandran);
		employees.add(abhinayaShankar);
		employees.add(imranKhan);
		employees.add(dilip);
		employees.add(kumar);
		employees.add(ram);
		
		
		while(true) {
			System.out.println("\n--------------------------------INITIAL MENU---------------------------------");
			System.out.println("1.)show all records ");
			System.out.println("2.)search records");
			System.out.println("3.)Manager report");
			System.out.println("4.)Reporting Tree");
			System.out.println("5.)summary of record");
			System.out.println("6.)Exit");
			System.out.println("------------------------------------------------------------------------------------\n");
			System.out.print("\nEnter your choice : ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				service.showAllRecords(employees);
				break;
			case 2:
				service.searchRecords(employees);
				break;
			case 3:
				service.listEmployeeUnderManager(employees);
				break;
			case 4:
				service.reportingTree(employees);
				break;
			case 5:
				service.summaryReports(employees);
				break;
			case 6:
				System.exit(2);
			default:
				System.out.println("Invalid Choice!!!!!!!!!!!!!!!");
			}
		}
	}

}
