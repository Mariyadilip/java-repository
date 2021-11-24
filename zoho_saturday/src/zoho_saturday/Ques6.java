package zoho_saturday;

import java.util.Scanner;

public class Ques6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n : ");
		Integer n = sc.nextInt();
		String hexadecimal = "";
		
		while(n > 16) {			
			hexadecimal =  hexCode((n % 16)) + hexadecimal;
			n /= 16;
		}
		
		hexadecimal = hexCode(n) + hexadecimal;
		
		System.out.println("hexa : "+hexadecimal);
	}
	
	private static String hexCode(Integer n) {

		if (n < 10)
			return n.toString();
		else if (n == 10)
			return "A";
		else if (n == 11)
			return "B";
		else if (n == 12)
			return "C";
		else if (n == 13)
			return "D";
		else if (n == 14)
			return "E";
		else if (n == 15)
			return "F";
		return "";
	}
}
