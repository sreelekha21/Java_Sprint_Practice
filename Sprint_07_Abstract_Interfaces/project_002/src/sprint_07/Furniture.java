package sprint_07;

public class Furniture {
    // Attributes (private for encapsulation)
    private String type;   // e.g., Chair, Table, Cupboard, Stool
    private String color;  // e.g., Red, Blue, Green
    private String grade;  // e.g., Grade 1, Grade 2, Grade 3
    private String use;    // Indoor or Outdoor
    private double price;

    // Fixed discount as per requirement (static + final)
    private static final double DISCOUNT = 0.05;

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

    // Method that applies discount only for Outdoor use
    public double calculateDiscount() {
        if (use.equalsIgnoreCase("Outdoor")) {
            return price - (price * DISCOUNT);
        } else {
            return price;
        }
    }

    // Method to display furniture details
    public void displayDetails() {
        System.out.println("------ Furniture Details ------");
        System.out.println("Type        : " + type);
        System.out.println("Color       : " + color);
        System.out.println("Grade       : " + grade);
        System.out.println("Use         : " + use);
        System.out.println("Price       : ₹" + price);
        System.out.println("Final Price : ₹" + calculateDiscount());
        System.out.println("-------------------------------------");
    }
}
