package chapter1;

// don't need to keep track of actual zero indexes

import java.util.Random;

public class Question7_sol {

	public static void main(String[] args) {
		int rows = 6, columns = 6;
		int [][] matrix1 = createMatrix(rows,columns);
		printMatrix(matrix1,rows,columns);
		setZeros(matrix1);
		System.out.println();
		System.out.println("Setting to zeros: ");
		System.out.println();
		printMatrix(matrix1,rows,columns);
	}
	
	private static int [][] createMatrix(int rows, int columns) {
		Random rng = new Random();
		int [][] matrix = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix [i][j] = rng.nextInt(10);
			}
		}
		matrix[0][0] = 12;
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
	
	public static void setZeros(int [][] matrix) {
		boolean [] row = new boolean[matrix.length];
		boolean [] column = new boolean[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		// nullify rows
		for (int i = 0 ; i < row.length; i++) {
			if (row[i]) {
				nullifyMatrix(matrix, i, "row");
			}
		}
		// nullify columns
		for (int j = 0; j < column.length;j++) {
			if (column[j]) {
				nullifyMatrix(matrix,j, "column");
			}
		}
	}
	
	private static void nullifyMatrix(int [][] matrix, int index, String identifier) {
		if (identifier == "row") {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[index][j] = 0;
			}
		} else if (identifier == "column") {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][index] = 0;
			}
		}
	}

}
