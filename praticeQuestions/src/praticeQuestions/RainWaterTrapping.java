package praticeQuestions;

//BruteForce approach
/*
 * For each i : 0 to n
 * From i -> loop till start and find maximum (leftmax)
 * 		  -> loop till end and find maximum (rightmax)
 * waterOnBuilding += Min(leftmax, rightmax) - height[i]
 */

//Optimized using //Arrays//
/*
 * initialize : array leftmax and rightmax of size n.
 * for each i : 0 to n
 * Loop 1 (0 to n) : Fill leftmax array
 * 		leftMax[i] = max(leftmax[i-1], height[i])
 * Loop 2(n-1 to 0) : fill rightmax array
 * 		rightmax[i] = max(rightmax[i+1], height[i])
 * Loop 3: calculate water
 * 		WaterOnBuilding += Min(leftmax[i], rightmax[i]) - height[i]
 * 
 */
public class RainWaterTrapping {

	public static void main(String[] args) {

		int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(maxTrapping(heights));
	}

	public static int maxTrapping(int[] heights) {
		
		int capacity = 0;
		
		
		for(int i=0 ; i<heights.length ; i++) {					
			
			int leftmax = heights[i], rightmax = heights[i];
			
		   for(int j=i-1 ; j>=0 ; j--) {
			  leftmax = Math.max(leftmax, heights[j]);			  
		   }
		   
		   for(int j=i+1; j<heights.length; j++) {
			  rightmax = Math.max(rightmax, heights[j]);				  
		   }
		   
		   capacity = capacity + (Math.min(rightmax, leftmax) - heights[i]);
		}
		return capacity;
	}
}
