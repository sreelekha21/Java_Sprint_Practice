package sprint_09;

import java.time.LocalDate;

public class FoodExpense extends Expense {
    public FoodExpense(String description, double amount, LocalDate date) {
        super(description, amount, "Food", date);
    }
}



// Add other classes: TransportExpense, EntertainmentExpense, OthersExpense as needed.