package exercises_021;

import java.util.Scanner;

public class Fencing_a_Barn {

	// Method to calculate square area
	public static double calculateSquareArea(double side) {
		return side * side;
	}

	// Method to calculate circular area
	public static double calculateCircleArea(double radius) {
		return Math.PI * radius * radius;
	}

	// Method to calculate rectangular area
	public static double calculateRectangleArea(double length, double width) {
		return length * width;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Display menu
		System.out.println("Select an option from list to calculate area of fence");
		System.out.println("1. Square area for the chickens");
		System.out.println("2. Circular area for ducks");
		System.out.println("3. Rectangular area for cows");

		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			System.out.println("Enter side of square");
			double side = scanner.nextDouble();
			double squareArea = calculateSquareArea(side);
			System.out.println("Area of square fence for chickens is " + squareArea);
			break;

		case 2:
			System.out.println("Enter radius of circle");
			double radius = scanner.nextDouble();
			double circleArea = calculateCircleArea(radius);
			System.out.println("Area of circular fence for ducks is " + Math.round(circleArea * 10.0) / 10.0); // rounded
																												// to 1
																												// decimal
			break;

		case 3:
			System.out.println("Enter length of rectangle");
			double length = scanner.nextDouble();
			System.out.println("Enter width of rectangle");
			double width = scanner.nextDouble();
			double rectangleArea = calculateRectangleArea(length, width);
			System.out.println("Area of rectangular fence for cows is " + rectangleArea);
			break;

		default:
			System.out.println("Invalid option selected.");
		}

		scanner.close();
	}

}
