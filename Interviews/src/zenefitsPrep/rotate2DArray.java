package zenefitsPrep;

/*
Write a function that takes as input an n X n 2D array, and rotates the 
array by 90 degrees clockwise.
*/

public class rotate2DArray {

	public static void main(String[] args) {
		int matrix [][] = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		
		printMatrix(matrix);
		bruteRotate(matrix);
		inPlaceRotate(matrix);
		printMatrix(matrix);
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
	// returns a new one
	private static void bruteRotate(int mat[][]) {
		int rows = mat[0].length;
		int cols = mat[0].length;
		int newMat [][] = new int[rows][cols];
		
		for (int i = 0; i < rows ; i++) {
			for (int j = 0; j < cols; j++) {
				newMat[j][rows-1-i] = mat[i][j];
			}
		}
		System.out.println();
		System.out.println("Rotated brute force : ");
		System.out.println();
		printMatrix(newMat);
	}
	
	// changes the original - epi
	private static void inPlaceRotate(int mat[][]) {
		int size = mat[0].length-1;
		
		for (int i = 0; i < mat[0].length/2; i++) {
			for (int j = i; j < size - i; j++) {
				int bottom_left = mat[size-j][i];
				int bottom_right = mat[size-i][size-j];
				int top_right = mat[i][size-i];
				int top_left = mat[i][j];
				
				mat[i][j] = bottom_left;
				mat[size-j][i] = bottom_right;
				mat[size-i][size-j] = top_right;
				mat[j][size-i] = top_left;
			}
		}
		
		System.out.println();
		System.out.println("Rotated inPlace : ");
		System.out.println();
	}
	
	// ctci
	public static void rotate (int mat[][]) {
		int n = mat[0].length-1;
		
		for (int layer = 0;layer < n/2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				// save top
				int top = mat[first][i];
				
				// left -> top
				mat[first][i] = mat[last-offset][first];
				
				// bottom -> left
				mat[last - offset][first] = mat[last][last-offset];
				
				// right -> bottom
				mat[last][last-offset] = mat[i][last];
				
				// top -> right
				mat[i][last] = top;
			}
		}
		
		System.out.println();
		System.out.println("Rotated CTCI style : ");
		System.out.println();
	}

}
