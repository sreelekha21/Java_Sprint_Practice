package sprint_09;


import java.time.LocalDate;

public class UtilityExpense extends Expense {
    public UtilityExpense(String description, double amount, LocalDate date) {
        super(description, amount, "Utility", date);
    }
}
