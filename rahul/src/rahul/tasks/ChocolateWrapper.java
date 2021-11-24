package rahul.tasks;

public class ChocolateWrapper {

	public static void main(String[] args) {
		
		System.out.println(totalChocolates(10, 1, 3));
		System.out.println(totalChocolates(16, 2, 2));
		System.out.println(totalChocolates(15, 1, 3));
		System.out.println(totalChocolates(20, 3, 5));
		System.out.println(totalChocolates(17, 2, 5));
	}
	
	public static int totalChocolates(int price, int totalChocolate, int wrapper) {
		
		
		return price/totalChocolate + choc( price / totalChocolate, wrapper);
		
	}
	
	static int choc(int totalChocolate, int wrapper) {
		
		    
			if(totalChocolate < wrapper)return 0;
		
	    return totalChocolate/wrapper + choc( ((totalChocolate/wrapper) + (totalChocolate % wrapper)), wrapper);
	}
}
