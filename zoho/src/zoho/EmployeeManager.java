package zoho;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeManager {

	/*
	 * Mukund,Sriram Sebastian,Sriram Aashritha,Sriram Mohammad Rafi,Mukund Anjali
	 * Kumar,Mohammad Rafi Joseph,Sebastian Ramachandran,Aashritha Abhinaya
	 * Shankar,Ramachandran Imran Khan,Ramachandran
	 */

	static Map<String, String> map = new HashMap<>();
	static int noOFEmployee = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Manager name : ");		
		String manager =  sc.nextLine();
				
		map.put("Mukund", "Sriram");
		map.put("Sebastian", "Sriram");
		map.put("Aashritha", "Sriram");
		map.put("Mohammad Rafi", "Mukund");
		map.put("Anjali Kumar", "Mohammad Rafi");
		map.put("Joseph", "Sebastian");
		map.put("Ramachandran", "Aashritha");
		map.put("Abhinaya Shankar", "Ramachandran");
		map.put("Imran Khan", "Ramachandran");

		findEmployee(manager);
		System.out.println("\nTotal Employee under " + manager + "  is : " + noOFEmployee);
	}

	static private void findEmployee(String manager) {

		for (Map.Entry<String, String> employee : map.entrySet()) {

			if (employee.getValue().equalsIgnoreCase(manager)) {
				++noOFEmployee;
				findEmployee(employee.getKey());
			}
		}
	}
}
