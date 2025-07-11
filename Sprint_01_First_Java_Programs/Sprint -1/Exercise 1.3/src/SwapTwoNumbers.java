import java.util.Scanner;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter first number (num1): ");
        int num1 = scan.nextInt();

        System.out.print("Enter second number (num2): ");
        int num2 = scan.nextInt();

        // Swapping without temp using arithmetic
        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;

        System.out.println("After swapping:");
        System.out.println("First number (num1): " + num1);
        System.out.println("Second number (num2): " + num2);

        scan.close();

    }
}
