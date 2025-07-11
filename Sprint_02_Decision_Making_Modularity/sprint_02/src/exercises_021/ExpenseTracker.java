package exercises_021;

import java.util.Scanner;

public class ExpenseTracker {

	// Categorize the expense
	public static String categorizeExpense(double amount) {
		if (amount < 500) {
			return "Low expense";
		} else if (amount >= 500 && amount <= 1999) {
			return "Moderate expense";
		} else {
			return "High expense";
		}
	}

	// Display the recorded expense
	public static void viewExpense(double amount, String description) {
		System.out.println("Recorded expense: ₹" + amount + " on " + description);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Step 1: Accept expense
		System.out.print("Enter expense amount: ₹");
		double amount = scanner.nextDouble();
		scanner.nextLine(); // Clear buffer

		System.out.print("Enter description: ");
		String description = scanner.nextLine();

		System.out.println("\nExpense recorded successfully!\n");

		// Step 2: Show menu once
		System.out.println("Expense Tracker Menu:");
		System.out.println("1. Categorize Expense");
		System.out.println("2. View Expense");
		System.out.println("3. Exit");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();

		// Step 3: Handle menu using switch
		switch (choice) {
		case 1:
			String category = categorizeExpense(amount);
			System.out.println("Expense Category: " + category);
			break;
		case 2:
			viewExpense(amount, description);
			break;
		case 3:
			System.out.println("Exiting Expense Tracker. Goodbye!");
			break;
		default:
			System.out.println("Invalid choice! Please enter a valid option.");
		}

		scanner.close();
	}
}
