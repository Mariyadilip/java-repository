package zoho.lvl2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main{
	
	static Map<String, Employee> map = new HashMap<>();
	static int noOfEmployees;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("N : ");
		int n = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=n ; i++) {
		
			System.out.println();
			System.out.println("--------------------------");
			
			Employee employee = new Employee();
			employee.setEmployeeID(i);
			
			System.out.print("Enter Employee name : ");
			employee.setName(br.readLine());
			
			System.out.print("Employee Desgination : ");
			employee.setDesination(br.readLine());
			
			System.out.print("Employee Team      : ");
			employee.setTeam(br.readLine());
			
			System.out.print("Employee Manager name  : ");
			employee.setManagerName(br.readLine());
			
			map.put(employee.getName(), employee);
			
		}
		
	   System.out.println("\nEnter manager name  : ");
	   String name = br.readLine();
	  
	   findEmployee(name);
	   
	   System.out.println("No of Employee under "+name+"  : "+noOfEmployees);
	}
	
	private static void findEmployee(String manager) {
		
		for(Map.Entry<String, Employee> emp : map.entrySet()) {
			
			Employee employee = emp.getValue();
			
			if(employee.getManagerName().equals(manager)) {
				++noOfEmployees;
				findEmployee(employee.getName());
			}
		}
	}
}


class Employee {

 
	private int employeeID;
	private String name;
	private String desination;
	private String team;
	private String managerName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesination() {
		return desination;
	}
	public void setDesination(String desination) {
		this.desination = desination;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	
	public String toString() {
		
		return "EmpID : "+employeeID+"\nName : "+name+" \n Team : "+team+"\n Designation : "+desination+"\n ManagerName : "+managerName;
	}
}