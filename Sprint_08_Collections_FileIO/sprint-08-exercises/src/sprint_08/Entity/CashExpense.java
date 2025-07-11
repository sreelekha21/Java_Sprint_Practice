package sprint_08.Entity;

import java.time.LocalDate;

public class CashExpense extends Expense {
    private String paymentMode;

    public CashExpense(String name, double amount, String category, LocalDate dueDate, String paymentMode) {
        super(name, amount, category, dueDate);
        this.paymentMode = paymentMode;
    }

    @Override
    public void displayExpenseDetails() {
        super.displayExpenseDetails();
        System.out.println("Payment Mode: " + paymentMode);
    }
}
