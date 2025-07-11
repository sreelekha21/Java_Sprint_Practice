package sprint_09;



import sprint_09.Expense;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseManager implements ExpenseOperations {
    private List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense e) {
        expenses.add(e);
    }

    public List<Expense> viewExpenses() {
        return expenses;
    }

    public double calculateTotal() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    public void sortExpenses() {
        expenses.sort(Comparator.comparingDouble(Expense::getAmount));
    }

    public int searchExpenseByDescription(String desc) {
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).getDescription().equalsIgnoreCase(desc)) {
                return i;
            }
        }
        return -1;
    }

    public List<Expense> filterByType(String type) {
        return expenses.stream()
                .filter(e -> e.getCategory().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    public List<Expense> searchByKeyword(String keyword) {
        return expenses.stream()
                .filter(e -> e.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}