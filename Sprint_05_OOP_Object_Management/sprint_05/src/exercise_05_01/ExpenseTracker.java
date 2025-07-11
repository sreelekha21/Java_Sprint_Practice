package exercise_05_01;


import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String description;
    int amount;
    String category;

    Expense(String description, int amount) {
        this.description = description;
        this.amount = amount;
        this.category = null;
    }

    public String toString() {
        return "Recorded expense: ₹" + amount + " on " + description;
    }
}

public class ExpenseTracker {
    static ArrayList<Expense> expenses = new ArrayList<>();
    static boolean isCategorized = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense.");
            System.out.println("2. Display Expenses.");
            System.out.println("3. Categorize Expenses.");
            System.out.println("4. Sort Expenses.");
            System.out.println("5. Search for an Expense.");
            System.out.println("6. Filter by Expense Type.");
            System.out.println("7. Search by Keyword in Expense Description.");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
                System.out.print("Enter your choice: ");
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addExpense(sc);
                    break;
                case 2:
                    displayExpenses();
                    break;
                case 3:
                    categorizeExpenses(sc);
                    break;
                case 4:
                    sortExpenses();
                    break;
                case 5:
                    searchExpense(sc);
                    break;
                case 6:
                    filterByType(sc);
                    break;
                case 7:
                    searchByKeyword(sc);
                    break;
                case 8:
                    System.out.println("Exiting Expense Tracker.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 8);

        sc.close();
    }

    static void addExpense(Scanner sc) {
        System.out.print("Enter description: ");
        String desc = sc.nextLine();
        System.out.print("Enter amount: ");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid amount.");
            sc.next();
        }
        int amount = sc.nextInt();
        sc.nextLine();
        expenses.add(new Expense(desc, amount));
        System.out.println("Expense added successfully.");
    }

    static void displayExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded");
            return;
        }
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    static void categorizeExpenses(Scanner sc) {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded");
            return;
        }

        for (Expense e : expenses) {
            System.out.print("Enter category for: " + e.description + " (₹" + e.amount + "): ");
            String cat = sc.nextLine().trim();
            while (cat.isEmpty()) {
                System.out.print("Category cannot be empty. Re-enter: ");
                cat = sc.nextLine().trim();
            }
            e.category = cat;
        }
        isCategorized = true;
        System.out.println("Expenses categorized successfully.");
    }

    static void sortExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded");
            return;
        }
        expenses.sort((e1, e2) -> Integer.compare(e1.amount, e2.amount));
        System.out.println("Expenses sorted by amount.");
    }

    static void searchExpense(Scanner sc) {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded");
            return;
        }
        System.out.print("Enter amount to search: ");
        int target = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        for (Expense e : expenses) {
            if (e.amount == target) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching expense found.");
        }
    }

    static void filterByType(Scanner sc) {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded");
            return;
        }
        if (!isCategorized) {
            System.out.println("Records not categorized. Categorize the expense using case 3.");
            return;
        }

        System.out.print("Enter expense type to filter: ");
        String type = sc.nextLine().trim().toLowerCase();
        boolean found = false;

        for (Expense e : expenses) {
            if (e.category != null && e.category.toLowerCase().equals(type)) {
                System.out.println(e);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching expenses found.");
        }
    }

    static void searchByKeyword(Scanner sc) {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded");
            return;
        }

        System.out.print("Enter keyword to search: ");
        String keyword = sc.nextLine().toLowerCase();
        boolean found = false;

        for (Expense e : expenses) {
            if (e.description.toLowerCase().contains(keyword)) {
                System.out.println(e);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching expenses found.");
        }
    }
}
