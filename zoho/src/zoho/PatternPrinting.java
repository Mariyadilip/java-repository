package zoho;

public class PatternPrinting {

	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, -1 },
			{ 1, -1 }, { -1, 1 } };

	static int row = 1;
	static int col = 3;
	static int max = 0;

	public static void main(String[] args) {

		/*
		 * ab*c defg
		 */
		char c = ' ';
//		char[][] matrix = {{'b', '*', '*', '*'},
//		                   {'*', '*', '*', '*'},
//		                   {'*', 'a', '*', '*'},
//		                   {'*', '*', '*', 'd'}
//		                  };

		// char[][] matrix = {{'a', 'b', '*', 'c'},{'d', 'e', 'f', 'g'}};

		char[][] matrix = { { 'a', 'b', 'c' } };

		print(matrix);

		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (isChar(matrix[i][j])) {
					int stars = findStars(matrix, i, j);

					if (stars > max) {
						max = stars;
						c = matrix[i][j];
					}

					else if (max > 0 && stars == max && matrix[i][j] < c)
						c = matrix[i][j];
				}

		if (max == 0) {
			System.out.println("No stars surrounded by any character");
			return;
		}

		System.out.println("\n\nCharacter   : " + c);
		System.out.println("Total Stars : " + max);
	}

	private static int findStars(char[][] matrix, int i, int j) {

		int stars = 0;

		for (int k = 0; k < 8; k++) {
			int x = i + DIRECTIONS[k][0];
			int y = j + DIRECTIONS[k][1];
			if (x >= 0 && y >= 0 && x < row && y < col)
				if (matrix[x][y] == '*')
					stars++;
		}

		return stars;
	}

	private static void print(char[][] matrix) {

		for (int i = 0; i < matrix.length; i++, System.out.println())
			for (int j = 0; j < matrix[i].length; j++)
				System.out.print(matrix[i][j] + " ");
	}

	private static boolean isChar(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
			return true;
		return false;
	}
}
