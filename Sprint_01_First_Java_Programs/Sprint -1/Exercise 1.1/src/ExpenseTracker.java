import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

                double[] amounts = new double[3];
                String[] descriptions = new String[3];
                double total = 0.0;

                System.out.println("Welcome to Expense Tracker!");

                // Input for three expenses
                for (int i = 0; i < 3; i++) {
                    System.out.print("Enter " + ordinal(i + 1) + " expense amount (in Rs.): ");
                    amounts[i] = sc.nextDouble();
                    sc.nextLine();  // Consume newline
                    System.out.print("Enter description: ");
                    descriptions[i] = sc.nextLine();
                    total += amounts[i];
                }

                // Display summary
                System.out.println("\nExpenses Recorded:");
                for (int i = 0; i < 3; i++) {
                    System.out.printf("%d. ₹%.1f on %s\n", i + 1, amounts[i], descriptions[i]);
                }

                System.out.printf("Total Expense: ₹%.1f\n", total);

                // Check for budget
                if (total > 1000) {
                    System.out.println("High expense recorded!");
                } else {
                    System.out.println("Within budget!");
                }

                sc.close();
            }

            // Helper method to convert index to ordinal text
            private static String ordinal(int i) {
                return switch (i) {
                    case 1 -> "first";
                    case 2 -> "second";
                    case 3 -> "third";
                    default -> i + "th";
                };
            }
        }


