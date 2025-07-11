package exercise_05_02;

import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String input = sc.nextLine();

		String reversed = reverse(input);
		System.out.println("Reversed string: " + reversed);

		sc.close();
	}

	public static String reverse(String str) {
		if (str.isEmpty()) {
			return str;
		}
		return reverse(str.substring(1)) + str.charAt(0);

	}

}
