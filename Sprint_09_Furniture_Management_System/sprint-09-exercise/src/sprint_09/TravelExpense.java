package sprint_09;



import java.time.LocalDate;

public class TravelExpense extends Expense {
    public TravelExpense(String description, double amount, LocalDate date) {
        super(description, amount, "Travel", date);
    }
}


