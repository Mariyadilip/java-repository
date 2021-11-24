package zoho_saturday;

import java.util.Scanner;

public class Ques7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter size of array : ");
		int n = sc.nextInt();
		
		if(n < 3) {
			System.out.println("\nFalse ");
			return;
		}
		
		int[] array = new int[n];
		
		System.out.print("\nEnter array elements : ");
		for(int i=0 ; i<n ; i++)
		array[i] = sc.nextInt();
		
		for(int i=1 ; i<n-1 ; i++) {
			
			if(array[i-1] > array[i] || array[i+1] < array[i]) {
				System.out.println("\nFalse ");
				return ;
			}
				
		}
		
		System.out.println("\nTrue ");
	}
}
