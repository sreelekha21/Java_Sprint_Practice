import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scan.nextInt();

        // Single-line ternary expression to check even or odd
        System.out.println(num + (num % 2 == 0 ? " is an Even number" : " is an Odd number"));

        scan.close();
            }
        }
