package exercise_03_01;

import java.util.Scanner;

public class ExpenseTracker {

	// Categorization method (based on amount)
	public static String[] categorizeExpenses(double[] amounts, int count) {
		String[] categories = new String[count];
		for (int i = 0; i < count; i++) {
			if (amounts[i] < 100) {
				categories[i] = "Low";
			} else if (amounts[i] <= 500) {
				categories[i] = "Medium";
			} else {
				categories[i] = "High";
			}
		}
		return categories;
	}

	// Display recorded expenses and descriptions
	public static void displayExpenses(double[] amounts, String[] descriptions, int count) {
		for (int i = 0; i < count; i++) {
			System.out.println("Amount: " + amounts[i] + ", Description: " + descriptions[i]);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of expenses you want to record: ");
		int size = scanner.nextInt();

		double[] expenseAmounts = new double[size];
		String[] expenseDescriptions = new String[size];
		String[] expenseCategories = new String[size];
		int expenseCount = 0;

		int choice;
		do {
			System.out.println("\nExpense Tracker Menu:");
			System.out.println("1. Add Expense");
			System.out.println("2. Categorize Expense");
			System.out.println("3. View Expense");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				if (expenseCount < size) {
					System.out.print("Enter expense amount: ");
					expenseAmounts[expenseCount] = scanner.nextDouble();
					scanner.nextLine(); // Consume newline
					System.out.print("Enter expense description: ");
					expenseDescriptions[expenseCount] = scanner.nextLine();
					expenseCount++;
				} else {
					System.out.println("Expense limit reached! Cannot add more.");
				}
				break;

			case 2:
				if (expenseCount == 0) {
					System.out.println("No expenses recorded!");
				} else {
					expenseCategories = categorizeExpenses(expenseAmounts, expenseCount);
					System.out.println("Expense Categories:");
					for (int i = 0; i < expenseCount; i++) {
						System.out.println("Amount: " + expenseAmounts[i] + ", Category: " + expenseCategories[i]);
					}
				}
				break;

			case 3:
				if (expenseCount == 0) {
					System.out.println("No expenses recorded!");
				} else {
					displayExpenses(expenseAmounts, expenseDescriptions, expenseCount);
				}
				break;

			case 4:
				System.out.println("Exiting Expense Tracker.");
				break;

			default:
				System.out.println("Invalid choice! Please enter a valid option.");
			}

		} while (choice != 4);

		scanner.close();
	}
}
