package sprint_09;


import  sprint_09.Expense;
import java.util.List;

public interface ExpenseOperations {
    void addExpense(Expense e);
    List<Expense> viewExpenses();
    double calculateTotal();
    void sortExpenses();
    int searchExpenseByDescription(String desc);
    List<Expense> filterByType(String type);
    List<Expense> searchByKeyword(String keyword);
}

