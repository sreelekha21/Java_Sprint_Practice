package sprint_07;



public class FurnitureStore {
    public static void main(String[] args) {
        Furniture chair = new Furniture("Chair", "Red", "Grade 1", "Outdoor", 1500.0);
        Furniture table = new Furniture("Table", "Blue", "Grade 2", "Indoor", 2500.0);

        chair.displayDetails();
        table.displayDetails();
    }
}
