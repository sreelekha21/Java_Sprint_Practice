package sprint_06;

import java.util.Scanner;

// Furniture class with encapsulation
class Furniture {
    private String type;
    private String color;
    private String grade;
    private String use; // "Indoor" or "Outdoor"
    private double price;

    // Constructor
    public Furniture(String type, String color, String grade, String use, double price) {
        this.type = type;
        this.color = color;
        this.grade = grade;
        this.use = use;
        this.price = price;
    }

    // Getters and Setters
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public String getUse() { return use; }
    public void setUse(String use) { this.use = use; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Calculate final price based on use type
    public double calculateFinalPrice() {
        if (use.equalsIgnoreCase("Outdoor")) {
            return price * 0.95; // 5% discount
        } else {
            return price;
        }
    }

    // Display details
    public void displayDetails() {
        System.out.println("------ Furniture Details ------");
        System.out.println("Type        : " + type);
        System.out.println("Color       : " + color);
        System.out.println("Grade       : " + grade);
        System.out.println("Use         : " + use);
        System.out.println("Price       : ₹" + price);
        System.out.println("Final Price : ₹" + calculateFinalPrice());
        System.out.println("-------------------------------------");
    }
}




public class FurnitureStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of furniture items to add: ");
        int count = sc.nextInt();
        sc.nextLine(); // consume newline

        Furniture[] inventory = new Furniture[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for furniture " + (i + 1) + ":");

            System.out.print("Type: ");
            String type = sc.nextLine();

            System.out.print("Color: ");
            String color = sc.nextLine();

            System.out.print("Grade: ");
            String grade = sc.nextLine();

            System.out.print("Use (Indoor/Outdoor): ");
            String use = sc.nextLine();

            System.out.print("Price: ₹");
            double price = sc.nextDouble();
            sc.nextLine(); // consume newline

            inventory[i] = new Furniture(type, color, grade, use, price);
        }

        // Display all furniture
        System.out.println("\n===== Furniture Inventory =====");
        for (Furniture item : inventory) {
            item.displayDetails();
        }
    }
}

