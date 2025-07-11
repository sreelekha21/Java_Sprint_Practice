package sprint_09;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ExpenseTrackerApp {
    public static void main(String[] args) {
        ExpenseOperations manager = new ExpenseManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Calculate Total Expenses");
            System.out.println("4. Sort Expenses");
            System.out.println("5. Search for an Expense");
            System.out.println("6. Filter by Expense Type");
            System.out.println("7. Search by Keyword in Expense Description");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter category (Travel/Food/Utility): ");
                    String cat = sc.nextLine();
                    Expense e = switch (cat.toLowerCase()) {
                        case "travel" -> new TravelExpense(desc, amt, LocalDate.now());
                        case "food" -> new FoodExpense(desc, amt, LocalDate.now());
                        case "utility" -> new UtilityExpense(desc, amt, LocalDate.now());
                        default -> null;
                    };
                    if (e != null) manager.addExpense(e);
                    else System.out.println("Invalid category.");
                }
                case 2 -> {
                    List<Expense> all = manager.viewExpenses();
                    if (all.isEmpty()) System.out.println("No expenses recorded.");
                    else all.forEach(System.out::println);
                }
                case 3 -> System.out.println("Total: " + manager.calculateTotal());
                case 4 -> {
                    if (manager.viewExpenses().isEmpty()) System.out.println("No expenses recorded.");
                    else {
                        manager.sortExpenses();
                        System.out.println("Expenses sorted successfully!");
                        manager.viewExpenses().forEach(System.out::println);
                    }
                }
                case 5 -> {
                    if (manager.viewExpenses().isEmpty()) System.out.println("No expenses recorded.");
                    else {
                        System.out.print("Enter description to search: ");
                        String sdesc = sc.nextLine();
                        int idx = manager.searchExpenseByDescription(sdesc);
                        if (idx >= 0) System.out.println("Expense found at position: " + idx);
                        else System.out.println("Expense not found!");
                    }
                }
                case 6 -> {
                    if (manager.viewExpenses().isEmpty()) System.out.println("No expenses recorded");
                    else {
                        System.out.print("Enter expense type: ");
                        String type = sc.nextLine();
                        List<Expense> filtered = manager.filterByType(type);
                        if (filtered.isEmpty()) System.out.println("No expenses recorded");
                        else filtered.forEach(System.out::println);
                    }
                }
                case 7 -> {
                    if (manager.viewExpenses().isEmpty()) System.out.println("No expenses recorded");
                    else {
                        System.out.print("Enter keyword: ");
                        String kw = sc.nextLine();
                        List<Expense> results = manager.searchByKeyword(kw);
                        if (results.isEmpty()) System.out.println("Expense not found!");
                        else results.forEach(exp ->
                                System.out.println(exp.getAmount() + " " + exp.getDescription()));
                    }
                }
                case 8 -> {
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option! Try again.");
            }
        }

    }
}
