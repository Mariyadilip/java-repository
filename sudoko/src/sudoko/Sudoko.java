package sudoko;

public class Sudoko {

	private static final int BOARD_SIZE = 9;
	
	public static void main(String[] args) {
		
//		int[][] board = {{0, 6, 2, 5, 0, 1, 0, 0, 0},
//				         {0, 8, 0, 0, 4, 0, 2, 5, 7},
//				         {4, 5, 9, 0, 2, 0, 6, 0, 3},
//				         {9, 0, 0, 0, 1, 8, 0, 4, 5},
//				         {0, 2, 0, 0, 0, 3, 1, 9, 6},
//				         {0, 0, 7, 0, 0, 6, 0, 3, 0},
//				         {1, 4, 0, 0, 0, 0, 0, 7, 0},
//				         {0, 9, 0, 3, 0, 0, 0, 6, 0},
//				         {0, 0, 3, 0, 8, 0, 4, 2, 0}};
		
	  int[][] board = {{0, 0, 0, 0, 0, 9, 0, 5, 6},
			  		   {0, 6, 0, 5, 0, 7, 4, 1, 0},
			  		   {9, 0, 7, 0, 0, 0, 0, 0, 0},
			  		   {0, 0, 5, 6, 0, 0, 0, 0, 8},
			  		   {8, 3, 0, 0, 0, 0, 0, 7, 1},
			  		   {7, 0, 0, 0, 0, 5, 6, 0, 0},
			  		   {0, 0, 0, 0, 0, 0, 1, 0, 7},
			  		   {0, 1, 4, 7, 0, 6, 0, 9, 0},
			  		   {5, 7, 0, 2, 0, 0, 0, 0, 0}
	  };
		
		System.out.println(" Original board                   \n");
		print(board);
		if(play(board)){
			System.out.println("\n Board Solved                    \n");
			print(board);
		}
		else {
			System.out.println("\n Board cannot be solved                    \n");
			print(board);
		}
	}
	

	private static void print(int[][] board) {
		
		for(int i=0 ;i<BOARD_SIZE ; i++) {
			if(i != 0 && i % 3 == 0) {
				System.out.println("---------------------");
			}
		
			for(int j=0 ; j<BOARD_SIZE ; j++) {
				if(j != 0 && j % 3 == 0)
					System.out.print("| ");
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static boolean isConflictRow(int[][] board, int number, int row) {
		
	 for(int i=0 ; i<BOARD_SIZE ;i++)
	 if(board[row][i] == number)
	 return true;
	 return false;
	 
	}
	private static boolean isConflictColumn(int[][] board, int number, int col) {
		
		 for(int i=0 ; i<BOARD_SIZE ;i++)
		 if(board[i][col] == number)
		 return true;
		 return false;		 
	}
	private static boolean isConflictBox(int[][] board, int number, int row, int col) {
		
		 row = row - (row % 3);
		 col = col - (col % 3);
		 for(int i = row ; i < row + 3 ; i++)
		 for(int j = col ; j < col + 3 ; j++)
		 if(board[i][j] == number)return true;
		 return false;
	}
	private static boolean isValidMove(int[][] board, int number, int row, int col) {
		
		return (!isConflictRow(board, number, row) &&
		   !isConflictColumn(board, number, col) &&
		   !isConflictBox(board, number, row, col));
	
	}
    private static boolean play(int[][] board) {    
    	
    	for(int i=0  ; i<BOARD_SIZE ; i++) {
    		for(int j=0 ; j<BOARD_SIZE ; j++) {
    			if(board[i][j] == 0) {
    				for(int number = 1 ;number < 10 ; number++) {
    					if(isValidMove(board, number, i, j)) {
    						board[i][j] = number;
    						if(play(board))return true;
    						board[i][j] = 0;
    					}
    				}
    				return false;
    			}
    		}
    	}
    	return true;
    }
}
