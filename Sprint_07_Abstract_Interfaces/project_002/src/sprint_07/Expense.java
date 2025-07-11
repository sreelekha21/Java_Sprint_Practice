package sprint_07;

import java.util.Scanner;

public class Expense {
    private String name;
    private double amount;
    private String category;
    private String dueDate;

    private static int expenseCount = 0;

    private static final String[] CATEGORIES = {
            "Food", "Rent", "Transport", "Entertainment", "Education", "Others"
    };

    // Constructor
    public Expense(String name, double amount, int categoryIndex, String dueDate) {
        this.name = name;
        this.amount = amount;
        this.dueDate = dueDate;
        if (categoryIndex >= 1 && categoryIndex <= 6) {
            this.category = CATEGORIES[categoryIndex - 1];
        } else {
            this.category = "Others";
        }
        expenseCount++;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(int categoryIndex) {
        if (categoryIndex >= 1 && categoryIndex <= 6) {
            this.category = CATEGORIES[categoryIndex - 1];
        } else {
            this.category = "Others";
        }
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public static int getExpenseCount() {
        return expenseCount;
    }

    public String getSpendingLevel() {
        if (amount < 500) return "Low Spending";
        else if (amount <= 2000) return "Moderate Spending";
        else return "High Spending";
    }

    @Override
    public String toString() {
        return "Expense Name: " + name + "\nAmount: " + amount +
                "\nCategory: " + category + "\nDue Date: " + dueDate +
                "\nSpending Level: " + getSpendingLevel() + "\n";
    }
}

