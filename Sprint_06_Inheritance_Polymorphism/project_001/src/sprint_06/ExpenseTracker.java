package sprint_06;

import java.util.Scanner;

public class ExpenseTracker {

    // Expense class defined inside the same file
    static class Expense {
        private String description;
        private double amount;
        private String category;
        private String date;

        // Constructor
        public Expense(String description, double amount, String category, String date) {
            this.description = description;
            this.amount = amount;
            this.category = (category == null || category.isEmpty()) ? "Miscellaneous" : category;
            this.date = date;
        }

        // Method to classify the expense
        public void classifyExpense() {
            if (amount < 500) {
                System.out.println("Category Assessment: Low expense recorded.");
            } else if (amount < 2000) {
                System.out.println("Category Assessment: Moderate expense recorded.");
            } else {
                System.out.println("Category Assessment: High expense recorded.");
            }
        }

        // Method to display expense details
        public void displayExpense() {
            System.out.println("Expense Details:");
            System.out.println("Date: " + date);
            System.out.println("Category: " + category);
            System.out.println("Description: " + description);
            System.out.println("Amount: ₹" + amount);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // First Expense
        System.out.print("Enter first expense description: ");
        String desc1 = sc.nextLine();
        System.out.print("Enter first expense amount: ");
        double amt1 = sc.nextDouble();
        sc.nextLine(); // consume newline

        // Second Expense
        System.out.print("Enter second expense description: ");
        String desc2 = sc.nextLine();
        System.out.print("Enter second expense amount: ");
        double amt2 = sc.nextDouble();
        sc.nextLine(); // consume newline

        // Category and Date (used for second expense)
        System.out.print("Enter category: ");
        String category = sc.nextLine();
        System.out.print("Enter date (DD-MM-YYYY): ");
        String date = sc.nextLine();

        // Creating objects
        Expense e1 = new Expense(desc1, amt1, "", "01-01-2025");
        Expense e2 = new Expense(desc2, amt2, category, date);

        // Output for first expense
        e1.displayExpense();
        e1.classifyExpense();

        System.out.println();

        // Output for second expense
        e2.displayExpense();
        e2.classifyExpense();

        sc.close();
    }
}
