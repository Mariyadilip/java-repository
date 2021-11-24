package dsa.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static String sort(int[] array) {
		
        for(int i=1 ; i<array.length ; i++) {
			
			int current = array[i];
			int j=i-1;
			
			while(j >= 0 && array[j] > current)
				array[j+1] = array[j--];
		
			array[j+1] = current;
		}
		
		return Arrays.toString(array);
	}
}
