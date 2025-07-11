package exercise_04_01;

import java.util.Scanner;

public class TrackExpense {
	static int[] expenseAmounts = new int[100];
    static String[] expenseDescriptions = new String[100];
    static String[] expenseCategories = new String[100];
    static int entryCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 6) {
            displayMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addExpense(scanner);
                        break;
                    case 2:
                        displayExpenses();
                        break;
                    case 3:
                        categorizeExpenses(scanner);
                        break;
                    case 4:
                        sortExpenses();
                        break;
                    case 5:
                        searchExpense(scanner);
                        break;
                    case 6:
                        System.out.println("Exiting Expense Tracker.");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    static void displayMenu() {
        System.out.println("\nExpense Tracker Menu:");
        System.out.println("1. Add Expense");
        System.out.println("2. Display Expenses");
        System.out.println("3. Categorize Expenses");
        System.out.println("4. Sort Expenses");
        System.out.println("5. Search for an Expense");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    static void addExpense(Scanner scanner) {
        try {
            System.out.print("Enter expense amount: ");
            int amount = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter description: ");
            String description = scanner.nextLine();

            expenseAmounts[entryCount] = amount;
            expenseDescriptions[entryCount] = description;
            expenseCategories[entryCount] = "Uncategorized";
            entryCount++;
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a number.");
        }
    }

    static void displayExpenses() {
        if (entryCount == 0) {
            System.out.println("No expenses recorded");
            return;
        }
        System.out.println("\nRecorded Expenses:");
        for (int i = 0; i < entryCount; i++) {
            System.out.println("Amount: " + expenseAmounts[i] + " | Description: " + expenseDescriptions[i] + " | Category: " + expenseCategories[i]);
        }
    }

    static void categorizeExpenses(Scanner scanner) {
        if (entryCount == 0) {
            System.out.println("No expenses recorded yet to categorize.");
            return;
        }
        for (int i = 0; i < entryCount; i++) {
            System.out.println("Description: " + expenseDescriptions[i] + " | Current Category: " + expenseCategories[i]);
            System.out.print("Enter category (e.g., Food, Transport, Entertainment): ");
            expenseCategories[i] = scanner.nextLine();
        }
    }

    static void sortExpenses() {
        if (entryCount == 0) {
            System.out.println("No expenses recorded");
            return;
        }
        for (int i = 0; i < entryCount - 1; i++) {
            for (int j = 0; j < entryCount - i - 1; j++) {
                if (expenseAmounts[j] > expenseAmounts[j + 1]) {
                    int tempAmt = expenseAmounts[j];
                    expenseAmounts[j] = expenseAmounts[j + 1];
                    expenseAmounts[j + 1] = tempAmt;

                    String tempDesc = expenseDescriptions[j];
                    expenseDescriptions[j] = expenseDescriptions[j + 1];
                    expenseDescriptions[j + 1] = tempDesc;

                    String tempCat = expenseCategories[j];
                    expenseCategories[j] = expenseCategories[j + 1];
                    expenseCategories[j + 1] = tempCat;
                }
            }
        }
        System.out.println("Expenses sorted successfully!");
    }

    static void searchExpense(Scanner scanner) {
        System.out.print("Enter description to search: ");
        String keyword = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < entryCount; i++) {
            if (expenseDescriptions[i].equalsIgnoreCase(keyword)) {
                System.out.println("Amount: " + expenseAmounts[i] + " | Description: " + expenseDescriptions[i] + " | Category: " + expenseCategories[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Expense not found!");
	}
    }
}
