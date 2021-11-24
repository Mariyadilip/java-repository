package zoho.lvl2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("N : ");
		int n = Integer.parseInt(sc.readLine());
		
		for(int i=1 ; i<=n ; i++) {
			
			
			System.out.print("Enter employee name : ");
			String employee = sc.readLine();
			
			System.out.print("Enter reporting manager of "+employee+"  :  ");
			String manager = sc.readLine();
			
			map.put(employee, manager);
			
			
		}
		
		
		System.out.println("Enter the manager name : ");
		String manager = sc.readLine();
		
//		String manager = "Sriram";
//
//		
//		map.put("Mukund", "Sriram");
//		map.put("Sebastian", "Sriram");
//		map.put("Aashritha", "Sriram");
//		map.put("Mohammad Rafi", "Mukund");
//		map.put("Anjali Kumar", "Mohammad Rafi");
//		map.put("Joseph", "Sebastian");
//		map.put("Ramachandran", "Aashritha");
//		map.put("Abhinaya Shankar", "Ramachandran");
//		map.put("Imran Khan", "Ramachandran");

		findEmployee(manager);
		System.out.println("Total Employee under " + manager + "  is : " + noOFEmployee);
		
		sc.close();
	}

	static private void findEmployee(String manager) {

		for (Map.Entry<String, String> employee : map.entrySet()) {

			if (employee.getValue().equals(manager)) {
				++noOFEmployee;
				findEmployee(employee.getKey());
			}
		}
	}
}
