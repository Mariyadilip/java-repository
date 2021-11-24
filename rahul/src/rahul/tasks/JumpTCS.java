package rahul.tasks;

import java.util.Scanner;


public class JumpTCS {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = sc.nextInt();
		int x = sc.nextInt();
		sc.close();
		System.out.println(jump(n, i, x));
	}
	
	public static int jump(int n, int i, int x) {
		
		if(i == n)return 1;
		if(i > n) return 0;
		
		int max = 0;
		
		for(int j = 1 ; j<=x ;j++)
			max += jump(n, i + j, x);
		
		return max;
	}
}
