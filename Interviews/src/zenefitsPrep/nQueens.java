package zenefitsPrep;

public class nQueens {

	public static void main(String[] args) {
		int [][] board = createBoard(4);
		printBoard(board, 4);
		solution(board, 4);
	}
	
	private static int [][] createBoard(int n) {
		int[][] matrix = new int [n][n];
		for (int rows = 0; rows < n; rows++) {
			for (int cols = 0; cols < n; cols++) {
				matrix[rows][cols] = 0;
			}
		}		
		return matrix;
	}
	
	
	private static void printBoard(int mat[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%2d", mat[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	private static void solution(int board[][], int n) {
		int queen = 0;
		while (queen != 4) {
			placeQueen(board, n, queen);
		}
	}
	
	private static void placeQueen(int board[][], int n, int q) {
		for (int row = 0; row < n; row ++) {
			int col = 0;
			board[row][col] = 1;
		}
	}
	
	

}
