package chapter1;

import java.util.HashMap;
import java.util.Random;
/*
Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
*/

public class Question7_try {

	public static void main(String[] args) {
		int rows = 6, columns = 6;
		int [][] matrix1 = createMatrix(rows,columns);
		printMatrix(matrix1,rows,columns);
		HashMap<Integer, Integer> zeroHashMap = findZeros(matrix1,rows,columns);
		int [][] zeroMatrix = createZeroMatrix(matrix1,rows,columns,zeroHashMap);
		System.out.println();
		System.out.println("Creating Zero Matrix: ");
		System.out.println();
		printMatrix(zeroMatrix, rows, columns);
	}
	
	private static int [][] createMatrix(int rows, int columns) {
		Random rng = new Random();
		int [][] matrix = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix [i][j] = rng.nextInt(10);
			}
		}
		//matrix[0][0] = 12;
		//matrix[3][4] = 0;
		//matrix[5][2] = 0;
		return matrix;
	}
	
	private static void printMatrix(int [][] matrix, int rows, int columns) {
		for (int i = 0 ; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(String.format("%2d", matrix[i][j]) + " ");
			}
			System.out.println();
		}
	}
	
	private static HashMap<Integer, Integer> findZeros(int [][] matrix, int rows, int columns) {
		HashMap<Integer, Integer> zeros = new HashMap<Integer, Integer>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (matrix[i][j] == 0) {
					zeros.put(i, j);
				}
			}
		}
		return zeros;
	}
	
	private static int [][] createZeroMatrix(int [][] matrix, int rows, int columns, HashMap<Integer, Integer> zeros) {
		int [][] zeroMatrix = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				zeroMatrix[i][j] = matrix[i][j];
			}
		}
		for (Integer key : zeros.keySet()) {
			Integer val = zeros.get(key);
			for (int i = 0; i < columns; i++) {
				zeroMatrix[key][i] = 0;
			}
			for (int j = 0; j < rows; j++) {
				zeroMatrix[j][val] = 0;
			}
		}
		return zeroMatrix;
	}
}
