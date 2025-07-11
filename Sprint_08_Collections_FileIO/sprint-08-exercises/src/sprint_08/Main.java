package sprint_08;

import sprint_08.Entity.CashExpense;
import sprint_08.Entity.DigitalExpense;
import sprint_08.Service.ExpenseManage;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of expenses to record: ");
        int size = sc.nextInt();
        sc.nextLine();

        ExpenseManage manager = new ExpenseManage(size);

        while (true) {
            System.out.println("\n=== Expense Tracker Menu ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Calculate Total Expenses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (size <= 0) {
                        System.out.println("Expense limit reached! Cannot add more.");
                        break;
                    }
                    System.out.print("Enter expense name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter amount: ₹");
                    double amount = sc.nextDouble();

                    System.out.println("Choose Category:\n1. Food\n2. Rent\n3. Transport\n4. Entertainment\n5. Others");
                    int categoryChoice = sc.nextInt();
                    sc.nextLine();
                    String[] categories = {"Food", "Rent", "Transport", "Entertainment", "Others"};
                    String category = categories[categoryChoice - 1];

                    System.out.print("Enter due date (e.g., 2025-03-15): ");
                    String dateInput = sc.nextLine();
                    LocalDate dueDate = LocalDate.parse(dateInput);

                    System.out.println("Enter 1 for cash");
                    System.out.println("Enter 2 for digital payment");
                    int paymentOption = sc.nextInt();
                    sc.nextLine();

                    if (paymentOption == 1) {
                        manager.addExpense(new CashExpense(name, amount, category, dueDate, "Cash"));
                        size--;
                    } else if (paymentOption == 2) {
                        System.out.print("Enter payment mode: ");
                        String paymentMode = sc.nextLine();
                        System.out.print("Enter transaction ID: ");
                        String transactionId = sc.nextLine();
                        manager.addExpense(new DigitalExpense(name, amount, category, dueDate, paymentMode, transactionId));
                        size--;
                    }
                    break;

                case 2:
                    manager.viewExpenses();
                    break;

                case 3:
                    manager.calculateTotal();
                    break;

                case 4:
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option! Try again");
            }
        }
    }
}
