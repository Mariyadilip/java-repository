package rahul.faq;

public class NumberOfIsland {

	private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {1, 1}, {-1, -1}};
	
	public static void main(String[] args) {
		
		int islands = 0;
		int[][] matrix = {{1, 1, 0, 0, 0},
						  {0, 1, 0, 0, 1},
						  {1, 0, 0, 1, 1},
						  {0, 0, 0, 0, 0},
						  {1, 0, 1, 0, 1}};
		
		for (int i = 0; i < matrix.length; i++) 
		 for (int j = 0; j < matrix[i].length; j++) 
			if(matrix[i][j] == 1) {
				matrix[i][j] = 0;
				islands++;
			   isLand(matrix, i, j);	
			}
		
		System.out.println("Islands : "+islands);
	}
	
	private static void print(int[][] matrix) {
		System.out.println("-----------");
		for(int[] array : matrix) {
		for(int i : array)
		System.out.print(i+" ");
		System.out.println();
		}
	}
	public static void isLand(int[][] matrix, int row, int col) {
		
		for(int i=0 ; i<DIRECTIONS.length ; i++) {
			int x = row + DIRECTIONS[i][0];
			int y = col + DIRECTIONS[i][1];
			
			if(x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length)
			if(matrix[x][y] == 1) {
				//System.out.println("i : "+x+" j : "+y );
				matrix[x][y] = 0;
				isLand(matrix, x, y);
			}
		}
	}
}
