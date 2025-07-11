package sprint_08.Entity;

import java.time.LocalDate;

public class Expense {
    private String name;
    private double amount;
    private String category;
    private LocalDate dueDate;

    public Expense(String name, double amount, String category, LocalDate dueDate) {
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.dueDate = dueDate;
    }

    public double getAmount() {
        return amount;
    }

    public void displayExpenseDetails() {
        System.out.println("Expense Name: " + name);
        System.out.println("Amount: ₹" + amount);
        System.out.println("Category: " + category);
        System.out.println("Due Date: " + dueDate);
    }
}






