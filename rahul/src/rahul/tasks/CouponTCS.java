package rahul.tasks;

import java.util.Scanner;

public class CouponTCS {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int o = sc.nextInt();
		int coupon = c;
		while(c > 0) {
			coupon += c / o;
			c = c / o;
		}
		sc.close();
		System.out.println(coupon);
	}
}
