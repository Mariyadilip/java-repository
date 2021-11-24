package zoho_saturday;

import java.util.Random;
import java.util.Scanner;

public class Ques3 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.print("\nEnter no of servers : ");
		int servers = sc.nextInt();
		
		char[] status = new char[servers];
		
		for(int i=0 ; i<servers ; i++)
			status[i] = 'R';
		
		while(true) {
			
			System.out.println("\n\npress 'S' to show server status ");
			System.out.println("press 'D' to shutdown server at random ");
			System.out.println("press 'U' to start backup ");
			System.out.println("press 'E' to Exit");
			System.out.print("\n\nEnter your choice : ");
			String choice = sc.next().toLowerCase();
			switch(choice) {
			case "s" : 
				System.out.println("\n--------------------Server status----------------------- \n\n");
				showStatus(status, servers);
				break;
			case "d" :
				shutdown(status, servers);
				break;
			case "u" :
				backUp(status, servers);
				break;
			case "e":
				System.exit(2);
			default:
				System.out.println("Invalid choice !!");
			}
		}
		
	}
	
	private static void shutdown(char[] status, int servers) {
		
		System.out.println("\n--------------------Shutdown servers----------------------- \n\n");
		int[] index = new int[servers];
		int size = 0;
		
		for(int i=0 ;i<servers ; i++) 
		   if(status[i] != 'D')	
			   index[size++] = i;
		
		if(size < 3) {
			showStatus(status, servers);
			return;
		}
		
		size = size - 2;
		
		int random = random(size+1), i = 1;
		random = random == 0 ? 1 : random;
		
		
		while(i <= random) {
			
			int j = random(size);
			if(j < size && index[j] != -1) {
				i++;
			 status[index[j]] = 'D';
			 index[j] = -1;
			}
			
		}
		
		showStatus(status, servers);
	}
	
	private static int random(int servers) {		
		    Random r = new Random();		    
		   return r.nextInt(servers);
	}
	
	private static void showStatus(char[] status, int servers) {
				
		
		System.out.println("\n 'D' -> server SHUTDOWN");
		System.out.println(" 'B' -> server BACKUP");
		System.out.println(" 'R' -> server Running\n");
		
		System.out.println("------------------------------------------------------\n\n");
		for(int i=0 ; i<servers; i++)
			System.out.print(status[i]+" ");
	}
	
	private static void backUp(char[] status, int servers) {
		
		System.out.println("\n--------------------BackUP servers----------------------- \n\n");

		for(int i=0 ; i<servers ; i++)
		status[i] = 'B';
		
		showStatus(status, servers);
	}
}
