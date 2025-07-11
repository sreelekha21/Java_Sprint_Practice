package exercise_04_02;

import java.util.Scanner;

public class BoundarySum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Input rows and columns
		System.out.print("Enter number of rows: ");
		int rows = sc.nextInt();

		System.out.print("Enter number of columns: ");
		int cols = sc.nextInt();

		int[][] matrix = new int[rows][cols];

		// Input matrix elements
		System.out.println("Enter matrix elements:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		int sum = 0;
		System.out.println("\nBoundary elements:");

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// Condition for boundary elements
				if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
					System.out.print(matrix[i][j] + " ");
					sum += matrix[i][j];
				} else {
					System.out.print("  "); // spacing for non-boundary cells
				}
			}
			System.out.println();
		}

		System.out.println("\nSum of boundary elements: " + sum);
		sc.close();
	}
}
