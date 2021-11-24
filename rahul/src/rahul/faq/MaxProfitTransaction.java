package rahul.faq;

public class MaxProfitTransaction {

	public static void main(String[] args) {
	
//		System.out.println(maxGrain1(new int[] {30, 30, 10, 50, 10, 100, 30, 40}));
//		System.out.println(maxGrain1(new int[] {15, 25, 35, 45, 55}));
//		System.out.println(maxGrain1(new int[] {2, 1}));
		
//		System.out.println(mySolution(new int[] {30, 30, 10, 50, 10, 100, 30, 40}, 0, 0, false, 2));
//		System.out.println(maxGrain(new int[] {30, 30, 10, 50, 10, 100, 30, 40}));
//		System.out.println(mySolution(new int[] {15, 25, 35, 45, 55}, 0, 0, false, 2));
//		System.out.println(maxGrain(new int[] {15, 25, 35, 45, 55}));
//		System.out.println(maxGrain(new int[] {1, 3, 7, 2, 6}));
//		System.out.println(mySolution(new int[] {1, 3, 7, 2, 6}, 0, 0, false, 2));
		System.out.println(mySolution(new int[] {3, 1, 2, 5, 2, 8, 7}, 0, 0, false, 2));
	}
	
	public static int maxGrain1(int[] price_of_grain) {
		
		int profit = 0;
		
        for (int i = 1; i < price_of_grain.length; i++) {
 
            int sub = price_of_grain[i] - price_of_grain[i - 1];
            if (sub > 0)
                profit += sub;
        }
        return profit;
	}
	
	
	public static int maxGrain(int[] price_of_grain) {
		
		int n = price_of_grain.length;
				
		  int profit[] = new int[n];
	        for (int i = 0; i < n; i++)
	            profit[i] = 0;
	 
	        int max_price = price_of_grain[n - 1];
	        for (int i = n - 2; i >= 0; i--) {
	         
	            if (price_of_grain[i] > max_price)
	                max_price = price_of_grain[i];
	 
	            profit[i] = Math.max(profit[i + 1],
	                                 max_price - price_of_grain[i]);
	        }
	 
	      
	        int min_price = price_of_grain[0];
	        for (int i = 1; i < n; i++) {
	           
	            if (price_of_grain[i] < min_price)
	                min_price = price_of_grain[i];
	 
	            profit[i] = Math.max(
	                profit[i - 1],
	                profit[i] + (price_of_grain[i] - min_price));
	        }
	        
	        int result = profit[n - 1];
	        return result;
	    }
	
	static int mySolution(int[] prices, int stock, int start, boolean bought, int transaction) {		

	    int max = 0;
	    
	    if(transaction == 0)return 0;
	    
		if(bought) {
			for(int i = start ; i<prices.length ; i++) {
				int sell = prices[i] - stock ;
				if(sell > 0) {
				 max = Math.max(max, mySolution(prices, sell, i + 1, false, transaction - 1) + sell);
				}
			}
		}
		else {
			for(int i=start ; i<prices.length ; i++) {
				max = Math.max(mySolution(prices, prices[i], i+1, true, transaction), max);
			}
		}
		
		return max;
	}
}
