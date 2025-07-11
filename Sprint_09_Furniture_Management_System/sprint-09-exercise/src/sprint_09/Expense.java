package sprint_09;

import java.time.LocalDate;

public abstract class Expense {
        private String description;
        private double amount;
        private String category;
        private LocalDate date;

        public Expense(String description, double amount, String category, LocalDate date) {
            this.description = description;
            this.amount = amount;
            this.category = category;
            this.date = date;
        }

        public String getDescription() {
            return description;
        }

        public double getAmount() {
            return amount;
        }

        public String getCategory() {
            return category;
        }

        public LocalDate getDate() {
            return date;
        }

        @Override
        public String toString() {
            return String.format("Description: %s | Amount: %.2f | Category: %s | Date: %s",
                    description, amount, category, date.toString());
        }
}
