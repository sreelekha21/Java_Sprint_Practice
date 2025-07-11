package exercise_03_02;

import java.util.Scanner;

public class ReverseDigits {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number to reverse it: ");
		int number = scanner.nextInt();

		if (number < 0) {
			System.out.println("Input number cannot be negative");
		} else if (number == 0) {
			System.out.println("Input number cannot be zero");
		} else {
			int reversed = 0;
			int original = number;

			while (number != 0) {
				int digit = number % 10;
				reversed = reversed * 10 + digit;
				number = number / 10;
			}
			System.out.println("The reverse of the given number is: " + reversed);
		}
		scanner.close();
	}

}
