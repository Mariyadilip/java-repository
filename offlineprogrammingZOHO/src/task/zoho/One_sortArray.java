package task.zoho;

import java.util.Scanner;

public class One_sortArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of array : ");
		int n = sc.nextInt();
		
		if(n < 1) {
			System.out.println("Invalid size");
			sc.close();
			return;
		}
			
		int[] array = new int[n];
		System.out.print("\nEnter array elements : ");
		
		for(int i=0 ;i<n ; i++)
			array[i] = sc.nextInt();
		
		int negative = 0, max = array[0];
		
		for(int i=0 ; i<n ; i++) {
			if(array[i] < 0)
				negative = Math.min(negative, array[i]);
			max = Math.max(max, array[i]);
		}
		
		if(negative != 0) {
		
			negative = negative * -1;
			max = array[0];
			
		  for(int i=0 ;i<n ;i++) {
			  array[i] = array[i] + negative;
			  max = Math.max(max, array[i]);
		  }		  
		
		}
		
		int[] sort = new int[max+1];
		
		for(int i=0 ; i<=max ; i++)
			sort[i] = -1;
		
		for(int i=0 ; i<n ; i++)
		 sort[array[i]] = array[i];
		
		n = 0;
		
		if(negative != 0) {		
			
			for(int i=0 ; i<=max ; i++)
				if(sort[i] != -1)
				array[n++] = i - negative;		
		}
		else {
		for(int i=0 ; i<=max ; i++)
		if(sort[i] != -1)
		array[n++] = i;
		}
		
		System.out.print("\nSorted array : ");
		for(int i=0 ; i<n ; i++)
			System.out.print(array[i]+" ");
		
		sc.close();
	}
}
