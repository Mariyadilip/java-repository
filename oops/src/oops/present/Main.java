package oops.present;

public class Main {

	public static void main(String[] args) {
		
		    int[] array = {1, 3, 5};
		   System.out.println(java.util.Arrays.toString(array)+"  "+array.length);
		   array =  java.util.Arrays.copyOf(array, 2);
		   System.out.println(java.util.Arrays.toString(array)+" "+array.length);
	}
}
