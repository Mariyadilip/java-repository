package zoho_saturday;

import java.util.Scanner;


public class Ques5 {

	final static int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};  
	static int ROW, COL;
	static int startX, startY;
	static int endX, endY;
	static int shortestDistance=999;
	static int[][] result;
	static int SIZE;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of row : ");
		 ROW = sc.nextInt();
		System.out.print("\nEnter no of column : ");
		 COL = sc.nextInt();
		System.out.print("\nEnter starting point separted by space (x, y) : ");
		 startX = sc.nextInt();
		 startY = sc.nextInt();
		System.out.print("\nEnter destination point separted by space (x, y) : ");
		 endX = sc.nextInt();
		 endY = sc.nextInt();
		
		int[][] matrix = new int[ROW][COL];
		int[][] visited = new int[ROW][COL];
		
		System.out.println("------------------\nEnter points \n ----------------\n ");
		
		for(int i=0 ; i<ROW ; i++)
			for(int j=0 ; j<COL ; j++)
				matrix[i][j] = sc.nextInt();
		
		int[][] path = new int[ROW*COL][2];
		 result = new int[ROW*COL][2];
		
		findPath(matrix, startX, startY, path, 0,0 , visited);
		
		if(SIZE > 0) {
			System.out.println("\n---------path Found----------\n"+startX+", "+startY);
			for(int i=0 ; i<SIZE ; i++)
				System.out.println(result[i][0]+", "+result[i][1]);
		}
		else
			System.out.println("No Path!");
		
		sc.close();
	}

	private static void findPath(int[][] matrix, int row, int col, int[][] path, int size, int distance, int[][] visited) {
		
		if(row == endX && col == endY) {
			if(distance < shortestDistance) {
				shortestDistance = distance;
				SIZE = size;
				copyPath(path, size);				
			}
			return;
		}
		
		for(int i=0 ; i<8 ; i++) {
			int x = row + DIRECTIONS[i][0];
			int y = col + DIRECTIONS[i][1];
			
			if(x < ROW && y < COL && x > -1 && y > -1)
			if(matrix[x][y] == 1 && visited[x][y] == 0) {
				path[size][0] = x;
				path[size][1] = y;				
				visited[x][y] = 1;
				findPath(matrix, x, y, path, size+1, distance+1, visited);
				visited[x][y] = 0;
			}
						
		}
	}
	
	private static void copyPath(int[][] path, int size) {
		
		for(int i=0 ;i<size ; i++) {
			result[i][0] = path[i][0];
		    result[i][1] = path[i][1];
		}
	}
}

/*
 *
1 0 0 1 
1 0 1 0 
1 0 1 0 
0 0 1 0 
1 0 1 1 

*/