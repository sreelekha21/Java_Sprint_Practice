package sprint_07;

import java.util.Scanner;

public class ExpenseTracker_01 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Expense[] expenses = new Expense[100];
            int index = 0;
            String choice;

            do {
                System.out.print("Enter expense name: ");
                String name = sc.nextLine();

                System.out.print("Enter amount: ");
                double amount = sc.nextDouble();
                sc.nextLine(); // consume newline

                System.out.println("Choose Category:");
                System.out.println("1. Food");
                System.out.println("2. Rent");
                System.out.println("3. Transport");
                System.out.println("4. Entertainment");
                System.out.println("5. Education");
                System.out.println("6. Others");

                int categoryChoice = sc.nextInt();
                sc.nextLine(); // consume newline

                System.out.print("Enter due date (e.g., 2025-03-15): ");
                String dueDate = sc.nextLine();

                expenses[index++] = new Expense(name, amount, categoryChoice, dueDate);

                System.out.print("Do you want to add another expense? (yes/no): ");
                choice = sc.nextLine();

            } while (choice.equalsIgnoreCase("yes"));

            // Display all expenses
            System.out.println("\n------ Expense Summary ------");
            for (int i = 0; i < index; i++) {
                System.out.println(expenses[i]);
            }

            System.out.println("Total Expenses Recorded: " + Expense.getExpenseCount());
        }
    }
