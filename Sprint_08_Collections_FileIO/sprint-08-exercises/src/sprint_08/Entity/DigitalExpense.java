package sprint_08.Entity;



import java.time.LocalDate;

public class DigitalExpense extends Expense {
    private String paymentMode;
    private String transactionId;

    public DigitalExpense(String name, double amount, String category, LocalDate dueDate,
                          String paymentMode, String transactionId) {
        super(name, amount, category, dueDate);
        this.paymentMode = paymentMode;
        this.transactionId = transactionId;
    }

    @Override
    public void displayExpenseDetails() {
        super.displayExpenseDetails();
        System.out.println("Payment Mode: " + paymentMode);
        System.out.println("Transaction ID: " + transactionId);
    }
}

