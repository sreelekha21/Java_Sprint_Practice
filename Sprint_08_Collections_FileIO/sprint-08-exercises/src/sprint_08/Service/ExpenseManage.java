package sprint_08.Service;
import sprint_08.Entity.Expense;

public class ExpenseManage {
    private Expense[] expenses;
    private int count;

    public ExpenseManage(int size) {
        expenses = new Expense[size];
        count = 0;
    }

    public void addExpense(Expense expense) {
        if (count < expenses.length) {
            expenses[count++] = expense;
        } else {
            System.out.println("Expense limit reached! Cannot add more.");
        }
    }

    public void viewExpenses() {
        if (count == 0) {
            System.out.println("No expenses recorded!");
        } else {
            for (int i = 0; i < count; i++) {
                expenses[i].displayExpenseDetails();
                System.out.println("-----");
            }
        }
    }

    public void calculateTotal() {
        if (count == 0) {
            System.out.println("No expenses recorded!");
        } else {
            double total = 0;
            for (int i = 0; i < count; i++) {
                total += expenses[i].getAmount();
            }
            System.out.println("Total Expense: ₹" + total);
        }
    }
}
