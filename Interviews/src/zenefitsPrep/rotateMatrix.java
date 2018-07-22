package zenefitsPrep;

public class rotateMatrix {

	public static void main(String[] args) {
		int matrix [][] = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		printMatrix(matrix);
		System.out.println();
		transpose(matrix);
		System.out.println("Transposed Matrix: ");
		printMatrix(matrix);
		System.out.println();
		System.out.println("Reversed rows: ");
		reverseRows(matrix);
		printMatrix(matrix);
	}
	
	
	public static void transpose(int mat[][]) {
		int size = mat[0].length;
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				int temp = mat[j][i];
				mat[j][i] = mat[i][j];
				mat[i][j] = temp;
			}
		}
	}
	
	public static void reverseRows(int mat[][]) {
		int size = mat[0].length;
		for (int i = 0; i < size; i++) {
			for (int j = 0, k = size - 1; j < k; j++, k--) {
				int temp = mat[i][k];
				mat[i][k] = mat[i][j];
				mat[i][j] = temp;			
			}
		}
	}
	
	private static void printMatrix(int mat[][]) {
		int rows = mat[0].length;
		int cols = mat[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%2d", mat[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
